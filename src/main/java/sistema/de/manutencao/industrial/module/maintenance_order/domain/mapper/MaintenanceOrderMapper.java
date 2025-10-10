package sistema.de.manutencao.industrial.module.maintenance_order.domain.mapper;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;

public class MaintenanceOrderMapper {
    public MaintenanceOrderListResponse toListResponse(MaintenanceOrderEntity maintenanceOrderEntity) {

        return new MaintenanceOrderListResponse(maintenanceOrderEntity.getId(),
                maintenanceOrderEntity.getMachineEntity().getId(),
                maintenanceOrderEntity.getTechnicianEntity().getId(),
                maintenanceOrderEntity.getRequestDate(),
                maintenanceOrderEntity.getStatus(),
                maintenanceOrderEntity.getMachineEntity().getName());

    }

    public CreateMaintenanceOrderResponse toCreateResponse(MaintenanceOrderEntity maintenanceOrderEntity) {

        return new CreateMaintenanceOrderResponse(maintenanceOrderEntity.getId(),
                maintenanceOrderEntity.getMachineEntity().getId(),
                maintenanceOrderEntity.getTechnicianEntity().getId(),
                maintenanceOrderEntity.getRequestDate(),
                maintenanceOrderEntity.getStatus()
        );

    }
}
