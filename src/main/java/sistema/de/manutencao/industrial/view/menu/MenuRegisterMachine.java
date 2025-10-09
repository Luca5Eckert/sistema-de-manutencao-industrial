package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.MachineBeanUtil;
import sistema.de.manutencao.industrial.module.machine.application.dto.create.RegisterMachineRequest;
import sistema.de.manutencao.industrial.infrastructure.util.ConsoleUtil;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.MachineController;

public class MenuRegisterMachine extends Menu {

    private final MachineController machineController;

    protected MenuRegisterMachine(Reader reader, MachineController machineController) {
        super(reader);
        this.machineController = machineController;
    }

    @Override
    public void execute() {
        var registerMachineRequest = callMenu();

        Menu menu = switch (registerMachineRequest){
            case null -> Menus.toInstanceMainMenu(getReader());
            default -> registerMachine(registerMachineRequest);
        };

        setNextMenu(menu);
    }

    private Menu registerMachine(RegisterMachineRequest registerMachineRequest) {
        var machineRegisterResponse = machineController.register(registerMachineRequest);

        System.out.println("| Maquina registrada com sucesso");
        System.out.println(machineRegisterResponse);

        return new MenuMain(getReader());
    }

    private RegisterMachineRequest callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                               CADASTRAR MAQUINA");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Digite os dados para cadastrar: ( 0 para cancelar )");

        System.out.println(" Nome: ");
        String name = getReader().readLine();

        if(name.equals("0")) return null;

        System.out.println(" Setor: ");
        String setor = getReader().readLine();

        if(setor.equals("0")) return null;

        return new RegisterMachineRequest(name, setor);
    }

    public static Menu toInstance(Reader reader) {
        return new MenuRegisterMachine(reader, MachineBeanUtil.toInstanceController());
    }
}
