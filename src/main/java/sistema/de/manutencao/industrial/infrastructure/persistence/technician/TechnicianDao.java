package sistema.de.manutencao.industrial.infrastructure.persistence.technician;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TechnicianDao {

    public boolean isUnique(TechnicianEntity technicianEntity) {
        String query = """
                SELECT 0
                FROM tecnico
                WHERE nome = ?
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, technicianEntity.getName());

            ResultSet resultSet = statement.executeQuery();

            return !resultSet.next();

        } catch ( SQLException sqlException){

            throw new RuntimeException(sqlException.getMessage());

        }

    }

    public void save(TechnicianEntity technicianEntity) {
        String query = """
                INSERT INTO tecnico
                (nome, especialidade)
                VALUES ( ?, ? );
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, technicianEntity.getName());
            statement.setString(2, technicianEntity.getSpecialty());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
