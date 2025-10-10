package sistema.de.manutencao.industrial.infrastructure.persistence.order_piece;

import sistema.de.manutencao.industrial.infrastructure.persistence.connection.ConnectionDatabase;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceEntity;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderPieceDao {

    public void create(OrderPieceEntity orderPieceEntity) {
        String query = """
                INSERT INTO ordempeca
                (idOrdem, idPeca, quantidade)
                VALUES
                (?, ?, ?)
                """;

        try(Connection connection = ConnectionDatabase.toInstance();
            PreparedStatement statement = connection.prepareStatement(query)){

            var orderPieceId = orderPieceEntity.getOrderPieceId();

            statement.setLong(1, orderPieceId.getMaintenanceOrderEntity().getId());
            statement.setLong(2, orderPieceId.getPieceEntity().getId());
            statement.setDouble(3, orderPieceEntity.getQuantity());

            statement.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public boolean isUnique(OrderPieceId orderPieceId) {
        String query = """
                SELECT 0
                FROM ordempeca
                WHERE idOrdem = ?
                AND idPeca = ?
                """;

        try( Connection connection = ConnectionDatabase.toInstance();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, orderPieceId.getMaintenanceOrderEntity().getId());
            statement.setLong(2, orderPieceId.getPieceEntity().getId());

            ResultSet resultSet = statement.executeQuery();

            return !resultSet.next();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

}