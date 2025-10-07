package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.machine.application.dto.create.MachineRegisterResponse;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;
import sistema.de.manutencao.industrial.module.machine.application.dto.list.MachineListResponse;

import java.util.List;

public interface MachineController {
    MachineRegisterResponse register(RegisterMachineRequest registerMachineRequest);

    List<MachineListResponse> getAll();
}
