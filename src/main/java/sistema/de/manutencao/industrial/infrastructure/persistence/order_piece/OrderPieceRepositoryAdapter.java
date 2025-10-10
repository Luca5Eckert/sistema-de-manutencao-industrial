package sistema.de.manutencao.industrial.infrastructure.persistence.order_piece;

import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceEntity;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceId;
import sistema.de.manutencao.industrial.module.order_piece.domain.port.OrderPieceRepository;

public class OrderPieceRepositoryAdapter implements OrderPieceRepository {

    private final OrderPieceDao orderPieceDao;

    public OrderPieceRepositoryAdapter(OrderPieceDao orderPieceDao) {
        this.orderPieceDao = orderPieceDao;
    }

    @Override
    public void create(OrderPieceEntity orderPieceEntity) {
        orderPieceDao.create(orderPieceEntity);
    }

    @Override
    public boolean isUnique(OrderPieceId orderPieceId) {
        return orderPieceDao.isUnique(orderPieceId);
    }

}
