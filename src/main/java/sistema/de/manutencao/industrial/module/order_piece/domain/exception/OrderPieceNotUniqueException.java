package sistema.de.manutencao.industrial.module.order_piece.domain.exception;

public class OrderPieceNotUniqueException extends RuntimeException {
    public OrderPieceNotUniqueException(String message) {
        super(message);
    }


    public OrderPieceNotUniqueException() {
      super("Ordem de peça já criada");
    }


}
