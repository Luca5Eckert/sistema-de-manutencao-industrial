package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.TechnicianBeanUtil;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;
import sistema.de.manutencao.industrial.module.technician.application.dto.register.RegisterTechnicianRequest;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.TechnicianController;

public class MenuRegisterTechnician extends Menu {
    
    private final TechnicianController technicianController;
    
    protected MenuRegisterTechnician(Reader reader, TechnicianController technicianController) {
        super(reader);
        this.technicianController = technicianController;
    }

    @Override
    public void execute() {
        var registerTechnicianRequest = callMenu();

        Menu menu = switch (registerTechnicianRequest){
            case null -> Menus.toInstanceMainMenu(getReader());
            default -> registerTechnician(registerTechnicianRequest);
        };

        setNextMenu(menu);
    }

    private Menu registerTechnician(RegisterTechnicianRequest registerTechnicianRequest) {
        var technicianRegisterResponse = technicianController.register(registerTechnicianRequest);

        System.out.println("| Técnico registrado com succeso");
        System.out.println(technicianRegisterResponse);

        return Menus.toInstanceMainMenu(getReader());
    }

    private RegisterTechnicianRequest callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                               CADASTRAR TECNICO");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Digite os dados para cadastrar: ( 0 para cancelar )");

        System.out.println(" Nome: ");
        String name = getReader().readLine();

        if(name.equals("0")) return null;

        System.out.println(" Especialidade: ");
        String specialty = getReader().readLine();

        if(specialty.equals("0")) return null;

        return new RegisterTechnicianRequest(name, specialty);
    }

    public static Menu toInstance(Reader reader) {
        return new MenuRegisterTechnician(reader, TechnicianBeanUtil.toInstanceController());
    }
}
