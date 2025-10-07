package sistema.de.manutencao.industrial.module.order_piece.domain;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

public class OrderPieceEntity {

    private final OrderPieceId orderPieceId;

    private double quantidade;

    public OrderPieceEntity(OrderPieceId orderPieceId, double quantidade) {
        this.orderPieceId = orderPieceId;
        this.quantidade = quantidade;
    }

    public OrderPieceId getOrderPieceId() {
        return orderPieceId;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }


}
