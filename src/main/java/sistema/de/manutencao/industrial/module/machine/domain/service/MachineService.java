package sistema.de.manutencao.industrial.module.machine.domain.service;

import sistema.de.manutencao.industrial.module.machine.application.dto.create.MachineRegisterResponse;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;
import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;
import sistema.de.manutencao.industrial.module.machine.domain.exception.MachineNotUniqueException;
import sistema.de.manutencao.industrial.module.machine.domain.mapper.MachineMapper;
import sistema.de.manutencao.industrial.module.machine.domain.port.MachineRepository;

public class MachineService {

    private final MachineRepository machineRepository;
    private final MachineMapper machineMapper;

    public MachineService(MachineRepository machineRepository, MachineMapper machineMapper) {
        this.machineRepository = machineRepository;
        this.machineMapper = machineMapper;
    }

    public MachineRegisterResponse register(RegisterMachineRequest registerMachineRequest) {
        var machine = new MachineEntity(registerMachineRequest.name(), registerMachineRequest.sector(), OperationalStatus.OPERACIONAL);

        if(machineRepository.isNotUniqueInTheSector(machine)){
            throw new MachineNotUniqueException();
        }

        machineRepository.save(machine);

        return machineMapper.toRegisterResponse(machine);
    }


}
