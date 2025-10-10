package sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
                WHERE status = ?
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {

            statement.setString(1, "PENDENTE");

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    long idTechnician = resultSet.getLong("idTecnico");
                    long idMachine = resultSet.getLong("idMaquina");
                    String nameMachine = resultSet.getString("nomeMaquina");

                    MachineEntity machine = new MachineEntity(idMachine, nameMachine);
                    TechnicianEntity technician = new TechnicianEntity(idTechnician);

                    long orderId = resultSet.getLong("idOrdem");
                    LocalDate dateRequest = resultSet.getDate("dataSolicitacao").toLocalDate();

                    MaintenanceOrderEntity maintenanceOrder = new MaintenanceOrderEntity(orderId, machine, technician, dateRequest);

                    maintenanceOrderEntityList.add(maintenanceOrder);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
}
