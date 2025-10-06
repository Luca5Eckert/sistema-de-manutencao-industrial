package sistema.de.manutencao.industrial.infrastructure.exception;

public class NoMatchInput extends RuntimeException {
    public NoMatchInput(String message) {
        super(message);
    }

    public NoMatchInput() {
        super("Entrada sem correspondência");
    }

}
