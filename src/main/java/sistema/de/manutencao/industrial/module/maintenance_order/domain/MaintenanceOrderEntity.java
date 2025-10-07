package sistema.de.manutencao.industrial.module.maintenance_order.domain;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.time.LocalDate;

public class MaintenanceOrderEntity {

    private final long id;

    private final MachineEntity machineEntity;
    private final TechnicianEntity technicianEntity;

    private final LocalDate requestDate;
    private MaintenanceOrderStatus status;

    public MaintenanceOrderEntity(MachineEntity machineEntity, TechnicianEntity technicianEntity, LocalDate requestDate, MaintenanceOrderStatus status) {
        this.id = -1;
        this.machineEntity = machineEntity;
        this.technicianEntity = technicianEntity;
        this.requestDate = requestDate;
        this.status = status;
    }

    public MaintenanceOrderEntity(long id, MachineEntity machineEntity, TechnicianEntity technicianEntity, LocalDate requestDate, MaintenanceOrderStatus status) {
        this.id = id;
        this.machineEntity = machineEntity;
        this.technicianEntity = technicianEntity;
        this.requestDate = requestDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public MachineEntity getMachineEntity() {
        return machineEntity;
    }

    public TechnicianEntity getTechnicianEntity() {
        return technicianEntity;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public MaintenanceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceOrderStatus status) {
        this.status = status;
    }

}
