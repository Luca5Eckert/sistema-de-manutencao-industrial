package sistema.de.manutencao.industrial.module.order_piece.application.dto.create;

public record CreateOrderPieceRequest(long idMaintenanceOrder, long idPiece, double quantity) {
}
