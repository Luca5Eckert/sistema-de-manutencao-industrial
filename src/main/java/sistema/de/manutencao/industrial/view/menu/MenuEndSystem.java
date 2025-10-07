package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.view.Reader;

public class MenuEndSystem extends Menu {

    protected MenuEndSystem(Reader reader) {
        super(reader);
    }

    @Override
    public void execute() {
    }

    public static Menu toInstance(Reader reader) {
        return new MenuEndSystem(reader);
    }
}
