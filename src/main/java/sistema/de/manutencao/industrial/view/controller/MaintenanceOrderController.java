package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;

import java.util.List;

public interface MaintenanceOrderController {
    CreateMaintenanceOrderResponse create(CreateMaintenanceOrderRequest createMaintenanceOrderRequest);

    List<MaintenanceOrderListResponse> getAll();
}
