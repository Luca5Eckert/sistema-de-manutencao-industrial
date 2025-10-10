package sistema.de.manutencao.industrial.module.piece.domain.mapper;

import sistema.de.manutencao.industrial.module.piece.application.dto.list.PieceListResponse;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceResponse;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

public class PieceMapper {
    public RegisterPieceResponse toRegisterResponse(PieceEntity piece) {
        return new RegisterPieceResponse(piece.getName(), piece.getStock());
    }

    public PieceListResponse toListResponse(PieceEntity pieceEntity) {
        return new PieceListResponse(pieceEntity.getId(), pieceEntity.getName(), pieceEntity.getStock());
    }
}
