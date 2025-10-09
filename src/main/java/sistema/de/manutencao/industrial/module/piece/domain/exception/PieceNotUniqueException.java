package sistema.de.manutencao.industrial.module.piece.domain.exception;

public class PieceNotUniqueException extends PieceException {
    public PieceNotUniqueException(String message) {
        super(message);
    }

    public PieceNotUniqueException() {
        super("A peça precisa ser única");
    }

}
