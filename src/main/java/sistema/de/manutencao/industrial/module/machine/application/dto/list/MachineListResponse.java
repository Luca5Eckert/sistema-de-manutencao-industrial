package sistema.de.manutencao.industrial.module.machine.application.dto.list;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public record MachineListResponse(long id, String name, String sector, OperationalStatus operationalStatus) {

    @Override
    public String toString() {
        return " Nome: " + name
                + "                |         Setor: " + sector;
    }

}
