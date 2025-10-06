package sistema.de.manutencao.industrial.module.piece.domain;

public class PieceEntity {

    private final long id;

    private String name;
    private double estoque;

    public PieceEntity(String name, double estoque) {
        this.id = -1;
        this.name = name;
        this.estoque = estoque;
    }

    public PieceEntity(long id, String name, double estoque) {
        this.id = id;
        this.name = name;
        this.estoque = estoque;
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

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
