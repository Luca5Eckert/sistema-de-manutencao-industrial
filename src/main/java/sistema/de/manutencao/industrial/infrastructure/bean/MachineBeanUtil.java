package sistema.de.manutencao.industrial.infrastructure.bean;

import sistema.de.manutencao.industrial.infrastructure.persistence.machine.MachineDao;
import sistema.de.manutencao.industrial.infrastructure.persistence.machine.MachineRepositoryAdapter;
import sistema.de.manutencao.industrial.module.machine.application.controller.MachineControllerAdapter;
import sistema.de.manutencao.industrial.module.machine.domain.mapper.MachineMapper;
import sistema.de.manutencao.industrial.module.machine.domain.port.MachineRepository;
import sistema.de.manutencao.industrial.module.machine.domain.service.MachineService;
import sistema.de.manutencao.industrial.view.controller.MachineController;

public class MachineBeanUtil {

    private final static MachineDao MACHINE_DAO = new MachineDao();
    private final static MachineRepository MACHINE_REPOSITORY = new MachineRepositoryAdapter(MACHINE_DAO);
    private final static MachineMapper MACHINE_MAPPER = new MachineMapper();
    private final static MachineService MACHINE_SERVICE = new MachineService(MACHINE_REPOSITORY, MACHINE_MAPPER);
    private final static MachineController MACHINE_CONTROLLER = new MachineControllerAdapter(MACHINE_SERVICE);


    public static MachineController toInstanceController(){
        return MACHINE_CONTROLLER;
    }

    public static MachineRepository toInstanceRepository() {
        return MACHINE_REPOSITORY;
    }
}
