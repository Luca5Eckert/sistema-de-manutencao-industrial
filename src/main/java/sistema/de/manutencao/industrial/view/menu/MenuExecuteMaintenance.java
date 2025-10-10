package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.MaintenanceOrderBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.bean.TechnicianBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.util.ConsoleUtil;
import sistema.de.manutencao.industrial.infrastructure.util.ListUtil;
import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.list.MaintenanceOrderListResponse;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;

import java.util.List;

public class MenuExecuteMaintenance extends Menu {

    private final MaintenanceOrderController maintenanceOrderController;

    protected MenuExecuteMaintenance(Reader reader, MaintenanceOrderController maintenanceOrderController) {
        super(reader);
        this.maintenanceOrderController = maintenanceOrderController;
    }

    @Override
    public void execute() {
        var maintenanceOrders = maintenanceOrderController.getAllPending();

        var entrada = callMenu(maintenanceOrders);

        if(ListUtil.isAItemInList(maintenanceOrders, entrada)){
            var maintenanceOrderViewResponse = maintenanceOrderController.getViewMaintenance(maintenanceOrders.get(entrada).id());

            setNextMenu(Menus.toInstanceViewMaintenanceMenu(getReader(), maintenanceOrderViewResponse));
            return;
        }

        Menu menu = switch (entrada){
            case -1 -> Menus.toInstanceMainMenu(getReader());
            default -> this;
        };

        setNextMenu(menu);
    }

    private int callMenu(List<MaintenanceOrderListResponse> maintenanceOrder) {

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                            EXECUTAR MANUNTENÇÃO");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" 0 - Voltar");
        System.out.println(" Selecione uma maquina para realizar manutenção: ");

        ConsoleUtil.printList(maintenanceOrder);

        System.out.println("--------------------------------------------------------------------------------");

        return getReader().readInteger() - 1;

    }

    public static Menu toInstance(Reader reader) {
        return new MenuExecuteMaintenance(reader, MaintenanceOrderBeanUtil.toInstanceController());
    }

}
