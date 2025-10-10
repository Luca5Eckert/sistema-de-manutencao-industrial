package sistema.de.manutencao.industrial.module.maintenance_order.domain.port;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;

import java.util.List;

public interface MaintenanceOrderRepository {
    List<MaintenanceOrderEntity> getAllPending();

    void save(MaintenanceOrderEntity maintenanceOrderEntity);
}
