package sistema.de.manutencao.industrial.module.machine.domain.mapper;

import sistema.de.manutencao.industrial.module.machine.application.dto.create.MachineRegisterResponse;
import sistema.de.manutencao.industrial.module.machine.application.dto.list.MachineListResponse;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;

public class MachineMapper {
    public MachineRegisterResponse toRegisterResponse(MachineEntity machine) {
        return new MachineRegisterResponse(machine.getName(), machine.getSector(), machine.getStatus());
    }

    public MachineListResponse toListarResponse(MachineEntity machineEntity) {
        return new MachineListResponse(machineEntity.getId(), machineEntity.getName(), machineEntity.getSector(), machineEntity.getStatus());
    }
}
