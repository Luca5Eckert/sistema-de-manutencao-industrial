package sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;

import java.time.LocalDate;

public record CreateMaintenanceOrderRequest(long idMachine, long idTechnician, LocalDate dateSolicitation, MaintenanceOrderStatus maintenanceOrderStatus) {
}
