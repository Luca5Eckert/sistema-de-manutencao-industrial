package sistema.de.manutencao.industrial.module.technician.domain.port;

import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

import java.util.Arrays;
import java.util.List;

public interface TechnicianRepository {
    boolean isUnique(TechnicianEntity technicianEntity);

    void save(TechnicianEntity technicianEntity);

    List<TechnicianEntity> getAll();
}
