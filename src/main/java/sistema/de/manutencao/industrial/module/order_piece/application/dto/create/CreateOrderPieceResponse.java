package sistema.de.manutencao.industrial.module.order_piece.application.dto.create;

public record CreateOrderPieceResponse(long idMaintenanceOrder, long idPiece, double quantity){
}
