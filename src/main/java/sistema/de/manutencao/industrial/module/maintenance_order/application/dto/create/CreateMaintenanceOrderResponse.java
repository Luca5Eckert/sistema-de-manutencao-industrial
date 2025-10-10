package sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;

import java.time.LocalDate;

public record CreateMaintenanceOrderResponse(long id, long idMachine, long idTechnician, LocalDate dateSolicitation, MaintenanceOrderStatus maintenanceOrderStatus) {

    @Override
    public String toString() {
        return " Máquina: " + idMachine
                + "\n Técnico: " + idTechnician
                + "\n Date solicitação: " + dateSolicitation
                + "\n Status: " + maintenanceOrderStatus();
    }

}
