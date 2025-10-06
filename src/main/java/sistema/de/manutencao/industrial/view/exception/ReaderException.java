package sistema.de.manutencao.industrial.view.exception;

import sistema.de.manutencao.industrial.infrastructure.exception.SystemException;

public class ReaderException extends SystemException {

    public ReaderException(String tipoCorreto) {
        super("Erro ao ler entrada. Digite um " + tipoCorreto);
    }

}
