package sistema.de.manutencao.industrial.infrastructure.util;

import java.util.List;

public class ConsoleUtil {

    public static void printList(List<?> list) {
        if(list.isEmpty()) System.out.println("| Lista Vazia ");

        int counter = 1;
        list.forEach(i -> System.out.println(" " + counter + " - " + i));

    }

}
