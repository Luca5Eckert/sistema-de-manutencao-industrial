package sistema.de.manutencao.industrial.infrastructure.util;

import java.util.List;

public class ListUtil {
    public static boolean isAItemInList(List<?> list, int input) {
        return input >= 0 && input < list.size();
    }
}
