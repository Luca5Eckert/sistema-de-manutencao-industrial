package sistema.de.manutencao.industrial.infrastructure.persistence.machine;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
