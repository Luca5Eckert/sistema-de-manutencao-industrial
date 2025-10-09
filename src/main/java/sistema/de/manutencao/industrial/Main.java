package sistema.de.manutencao.industrial;


import sistema.de.manutencao.industrial.infrastructure.util.ReaderAdapter;
import sistema.de.manutencao.industrial.view.MenuManager;
import sistema.de.manutencao.industrial.view.MenuProvider;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.menu.Menus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ReaderAdapter(new Scanner(System.in));
        MenuProvider provider = new MenuProvider(Menus.toInstanceMainMenu(reader));

        MenuManager manager = new MenuManager(provider);

        manager.init();

    }

}