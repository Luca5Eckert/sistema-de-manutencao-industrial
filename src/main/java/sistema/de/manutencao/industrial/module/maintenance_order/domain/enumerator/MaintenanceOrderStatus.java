package sistema.de.manutencao.industrial.module.maintenance_order.domain.enumerator;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.exception.MaintenanceOrderStatusException;

import java.util.List;

public enum MaintenanceOrderStatus {
    PENDENTE,
    EXECUTADA,
    CANCELADA;

    public static List<MaintenanceOrderStatus> getValues() {
        return List.of(MaintenanceOrderStatus.values());
    }

    public static MaintenanceOrderStatus get(int i) {
        if(i < 0 || i >= MaintenanceOrderStatus.values().length){
            throw new MaintenanceOrderStatusException("| Opção sem correspondência");
        }
        return MaintenanceOrderStatus.values()[i];
    }
}
