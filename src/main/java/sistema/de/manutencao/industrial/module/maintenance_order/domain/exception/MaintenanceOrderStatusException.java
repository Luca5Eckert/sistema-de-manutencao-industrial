package sistema.de.manutencao.industrial.module.maintenance_order.domain.exception;

import sistema.de.manutencao.industrial.infrastructure.exception.SystemException;

public class MaintenanceOrderStatusException extends SystemException {
  public MaintenanceOrderStatusException(String message) {
    super(message);
  }
}
