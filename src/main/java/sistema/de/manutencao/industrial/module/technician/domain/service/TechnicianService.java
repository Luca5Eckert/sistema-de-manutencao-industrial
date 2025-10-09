package sistema.de.manutencao.industrial.module.technician.domain.service;

import sistema.de.manutencao.industrial.module.technician.application.dto.register.RegisterTechnicianRequest;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.TechnicianRegisterResponse;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;
import sistema.de.manutencao.industrial.module.technician.domain.exception.TechnicianNotUniqueException;
import sistema.de.manutencao.industrial.module.technician.domain.mapper.TechnicianMapper;
import sistema.de.manutencao.industrial.module.technician.domain.port.TechnicianRepository;

public class TechnicianService {

    private final TechnicianRepository technicianRepository;
    private final TechnicianMapper technicianMapper;

    public TechnicianService(TechnicianRepository technicianRepository, TechnicianMapper technicianMapper) {
        this.technicianRepository = technicianRepository;
        this.technicianMapper = technicianMapper;
    }

    public TechnicianRegisterResponse register(RegisterTechnicianRequest registerTechnicianRequest) {
        TechnicianEntity technicianEntity = new TechnicianEntity(registerTechnicianRequest.name(), registerTechnicianRequest.specialty());

        if(!technicianRepository.isUnique(technicianEntity)){
            throw new TechnicianNotUniqueException();
        }

        technicianRepository.save(technicianEntity);

        return technicianMapper.toRegisterResponse(technicianEntity);

    }

}
