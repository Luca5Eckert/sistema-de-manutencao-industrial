package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.exception.NoMatchInput;
import sistema.de.manutencao.industrial.view.Reader;

public class MenuMain extends Menu {

    protected MenuMain(Reader reader) {
        super(reader);
    }

    @Override
    public void execute() {
        var input = callMenu();

        Menu menu = switch (input.toUpperCase()){
            case "1" -> Menus.toInstanceRegisterMachineMenu(getReader());
            case "2" -> Menus.toInstanceRegisterTechnicianMenu(getReader());
            case "3" -> Menus.toInstanceRegisterPieceMenu(getReader());
            case "4" -> Menus.toInstanceCreateMaintenanceOrderMenu(getReader());
            case "6" -> Menus.to
            case "0" -> Menus.toInstanceEndSystemMenu(getReader());
            default -> throw new NoMatchInput();
        };

        setNextMenu(menu);
    }

    private String callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                       SISTEMA DE MANUTENÇÃO INDUSTRIAL");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println(" 1 - Cadastrar Máquina");
        System.out.println(" 2 - Cadastrar Técnico");
        System.out.println(" 3 - Cadastrar Peça");
        System.out.println(" 4 - Criar Ordem de Manutenção");
        System.out.println(" 5 - Associar Peças à ordem");
        System.out.println(" 6 - Executar Manutenção");

        System.out.println(" 0 - Sair");
        
        System.out.println("--------------------------------------------------------------------------------");

        return getReader().readLine();
    }

    static Menu toInstance(Reader reader) {
        return new MenuMain(reader);
    }

}
