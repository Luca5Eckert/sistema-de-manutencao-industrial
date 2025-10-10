package sistema.de.manutencao.industrial.module.technician.domain.mapper;

import sistema.de.manutencao.industrial.module.technician.application.dto.list.TechnicianListResponse;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.TechnicianRegisterResponse;
import sistema.de.manutencao.industrial.module.technician.domain.TechnicianEntity;

public class TechnicianMapper {

    public TechnicianRegisterResponse toRegisterResponse(TechnicianEntity technicianEntity) {
        return new TechnicianRegisterResponse(technicianEntity.getName(), technicianEntity.getSpecialty() );
    }

    public TechnicianListResponse toListResponse(TechnicianEntity technicianEntity) {
        return new TechnicianListResponse(technicianEntity.getId(), technicianEntity.getName(), technicianEntity.getSpecialty());
    }

}
