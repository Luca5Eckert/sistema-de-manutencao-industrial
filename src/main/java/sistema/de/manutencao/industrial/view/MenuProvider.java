package sistema.de.manutencao.industrial.view;

import sistema.de.manutencao.industrial.infrastructure.exception.GlobalExceptionHandler;
import sistema.de.manutencao.industrial.view.menu.Menu;
import sistema.de.manutencao.industrial.view.menu.MenuEndSystem;

public class MenuProvider {

    private Menu menu;

    public MenuProvider(Menu menu) {
        this.menu = menu;
    }

    public void execute(){
        try {

            menu.execute();
            menu = menu.getNextMenu();

        } catch (Exception e) {
            System.out.println(GlobalExceptionHandler.handler(e));
        }

    }


    public boolean canContinue() {
        return !(menu instanceof MenuEndSystem);
    }
}
