package sistema.de.manutencao.industrial.module.machine.application.dto.create;

import sistema.de.manutencao.industrial.infrastructure.exception.InputBlankException;
import sistema.de.manutencao.industrial.module.machine.domain.enumerator.OperationalStatus;

public record RegisterMachineRequest(String register, String sector, OperationalStatus operationalStatus) {

    public RegisterMachineRequest {
        if(register.isBlank()){
            throw new InputBlankException("cadastro");
        }
        if(sector.isBlank()){
            throw new InputBlankException("setor");
        }
        if(operationalStatus == null){
            throw new InputBlankException("status operacional");
        }
    }

}
