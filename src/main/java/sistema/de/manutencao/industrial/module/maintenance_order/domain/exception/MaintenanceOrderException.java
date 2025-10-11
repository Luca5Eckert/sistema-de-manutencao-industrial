package sistema.de.manutencao.industrial.module.maintenance_order.domain.exception;

import sistema.de.manutencao.industrial.infrastructure.exception.SystemException;

public class MaintenanceOrderException extends SystemException {
    public MaintenanceOrderException(String message) {
        super(message);
    }
}
