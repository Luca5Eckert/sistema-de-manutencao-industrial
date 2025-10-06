package sistema.de.manutencao.industrial.module.machine.domain.enumerator;

import sistema.de.manutencao.industrial.module.machine.domain.exception.OperationalStatusException;

import java.util.List;

public enum OperationalStatus {
    OPERACIONAL,
    EM_MANUTENCAO;


    public static List<?> getValues() {
        return List.of(OperationalStatus.values());
    }

    public static OperationalStatus get(int i) {
        if(i < 0 || i >= OperationalStatus.values().length){
            throw new OperationalStatusException("| Opção sem correspondência");
        }
        return OperationalStatus.values()[i];
    }
}
