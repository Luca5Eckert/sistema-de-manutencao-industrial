package sistema.de.manutencao.industrial.module.technician.domain;

public class TechnicianEntity {

    private final long id;

    private String name;
    private String specialty;

    public TechnicianEntity(String name, String specialty) {
        this.id = -1;
        this.name = name;
        this.specialty = specialty;
    }

    public TechnicianEntity(long id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
