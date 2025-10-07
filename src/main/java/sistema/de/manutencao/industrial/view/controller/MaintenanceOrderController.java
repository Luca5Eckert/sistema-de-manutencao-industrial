package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;

public interface MaintenanceOrderController {
    CreateMaintenanceOrderResponse create(CreateMaintenanceOrderRequest createMaintenanceOrderRequest);
}
