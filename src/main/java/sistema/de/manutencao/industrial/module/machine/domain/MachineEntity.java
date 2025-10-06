package sistema.de.manutencao.industrial.module.machine.domain;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public class MachineEntity {

    private final long id;
    private final String register;
    private final String sector;
    private OperationalStatus status;

    public MachineEntity(long id, String register, String sector) {
        this.id = id;
        this.register = register;
        this.sector = sector;
    }

}
