package sistema.de.manutencao.industrial.infrastructure.bean;

import sistema.de.manutencao.industrial.infrastructure.persistence.technician.TechnicianDao;
import sistema.de.manutencao.industrial.infrastructure.persistence.technician.TechnicianRepositoryAdapter;
import sistema.de.manutencao.industrial.module.technician.application.controller.TechnicianControllerAdapter;
import sistema.de.manutencao.industrial.module.technician.domain.mapper.TechnicianMapper;
import sistema.de.manutencao.industrial.module.technician.domain.port.TechnicianRepository;
import sistema.de.manutencao.industrial.module.technician.domain.service.TechnicianService;
import sistema.de.manutencao.industrial.view.controller.TechnicianController;

public class TechnicianBeanUtil {

    private final static TechnicianDao TECHNICIAN_DAO = new TechnicianDao();
    private final static TechnicianRepository TECHNICIAN_REPOSITORY = new TechnicianRepositoryAdapter(TECHNICIAN_DAO);
    private final static TechnicianMapper TECHNICIAN_MAPPER = new TechnicianMapper();
    private final static TechnicianService TECHNICIAN_SERVICE = new TechnicianService(TECHNICIAN_REPOSITORY, TECHNICIAN_MAPPER);
    private final static TechnicianController TECHNICIAN_CONTROLLER = new TechnicianControllerAdapter(TECHNICIAN_SERVICE);


    public static TechnicianController toInstanceController(){
        return TECHNICIAN_CONTROLLER;
    }

}
