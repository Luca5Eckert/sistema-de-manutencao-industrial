package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.MachineBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.bean.MaintenanceOrderBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.bean.TechnicianBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.exception.NoMatchArrayInput;
import sistema.de.manutencao.industrial.infrastructure.util.ConsoleUtil;
import sistema.de.manutencao.industrial.infrastructure.util.ListUtil;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.create.CreateMaintenanceOrderRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator.MaintenanceOrderStatus;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.MachineController;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;
import sistema.de.manutencao.industrial.view.controller.TechnicianController;

import java.time.LocalDate;

public class MenuCreateMaintenanceOrder extends Menu {

    private final MaintenanceOrderController maintenanceOrderController;
    private final MachineController machineController;
    private final TechnicianController technicianController;


    protected MenuCreateMaintenanceOrder(Reader reader, MaintenanceOrderController maintenanceOrderController, MachineController machineController, TechnicianController technicianController) {
        super(reader);
        this.maintenanceOrderController = maintenanceOrderController;
        this.machineController = machineController;
        this.technicianController = technicianController;
    }

    @Override
    public void execute() {
        var createMaintenanceOrderRequest = callMenu();

        Menu menu = switch (createMaintenanceOrderRequest){
            case null -> Menus.toInstanceMainMenu(getReader());
            default -> createMaintenanceOrderRequest(createMaintenanceOrderRequest);
        };

        setNextMenu(menu);
    }

    private Menu createMaintenanceOrderRequest(CreateMaintenanceOrderRequest createMaintenanceOrderRequest) {
        var maintenanceOrderResponse = maintenanceOrderController.create(createMaintenanceOrderRequest);

        System.out.println("| Maintenance order register with sucess");
        System.out.println(maintenanceOrderResponse);

        return new MenuMain(getReader());
    }

    private CreateMaintenanceOrderRequest callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                                CRIAR ORDEM MANUTENÇÃO ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Digite os dados da ordem de manutençao: ( Digite 0 para cancelar ) ");

        System.out.println(" Maquina: ");
        long maquina = getMachine();

        if(maquina == -1) return null;

        System.out.println(" Técnico: ");
        long technician = getTechnician();

        return new CreateMaintenanceOrderRequest(maquina, technician);
    }


    private long getTechnician() {
        var technicianList = technicianController.getAll();

        ConsoleUtil.printList(technicianList);
        int input = getReader().readInteger() - 1;

        if(ListUtil.isAItemInList(technicianList, input)){
            return technicianList.get(input).id();
        }

        throw new NoMatchArrayInput();

    }

    private long getMachine() {

        var machineList = machineController.getAll();

        ConsoleUtil.printList(machineList);
        int input = getReader().readInteger();

        if(input == -1) return input;


        if(ListUtil.isAItemInList(machineList, input)){
            return machineList.get(input).id();
        }

        throw new NoMatchArrayInput();

    }

    public static Menu toInstance(Reader reader) {
        return new MenuCreateMaintenanceOrder(reader, MaintenanceOrderBeanUtil.toInstanceController(), MachineBeanUtil.toInstanceController(), TechnicianBeanUtil.toInstanceController());
    }

}
