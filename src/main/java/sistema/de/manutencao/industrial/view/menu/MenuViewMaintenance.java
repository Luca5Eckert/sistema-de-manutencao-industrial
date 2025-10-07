package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.MaintenanceOrderBeanUtil;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.execute.MaintenanceOrderExecuteRequest;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;

public class MenuViewMaintenance extends Menu {

    private final MaintenanceOrderController maintenanceOrderController;
    private final MaintenanceOrderViewResponse maintenanceOrderViewResponse;

    protected MenuViewMaintenance(Reader reader, MaintenanceOrderController maintenanceOrderController, MaintenanceOrderViewResponse maintenanceOrderViewResponse) {
        super(reader);
        this.maintenanceOrderController = maintenanceOrderController;
        this.maintenanceOrderViewResponse = maintenanceOrderViewResponse;
    }

    @Override
    public void execute() {
        String entrada = callMenu();

        Menu menu = switch (entrada.toUpperCase()){
            case "0" -> Menus.toInstanceExecuteMaintenanceMenu(getReader());
            case "1" -> executeMaintenance();
            default -> this;
        };

        setNextMenu(menu);
    }

    private Menu executeMaintenance() {
        MaintenanceOrderExecuteRequest maintenanceOrderExecuteRequest = new MaintenanceOrderExecuteRequest(maintenanceOrderViewResponse.id());

        maintenanceOrderController.executeMaintance(maintenanceOrderExecuteRequest);

        System.out.println("| Manuntenção realizada com sucesso");

        return Menus.toInstanceExecuteMaintenanceMenu(getReader());
    }

    private String callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                               ORDEM DE MANUTENÇÃO");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" 0 - Voltar");
        System.out.println(" 1 - Realizar Manutenção");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Nome máquina: " + maintenanceOrderViewResponse.machineName() );
        System.out.println(" Recursos Necessarios: ");
        System.out.println(maintenanceOrderViewResponse.resourcesForMaintenance());
        System.out.println("-------------------------------------------------------------------------------");

        return getReader().readLine();

    }

    public static Menu toInstance(Reader reader, MaintenanceOrderViewResponse maintenanceOrderViewResponse) {
        return new MenuViewMaintenance(reader, MaintenanceOrderBeanUtil.toInstanceController(), maintenanceOrderViewResponse);
    }
}
