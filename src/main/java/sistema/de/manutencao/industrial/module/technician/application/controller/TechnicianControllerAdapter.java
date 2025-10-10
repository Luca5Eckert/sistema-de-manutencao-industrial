package sistema.de.manutencao.industrial.module.technician.application.controller;

import sistema.de.manutencao.industrial.module.technician.application.dto.list.TechnicianListResponse;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.RegisterTechnicianRequest;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.TechnicianRegisterResponse;
import sistema.de.manutencao.industrial.module.technician.domain.service.TechnicianService;
import sistema.de.manutencao.industrial.view.controller.TechnicianController;

import java.util.List;

public class TechnicianControllerAdapter implements TechnicianController {

    private final TechnicianService technicianService;

    public TechnicianControllerAdapter(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @Override
    public TechnicianRegisterResponse register(RegisterTechnicianRequest registerTechnicianRequest) {
        return technicianService.register(registerTechnicianRequest);
    }

    @Override
    public List<TechnicianListResponse> getAll() {
        return technicianService.getAll();
    }
}
