package sistema.de.manutencao.industrial.infrastructure.persistence.technician;

import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;
import sistema.de.manutencao.industrial.module.technician.domain.port.TechnicianRepository;

import java.util.List;

public class TechnicianRepositoryAdapter implements TechnicianRepository {

    private final TechnicianDao technicianDao;

    public TechnicianRepositoryAdapter(TechnicianDao technicianDao) {
        this.technicianDao = technicianDao;
    }

    @Override
    public boolean isUnique(TechnicianEntity technicianEntity) {
        return technicianDao.isUnique(technicianEntity);
    }

    @Override
    public void save(TechnicianEntity technicianEntity) {
        technicianDao.save(technicianEntity);
    }

    @Override
    public List<TechnicianEntity> getAll() {
        return technicianDao.getAll();
    }
}
