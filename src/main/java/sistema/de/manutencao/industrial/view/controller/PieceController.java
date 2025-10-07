package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.piece.application.list.PieceListResponse;
import sistema.de.manutencao.industrial.module.piece.application.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.module.piece.application.register.RegisterPieceResponse;

import java.util.List;

public interface PieceController {
    RegisterPieceResponse register(RegisterPieceRequest registerPieceRequest);

    List<PieceListResponse> getAll();
}
