package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.technician.application.dto.register.RegisterTechnicianRequest;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.TechnicianRegisterResponse;

public interface TechnicianController {
    TechnicianRegisterResponse register(RegisterTechnicianRequest registerTechnicianRequest);
}
