package sistema.de.manutencao.industrial.module.maintenance_order.application.dto.view;

import java.util.HashMap;
import java.util.Map;

public record MaintenanceOrderViewResponse(long id, long idMachine, String machineName, long idTechnician, String nameTechnician, HashMap<Double, Double> resourcesForMaintenance) {

    @Override
    public String toString() {
        return " Maquina: " + machineName
                + "\n Técnico: " + nameTechnician
                + "\n";
    }

    public String resourcesInString(){
        StringBuilder resources = new StringBuilder();

        for(Map.Entry<Double, Double> entry : resourcesForMaintenance.entrySet()){
            resources.append(" ").append(entry.getKey()).append(" / ").append(entry.getValue()).append("\n");
        }

        return resources.toString();
    }
}
