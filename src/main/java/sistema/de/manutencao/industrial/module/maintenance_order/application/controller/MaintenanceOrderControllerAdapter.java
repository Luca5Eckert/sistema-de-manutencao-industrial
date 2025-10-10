package sistema.de.manutencao.industrial.module.maintenance_order.application.controller;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.execute.MaintenanceOrderExecuteRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.service.MaintenanceOrderService;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;

import java.util.List;

public class MaintenanceOrderControllerAdapter implements MaintenanceOrderController {

    private final MaintenanceOrderService maintenanceOrderService;

    public MaintenanceOrderControllerAdapter(MaintenanceOrderService maintenanceOrderService) {
        this.maintenanceOrderService = maintenanceOrderService;
    }

    @Override
    public CreateMaintenanceOrderResponse create(CreateMaintenanceOrderRequest createMaintenanceOrderRequest) {
        return maintenanceOrderService.create(createMaintenanceOrderRequest);
    }

    @Override
    public List<MaintenanceOrderListResponse> getAll() {
        return maintenanceOrderService.getAll();
    }

    @Override
    public List<MaintenanceOrderListResponse> getAllPending() {
        return maintenanceOrderService.getAllPending();
    }

    @Override
    public MaintenanceOrderViewResponse getViewMaintenance(long id) {
        return maintenanceOrderService.getViewMaintenance(id);
    }

    @Override
    public void executeMaintance(MaintenanceOrderExecuteRequest maintenanceOrderExecuteRequest) {
        maintenanceOrderService.executeMaintance(maintenanceOrderExecuteRequest);
    }
}
