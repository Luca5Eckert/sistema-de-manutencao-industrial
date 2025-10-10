package sistema.de.manutencao.industrial.infrastructure.persistence.piece;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceDao {

    public void save(PieceEntity piece) {
        String query = """
                INSERT INTO peca
                (nome, estoque)
                VALUES ( ?, ? );
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, piece.getName());
            statement.setDouble(2, piece.getStock());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isUnique(PieceEntity piece) {
        String query = """
                SELECT 0
                FROM peca
                WHERE nome = ?
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, piece.getName());

            ResultSet resultSet = statement.executeQuery();

            return !resultSet.next();

        } catch (SQLException sqlException) {

            throw new RuntimeException(sqlException.getMessage());

        }

    }

    public List<PieceEntity> getAll() {
        List<PieceEntity> pieceEntityList = new ArrayList<>();
        String query = """
                SELECT id, nome, estoque
                FROM peca
                """;

        try (Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()
        ) {


            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("nome");
                long socket = resultSet.getLong("estoque");

                PieceEntity piece = new PieceEntity(id, name, socket);
                pieceEntityList.add(piece);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pieceEntityList;
    }
}
