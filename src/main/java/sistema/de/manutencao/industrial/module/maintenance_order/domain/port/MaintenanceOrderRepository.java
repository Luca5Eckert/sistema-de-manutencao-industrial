package sistema.de.manutencao.industrial.module.maintenance_order.domain.port;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface MaintenanceOrderRepository {
    List<MaintenanceOrderEntity> getAllPending();

    void save(MaintenanceOrderEntity maintenanceOrderEntity);

    List<MaintenanceOrderEntity> getAll();

    Optional<MaintenanceOrderViewResponse> getMaintenanceById(long id);

    HashMap<Double, Double> getResourcesTheMaintenance(long id);

    void executeMaintance(long id);
}
