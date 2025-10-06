package sistema.de.manutencao.industrial.infrastructure.exception;

public class InputBlankException extends RuntimeException {

    public InputBlankException(String field) {
        super(" Não é permitido o campo " + field + " em branco");
    }

}
