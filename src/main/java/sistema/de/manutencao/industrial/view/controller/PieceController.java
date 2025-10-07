package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.piece.application.dto.list.PieceListResponse;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.module.piece.application.dto.register.RegisterPieceResponse;

import java.util.List;

public interface PieceController {
    RegisterPieceResponse register(RegisterPieceRequest registerPieceRequest);

    List<PieceListResponse> getAll();
}
