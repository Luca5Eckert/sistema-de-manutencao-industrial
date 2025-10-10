package sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.port.MaintenanceOrderRepository;

import java.util.List;

public class MaintenanceOrderRepositoryAdapter implements MaintenanceOrderRepository {

    private final MaintenanceOrderDao maintenanceOrderDao;

    public MaintenanceOrderRepositoryAdapter(MaintenanceOrderDao maintenanceOrderDao) {
        this.maintenanceOrderDao = maintenanceOrderDao;
    }

    @Override
    public List<MaintenanceOrderEntity> getAllPending() {
        return maintenanceOrderDao.getAllPending();
    }

    @Override
    public void save(MaintenanceOrderEntity maintenanceOrderEntity) {
        maintenanceOrderDao.save(maintenanceOrderEntity);
    }
}
