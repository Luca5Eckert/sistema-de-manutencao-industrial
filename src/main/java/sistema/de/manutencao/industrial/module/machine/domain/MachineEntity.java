package sistema.de.manutencao.industrial.module.machine.domain;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public class MachineEntity {

    private final long id;
    private final String register;
    private OperationalStatus status;

    public MachineEntity(long id, String register) {
        this.id = id;
        this.register = register;
    }

}
