package sistema.de.manutencao.industrial.infrastructure.util;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsoleUtil {

    public static void printList(List<?> list) {
        if(list.isEmpty()) System.out.println("| Lista Vazia ");

        AtomicInteger counter = new AtomicInteger(1);
        list.forEach(i -> System.out.println(" " + (counter.getAndIncrement()) + " - " + i));

    }

}
