package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.machine.application.dto.create.MachineRegisterResponse;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;

public interface MachineController {
    MachineRegisterResponse register(RegisterMachineRequest registerMachineRequest);
}
