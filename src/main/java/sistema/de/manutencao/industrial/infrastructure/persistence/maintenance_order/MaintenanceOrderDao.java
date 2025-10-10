package sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceOrderDao {

    public List<MaintenanceOrderEntity> getAllPending() {
        return null;
    }

    public void save(MaintenanceOrderEntity maintenanceOrderEntity) {

        String query = """
                INSERT INTO OrdemManutencao
                ( 
                idMaquina, 
                idTecnico, 
                dataSolicitacao
                status 
                )
                
                VALUES (?, ?, ?, ?)
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setLong(1, maintenanceOrderEntity.getMachineEntity().getId());
            statement.setLong(2, maintenanceOrderEntity.getTechnicianEntity().getId());
            statement.setDate(3, Date.valueOf(maintenanceOrderEntity.getRequestDate()));
            statement.setString(4, maintenanceOrderEntity.getStatus().toString());

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

}
