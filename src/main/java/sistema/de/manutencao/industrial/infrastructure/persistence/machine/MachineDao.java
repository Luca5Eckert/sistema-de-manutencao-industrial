package sistema.de.manutencao.industrial.infrastructure.persistence.machine;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineDao {


    public boolean isNotUniqueInTheSector(MachineEntity machine) {
        String query = """
                SELECT 0 
                FROM maquina 
                WHERE nome = ? 
                AND setor = ?
                """;

        try( Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, machine.getName());
            statement.setString(2, machine.getSector());

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }


    public void save(MachineEntity machine) {
        String query = """
                INSERT INTO maquina 
                ( nome, setor, status )
                VALUES (?, ?, ?)
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, machine.getName());
            statement.setString(2, machine.getSector());
            statement.setString(3, machine.getStatus().toString());

            statement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public List<MachineEntity> getAllPedent() {
        List<MachineEntity> machineEntityList = new ArrayList<>();
        String query = """
                SELECT id, nome, setor, status
                FROM maquina
                WHERE status = ?
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)
        ){

            statement.setString(1, "OPERACIONAL");

            try ( ResultSet resultSet = statement.executeQuery()){

                while(resultSet.next()){
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("nome");
                    String sector = resultSet.getString("setor");
                    String status = resultSet.getString("status");

                    MachineEntity machine = new MachineEntity(id, name, sector, OperationalStatus.valueOf(status));
                    machineEntityList.add(machine);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return machineEntityList;

    }

    public void changeStatus(long id, OperationalStatus operationalStatus) {
        String query = """
                UPDATE maquina
                SET status = ?
                WHERE id = ?
                """;

        try( Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, operationalStatus.toString());
            statement.setLong(2, id);

            statement.executeUpdate();

        } catch (SQLException sqlException){
            throw new RuntimeException(sqlException.getMessage());
        }


    }
}
