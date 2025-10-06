package sistema.de.manutencao.industrial.view;

public class MenuManager {

    private final MenuProvider menuProvider;

    public MenuManager(MenuProvider menuProvider) {
        this.menuProvider = menuProvider;
    }

    public void init(){
        while(menuProvider.canContinue()){
            menuProvider.execute();
        }
    }
}
