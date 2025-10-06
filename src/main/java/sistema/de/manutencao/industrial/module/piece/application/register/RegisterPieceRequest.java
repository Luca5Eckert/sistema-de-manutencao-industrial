package sistema.de.manutencao.industrial.module.piece.application.register;

import sistema.de.manutencao.industrial.infrastructure.exception.InputBlankException;

public record RegisterPieceRequest(String name, double quantity) {

    public RegisterPieceRequest {
        if(name.isBlank()){
            throw new InputBlankException("nome");
        }
    }

}
