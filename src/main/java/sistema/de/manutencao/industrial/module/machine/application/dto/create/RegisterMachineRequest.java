package sistema.de.manutencao.industrial.module.machine.application.dto.create;

import sistema.de.manutencao.industrial.infrastructure.exception.InputBlankException;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public record RegisterMachineRequest(String name, String sector) {

    public RegisterMachineRequest {
        if(name.isBlank()){
            throw new InputBlankException("nome");
        }
        if(sector.isBlank()){
            throw new InputBlankException("setor");
        }
    }

}
