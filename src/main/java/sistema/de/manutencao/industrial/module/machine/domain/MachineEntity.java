package sistema.de.manutencao.industrial.module.machine.domain;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public class MachineEntity {

    private final long id;
    private final String name;
    private final String sector;
    private OperationalStatus status;

    public MachineEntity(String name, String sector, OperationalStatus status) {
        this.id = -1;
        this.name = name;
        this.sector = sector;
        this.status = status;
    }

    public MachineEntity(long id, String name, String sector, OperationalStatus status) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.status = status;
    }

    public MachineEntity(long id) {
        this.id = id;
        this.name = null;
        this.sector = null;
    }

    public MachineEntity(long id, String name) {
        this.id = id;
        this.name = name;
        this.sector = null;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public OperationalStatus getStatus() {
        return status;
    }

    public void setStatus(OperationalStatus status) {
        this.status = status;
    }
}
