package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.piece.application.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.module.piece.application.register.RegisterPieceResponse;

public interface PieceController {
    RegisterPieceResponse register(RegisterPieceRequest registerPieceRequest);
}
