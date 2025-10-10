package sistema.de.manutencao.industrial.infrastructure.bean;

import sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order.MaintenanceOrderDao;
import sistema.de.manutencao.industrial.infrastructure.persistence.maintenance_order.MaintenanceOrderRepositoryAdapter;
import sistema.de.manutencao.industrial.module.maintenance_order.application.controller.MaintenanceOrderControllerAdapter;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.mapper.MaintenanceOrderMapper;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.port.MaintenanceOrderRepository;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.service.MaintenanceOrderService;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;

public class MaintenanceOrderBeanUtil {
    
    private final static MaintenanceOrderDao MAINTENANCE_ORDER_DAO = new MaintenanceOrderDao();
    private final static MaintenanceOrderRepository MAINTENANCE_ORDER_REPOSITORY = new MaintenanceOrderRepositoryAdapter(MAINTENANCE_ORDER_DAO);
    private final static MaintenanceOrderMapper MAINTENANCE_ORDER_MAPPER = new MaintenanceOrderMapper();
    private final static MaintenanceOrderService MAINTENANCE_ORDER_SERVICE = new MaintenanceOrderService(MAINTENANCE_ORDER_REPOSITORY, MachineBeanUtil.toInstanceRepository(), MAINTENANCE_ORDER_MAPPER);
    private final static MaintenanceOrderController MAINTENANCE_ORDER_CONTROLLER = new MaintenanceOrderControllerAdapter(MAINTENANCE_ORDER_SERVICE);

    public static MaintenanceOrderController toInstanceController(){
        return MAINTENANCE_ORDER_CONTROLLER;
    }
    
}
