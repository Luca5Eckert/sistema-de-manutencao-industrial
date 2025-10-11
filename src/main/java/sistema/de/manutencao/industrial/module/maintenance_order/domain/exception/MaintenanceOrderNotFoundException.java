package sistema.de.manutencao.industrial.module.maintenance_order.domain.exception;

public class MaintenanceOrderNotFoundException extends RuntimeException {
    public MaintenanceOrderNotFoundException(String message) {
        super(message);
    }

    public MaintenanceOrderNotFoundException(long id) {
        super(" Ordem de manutenção não encontrada com id: " + id);
    }
}
