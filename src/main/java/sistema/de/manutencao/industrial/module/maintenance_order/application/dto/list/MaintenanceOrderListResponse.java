package sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;

import java.time.LocalDate;

public record MaintenanceOrderListResponse(long id, long idMachine, long idTechnician, LocalDate dateSolicitation, MaintenanceOrderStatus maintenanceOrderStatus) {

    @Override
    public String toString() {
        return " Máquina: " + idMachine
                + " Técnico: " + idTechnician
                + " Date solicitação: " + dateSolicitation
                + " Status: " + maintenanceOrderStatus();
    }
}
