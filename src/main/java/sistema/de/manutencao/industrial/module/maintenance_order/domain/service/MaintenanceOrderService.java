package sistema.de.manutencao.industrial.module.maintenance_order.domain.service;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;
import sistema.de.manutencao.industrial.module.machine.domain.port.MachineRepository;
import sistema.de.manutencao.industrial.module.machine.domain.service.MachineService;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.execute.MaintenanceOrderExecuteRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.mapper.MaintenanceOrderMapper;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.port.MaintenanceOrderRepository;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.time.LocalDate;
import java.util.List;

public class MaintenanceOrderService {

    private final MaintenanceOrderRepository maintenanceOrderRepository;
    private final MachineRepository machineRepository;

    private final MaintenanceOrderMapper maintenanceOrderMapper;

    public MaintenanceOrderService(MaintenanceOrderRepository maintenanceOrderRepository, MachineRepository machineRepository, MaintenanceOrderMapper maintenanceOrderMapper) {
        this.maintenanceOrderRepository = maintenanceOrderRepository;
        this.machineRepository = machineRepository;
        this.maintenanceOrderMapper = maintenanceOrderMapper;
    }

    public List<MaintenanceOrderListResponse> getAllPending() {
        return maintenanceOrderRepository.getAllPending().stream().map(maintenanceOrderMapper::toListResponse).toList();
    }

    public MaintenanceOrderViewResponse getViewMaintenance(long id) {
        return null;
    }

    public List<MaintenanceOrderListResponse> getAll() {
        return null;
    }

    public CreateMaintenanceOrderResponse create(CreateMaintenanceOrderRequest createMaintenanceOrderRequest) {
        MachineEntity machineEntity = new MachineEntity(createMaintenanceOrderRequest.idMachine());
        TechnicianEntity technicianEntity = new TechnicianEntity(createMaintenanceOrderRequest.idTechnician());

        MaintenanceOrderEntity maintenanceOrderEntity = new MaintenanceOrderEntity(machineEntity, technicianEntity, LocalDate.now(), MaintenanceOrderStatus.EXECUTADA);

        maintenanceOrderRepository.save(maintenanceOrderEntity);

        machineRepository.changeStatus(machineEntity.getId(), OperationalStatus.EM_MANUTENCAO);

        return maintenanceOrderMapper.toCreateResponse(maintenanceOrderEntity);
    }

    public void executeMaintance(MaintenanceOrderExecuteRequest maintenanceOrderExecuteRequest) {
    }
}
