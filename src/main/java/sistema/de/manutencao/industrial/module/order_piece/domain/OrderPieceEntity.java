package sistema.de.manutencao.industrial.module.order_piece.domain;

public class OrderPieceEntity {

    private final OrderPieceId orderPieceId;

    private double quantity;

    public OrderPieceEntity(OrderPieceId orderPieceId, double quantity) {
        this.orderPieceId = orderPieceId;
        this.quantity = quantity;
    }

    public OrderPieceId getOrderPieceId() {
        return orderPieceId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


}
