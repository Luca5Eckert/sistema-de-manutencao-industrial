package sistema.de.manutencao.industrial.infrastructure.exception;

public class GlobalExceptionHandler {

    public static String handler(Exception e) {
        return e.getMessage();
    }

}
