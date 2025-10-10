package sistema.de.manutencao.industrial.infrastructure.persistence.machine;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;
import sistema.de.manutencao.industrial.module.machine.domain.port.MachineRepository;

import java.util.List;

public class MachineRepositoryAdapter implements MachineRepository {

    private final MachineDao machineDao;

    public MachineRepositoryAdapter(MachineDao machineDao) {
        this.machineDao = machineDao;
    }

    @Override
    public boolean isNotUniqueInTheSector(MachineEntity machine) {
        return machineDao.isNotUniqueInTheSector(machine);
    }

    @Override
    public void save(MachineEntity machine) {
        machineDao.save(machine);
    }

    @Override
    public List<MachineEntity> getAll() {
        return machineDao.getAllPedent();
    }
}
