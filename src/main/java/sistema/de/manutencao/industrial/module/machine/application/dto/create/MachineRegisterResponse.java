package sistema.de.manutencao.industrial.module.machine.application.dto.create;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public record MachineRegisterResponse(String name, String sector, OperationalStatus operationalStatus) {

    @Override
    public String toString() {
        return " Nome: " + name
                + "\n Setor: " + sector
                + "\n Estado Operacional: " + operationalStatus;
    }
}
