package sistema.de.manutencao.industrial.module.machine.domain.port;

import sistema.de.manutencao.industrial.module.machine.domain.MachineEntity;

import java.util.Arrays;
import java.util.List;

public interface MachineRepository {
    boolean isNotUniqueInTheSector(MachineEntity machine);

    void save(MachineEntity machine);

    List<MachineEntity> getAll();
}
