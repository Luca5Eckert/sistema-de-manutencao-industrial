package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view.MaintenanceOrderViewResponse;
import sistema.de.manutencao.industrial.view.Reader;

public class Menus {

    public static Menu toInstanceMainMenu(Reader reader) {
        return MenuMain.toInstance(reader);
    }

    public static Menu toInstanceEndSystemMenu(Reader reader) {
        return MenuEndSystem.toInstance(reader);
    }

    public static Menu toInstanceRegisterMachineMenu(Reader reader) {
        return MenuRegisterMachine.toInstance(reader);
    }

    public static Menu toInstanceRegisterTechnicianMenu(Reader reader) {
        return MenuRegisterTechnician.toInstance(reader);
    }

    public static Menu toInstanceCreateMaintenanceOrderMenu(Reader reader){
        return MenuCreateMaintenanceOrder.toInstance(reader);
    }

    public static Menu toInstanceRegisterPieceMenu(Reader reader){
        return MenuRegisterPiece.toInstance(reader);
    }

    public static Menu toInstanceCreateOrderPieceMenu(Reader reader){
        return MenuCreateOrderPiece.toInstance(reader);
    }

    public static Menu toInstanceExecuteMaintenanceMenu(Reader reader){
        return MenuExecuteMaintenance.toInstance(reader);
    }

    public static Menu toInstanceViewMaintenanceMenu(Reader reader, MaintenanceOrderViewResponse maintenanceOrderViewResponse) {
        return MenuViewMaintenance.toInstance(reader, maintenanceOrderViewResponse);
    }
}
