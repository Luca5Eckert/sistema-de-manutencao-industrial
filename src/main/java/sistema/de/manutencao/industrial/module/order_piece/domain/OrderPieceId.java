package sistema.de.manutencao.industrial.module.order_piece.domain;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

public class OrderPieceId {

    private final MaintenanceOrderEntity maintenanceOrderEntity;
    private final PieceEntity pieceEntity;

    public OrderPieceId(MaintenanceOrderEntity maintenanceOrderEntity, PieceEntity pieceEntity) {
        this.maintenanceOrderEntity = maintenanceOrderEntity;
        this.pieceEntity = pieceEntity;
    }

    public MaintenanceOrderEntity getMaintenanceOrderEntity() {
        return maintenanceOrderEntity;
    }

    public PieceEntity getPieceEntity() {
        return pieceEntity;
    }
}
