package sistema.de.manutencao.industrial.module.piece.application.controller;

import sistema.de.manutencao.industrial.module.piece.application.dto.list.PieceListResponse;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceResponse;
import sistema.de.manutencao.industrial.module.piece.domain.service.PieceService;
import sistema.de.manutencao.industrial.view.controller.PieceController;

import java.util.List;

public class PieceControllerAdapter implements PieceController {

    private final PieceService pieceService;

    public PieceControllerAdapter(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @Override
    public RegisterPieceResponse register(RegisterPieceRequest registerPieceRequest) {
        return pieceService.register(registerPieceRequest);
    }

    @Override
    public List<PieceListResponse> getAll() {
        return pieceService.getAll();
    }
}
