package sistema.de.manutencao.industrial.module.order_piece.domain.port;

import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceEntity;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceId;

public interface OrderPieceRepository {
    void create(OrderPieceEntity orderPieceEntity);

    boolean isUnique(OrderPieceId orderPieceId);
}
