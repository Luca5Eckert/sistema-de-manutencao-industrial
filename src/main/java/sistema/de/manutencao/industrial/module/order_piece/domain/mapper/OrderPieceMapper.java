package sistema.de.manutencao.industrial.module.order_piece.domain.mapper;

import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceResponse;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceEntity;

public class OrderPieceMapper {
    public CreateOrderPieceResponse toCreateResponse(OrderPieceEntity orderPieceEntity) {
        long idMaintanance = orderPieceEntity.getOrderPieceId().getMaintenanceOrderEntity().getId();
        long idPiece = orderPieceEntity.getOrderPieceId().getPieceEntity().getId();

        return new CreateOrderPieceResponse(idMaintanance, idPiece, orderPieceEntity.getQuantity());
    }
}
