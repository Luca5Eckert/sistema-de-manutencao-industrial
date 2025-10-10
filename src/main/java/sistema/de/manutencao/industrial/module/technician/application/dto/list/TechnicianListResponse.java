package sistema.de.manutencao.industrial.module.technician.application.dto.list;

public record TechnicianListResponse(long id, String name, String specialty) {

    @Override
    public String toString() {
        return " Nome: " + name
                + "                |         Especialidade: " + specialty;
    }
}
