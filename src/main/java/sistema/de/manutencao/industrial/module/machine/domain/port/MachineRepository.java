package sistema.de.manutencao.industrial.module.machine.domain.port;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;

public interface MachineRepository {
    boolean isNotUniqueInTheSector(MachineEntity machine);

    void save(MachineEntity machine);
}
