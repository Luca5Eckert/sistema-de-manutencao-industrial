package sistema.de.manutencao.industrial.module.machine.domain.exception;

public class MachineNotUniqueException extends RuntimeException {
    public MachineNotUniqueException(String message) {
        super(message);
    }

    public MachineNotUniqueException() {
      super("Não pode haver duas maquinas iguais no mesmo setor");
    }

}
