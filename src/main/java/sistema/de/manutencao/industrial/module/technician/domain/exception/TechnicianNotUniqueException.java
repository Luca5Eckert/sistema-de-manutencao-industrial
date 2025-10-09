package sistema.de.manutencao.industrial.module.technician.domain.exception;

public class TechnicianNotUniqueException extends TechnicianException {
    public TechnicianNotUniqueException() {
        super("O técnico precisa ser único");
    }

}
