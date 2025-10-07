package sistema.de.manutencao.industrial.view.menu;

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

    public static Menu toInstanceRegisterPiece(Reader reader){
        return MenuCreateMaintenanceOrder.toInstance(reader);
    }
}
