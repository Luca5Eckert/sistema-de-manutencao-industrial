package sistema.de.manutencao.industrial.module.maintenance_order.domain.service;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;
import sistema.de.manutencao.industrial.module.machine.domain.port.MachineRepository;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.execute.MaintenanceOrderExecuteRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.exception.MaintenanceOrderInsuficientResourcesException;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.exception.MaintenanceOrderNotFoundException;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.exception.MaintenanceOrderStatusException;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.mapper.MaintenanceOrderMapper;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.port.MaintenanceOrderRepository;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return maintenanceOrderRepository.getMaintenanceById(id).orElseThrow( () -> new MaintenanceOrderNotFoundException(id));
    }

    public List<MaintenanceOrderListResponse> getAll() {
        return maintenanceOrderRepository.getAll().stream().map(maintenanceOrderMapper::toListResponse).toList();
    }

    public CreateMaintenanceOrderResponse create(CreateMaintenanceOrderRequest createMaintenanceOrderRequest) {
        MachineEntity machineEntity = new MachineEntity(createMaintenanceOrderRequest.idMachine());
        TechnicianEntity technicianEntity = new TechnicianEntity(createMaintenanceOrderRequest.idTechnician());

        MaintenanceOrderEntity maintenanceOrderEntity = new MaintenanceOrderEntity(machineEntity, technicianEntity, LocalDate.now(), MaintenanceOrderStatus.PENDENTE);

        maintenanceOrderRepository.save(maintenanceOrderEntity);

        machineRepository.changeStatus(machineEntity.getId(), OperationalStatus.EM_MANUTENCAO);

        return maintenanceOrderMapper.toCreateResponse(maintenanceOrderEntity);
    }

    public void executeMaintance(MaintenanceOrderExecuteRequest maintenanceOrderExecuteRequest) {

        var resources = maintenanceOrderRepository.getResourcesTheMaintenance(maintenanceOrderExecuteRequest.id());

        if(!canExecuteMaintenance(resources)) throw new MaintenanceOrderInsuficientResourcesException();

        maintenanceOrderRepository.executeMaintance(maintenanceOrderExecuteRequest.id());

    }

    private boolean canExecuteMaintenance(HashMap<Double, Double> resources) {
        for(Map.Entry<Double, Double> entry :resources.entrySet()){
            if(entry.getKey() < entry.getValue()) return false;
        }
        return true;
    }


}
