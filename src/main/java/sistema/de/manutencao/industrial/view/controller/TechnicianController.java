package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.technician.application.dto.list.TechnicianListResponse;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.RegisterTechnicianRequest;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.TechnicianRegisterResponse;

import java.util.List;

public interface TechnicianController {
    TechnicianRegisterResponse register(RegisterTechnicianRequest registerTechnicianRequest);

    List<TechnicianListResponse> getAll();
}
