package sistema.de.manutencao.industrial.module.machine.application.dto.create;

import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public record MachineRegisterResponse(long id, String register, OperationalStatus operationalStatus) {

    @Override
    public String toString() {
        return " Id: " + id
                + "\n Register: " + register
                + "\n Operation Status: " + operationalStatus;
    }
}
