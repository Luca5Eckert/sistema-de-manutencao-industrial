package sistema.de.manutencao.industrial.infrastructure.exception;

public class NoMatchArrayInput extends RuntimeException {
    public NoMatchArrayInput() {
        super("Entrada sem correspondência em lista");
    }
}
