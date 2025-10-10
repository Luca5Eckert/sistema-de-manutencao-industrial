package sistema.de.manutencao.industrial.module.machine.application.controller;

import sistema.de.manutencao.industrial.module.machine.application.dto.create.MachineRegisterResponse;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;
import sistema.de.manutencao.industrial.module.machine.application.dto.list.MachineListResponse;
import sistema.de.manutencao.industrial.module.machine.domain.service.MachineService;
import sistema.de.manutencao.industrial.view.controller.MachineController;

import java.util.List;

public class MachineControllerAdapter implements MachineController {

    private final MachineService machineService;

    public MachineControllerAdapter(MachineService machineService) {
        this.machineService = machineService;
    }

    @Override
    public MachineRegisterResponse register(RegisterMachineRequest registerMachineRequest) {
        return machineService.register(registerMachineRequest);
    }

    @Override
    public List<MachineListResponse> getAll() {
        return machineService.getAll();
    }
}
