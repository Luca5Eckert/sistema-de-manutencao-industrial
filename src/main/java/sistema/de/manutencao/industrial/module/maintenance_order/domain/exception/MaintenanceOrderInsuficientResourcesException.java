package sistema.de.manutencao.industrial.module.maintenance_order.domain.exception;

public class MaintenanceOrderInsuficientResourcesException extends RuntimeException {
    public MaintenanceOrderInsuficientResourcesException(String message) {
        super(message);
    }

    public MaintenanceOrderInsuficientResourcesException() {
        super(" Não existe recursos suficientes para executar manutenção");
  }

}
