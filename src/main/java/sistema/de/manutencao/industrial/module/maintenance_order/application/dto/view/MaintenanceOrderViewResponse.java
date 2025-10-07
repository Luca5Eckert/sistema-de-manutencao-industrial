package sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view;

import java.util.HashMap;

public record MaintenanceOrderViewResponse(long id, String machineName, HashMap<Double, Double> resourcesForMaintenance) {
}
