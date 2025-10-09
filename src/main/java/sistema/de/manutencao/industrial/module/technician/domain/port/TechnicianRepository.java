package sistema.de.manutencao.industrial.module.technician.domain.port;

import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

public interface TechnicianRepository {
    boolean isUnique(TechnicianEntity technicianEntity);

    void save(TechnicianEntity technicianEntity);

}
