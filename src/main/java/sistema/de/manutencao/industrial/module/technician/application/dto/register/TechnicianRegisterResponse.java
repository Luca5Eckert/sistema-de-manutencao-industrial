package sistema.de.manutencao.industrial.module.technician.application.dto.register;

public record TechnicianRegisterResponse(String name, String specialty) {


    @Override
    public String toString() {
        return " Nome: " + name
                + "\n Especialidade: " + specialty;
    }
}
