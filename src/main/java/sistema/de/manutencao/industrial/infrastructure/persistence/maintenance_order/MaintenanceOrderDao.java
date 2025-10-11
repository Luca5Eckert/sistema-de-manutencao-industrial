package sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MaintenanceOrderDao {

    public List<MaintenanceOrderEntity> getAllPending() {
        List<MaintenanceOrderEntity> maintenanceOrderEntityList = new ArrayList<>();
        String query = """
                SELECT
                om.id idOrdem
                , om.idTecnico
                , om.idMaquina
                , om.dataSolicitacao
                , om.status
                , m.nome nomeMaquina
                FROM ordemmanutencao om
                JOIN maquina m ON m.id = om.idMaquina
                WHERE om.status = ?
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {

            statement.setString(1, MaintenanceOrderStatus.PENDENTE.toString());

            try(ResultSet resultSet =statement.executeQuery()){

                while (resultSet.next()) {
                    long idTechnician = resultSet.getLong("idTecnico");
                    long idMachine = resultSet.getLong("idMaquina");
                    String nameMachine = resultSet.getString("nomeMaquina");

                    MachineEntity machine = new MachineEntity(idMachine, nameMachine);
                    TechnicianEntity technician = new TechnicianEntity(idTechnician);

                    long orderId = resultSet.getLong("idOrdem");
                    LocalDate dateRequest = resultSet.getDate("dataSolicitacao").toLocalDate();
                    String status = resultSet.getString("status");

                    MaintenanceOrderEntity maintenanceOrder = new MaintenanceOrderEntity(orderId, machine, technician, dateRequest);
                    maintenanceOrder.setStatus(MaintenanceOrderStatus.valueOf(status));

                    maintenanceOrderEntityList.add(maintenanceOrder);
                }

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return maintenanceOrderEntityList;
    }

    public void save(MaintenanceOrderEntity maintenanceOrderEntity) {

        String query = """
                INSERT INTO ordemmanutencao
                (
                idMaquina, idTecnico, dataSolicitacao, status
                )
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, maintenanceOrderEntity.getMachineEntity().getId());
            statement.setLong(2, maintenanceOrderEntity.getTechnicianEntity().getId());
            statement.setDate(3, Date.valueOf(maintenanceOrderEntity.getRequestDate()));
            statement.setString(4, maintenanceOrderEntity.getStatus().toString());

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public List<MaintenanceOrderEntity> getALl() {
        List<MaintenanceOrderEntity> maintenanceOrderEntityList = new ArrayList<>();
        String query = """
                SELECT
                om.id idOrdem
                , om.idTecnico
                , om.idMaquina
                , om.dataSolicitacao
                , om.status
                , m.nome nomeMaquina
                FROM ordemmanutencao om
                JOIN maquina m ON m.id = om.idMaquina
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()
        ) {


            while (resultSet.next()) {
                long idTechnician = resultSet.getLong("idTecnico");
                long idMachine = resultSet.getLong("idMaquina");
                String nameMachine = resultSet.getString("nomeMaquina");

                MachineEntity machine = new MachineEntity(idMachine, nameMachine);
                TechnicianEntity technician = new TechnicianEntity(idTechnician);

                long orderId = resultSet.getLong("idOrdem");
                LocalDate dateRequest = resultSet.getDate("dataSolicitacao").toLocalDate();
                String status = resultSet.getString("status");

                MaintenanceOrderEntity maintenanceOrder = new MaintenanceOrderEntity(orderId, machine, technician, dateRequest);
                maintenanceOrder.setStatus(MaintenanceOrderStatus.valueOf(status));

                maintenanceOrderEntityList.add(maintenanceOrder);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return maintenanceOrderEntityList;
    }

    public Optional<MaintenanceOrderViewResponse> getMaintenanceById(long id) {
        String query = """
                SELECT
                om.id idOrdem
                , om.idTecnico
                , om.idMaquina
                , m.nome nomeMaquina
                , t.nome nomeTecnico
                FROM ordemmanutencao om
                JOIN maquina m ON m.id = om.idMaquina
                JOIN tecnico t ON t.id = om.idTecnico
                WHERE om.id = ?
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query);
        ) {

            statement.setLong(1, id);

            try(ResultSet resultSet = statement.executeQuery()){

                if (resultSet.next()) {
                    long idTechnician = resultSet.getLong("idTecnico");
                    String nameTechnician = resultSet.getString("nomeTecnico");

                    long idMachine = resultSet.getLong("idMaquina");
                    String nameMachine = resultSet.getString("nomeMaquina");

                    HashMap<Double, Double> resources = getResourcesByMaintenanceId(connection, id);

                    return Optional.of(new MaintenanceOrderViewResponse(id, idMachine, nameMachine, idTechnician, nameTechnician, resources ));
                }

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.empty();

    }

    public HashMap<Double, Double> getResourcesByMaintenanceId(long idOrdem) {

        HashMap<Double, Double> resources = new HashMap<>();

        String query = """
            SELECT
            p.estoque
            op.quantidade
            FROM OrdemPeca op
            JOIN Peca p ON p.id = op.idPeca
            WHERE op.idOrdem = ?
            """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, idOrdem);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    double estoque = resultSet.getDouble("estoque");
                    double quantidadePedida = resultSet.getDouble("quantidade");

                    resources.put(estoque, quantidadePedida);
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

        return resources;

    }

    private HashMap<Double, Double> getResourcesByMaintenanceId(Connection connection, long idOrdem) throws SQLException {

        HashMap<Double, Double> resources = new HashMap<>();

        String query = """
            SELECT
            p.estoque,       -- Estoque da Peca
            op.quantidade    -- Quantidade pedida na OrdemPeca
            FROM OrdemPeca op
            JOIN Peca p ON p.id = op.idPeca
            WHERE op.idOrdem = ?
            """;

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, idOrdem);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    double estoque = resultSet.getDouble("estoque");
                    double quantidadePedida = resultSet.getDouble("quantidade");

                    resources.put(estoque, quantidadePedida);
                }
            }
        }

        return resources;

    }


}
