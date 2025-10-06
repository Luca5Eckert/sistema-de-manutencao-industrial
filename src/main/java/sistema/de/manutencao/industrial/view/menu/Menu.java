package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.view.Reader;

public abstract class Menu {
    private Menu nextMenu;
    private final Reader reader;

    protected Menu(Reader reader) {
        this.reader = reader;
    }

    public abstract void execute();

    public Menu getNextMenu() {
        return nextMenu == null ? this : nextMenu;
    }

    public Reader getReader() {
        return reader;
    }
}
