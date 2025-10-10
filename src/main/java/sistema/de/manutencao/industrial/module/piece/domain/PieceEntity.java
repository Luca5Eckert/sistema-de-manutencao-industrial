package sistema.de.manutencao.industrial.module.piece.domain;

public class PieceEntity {

    private final long id;

    private String name;
    private double stock;

    public PieceEntity(String name, double stock) {
        this.id = -1;
        this.name = name;
        this.stock = stock;
    }

    public PieceEntity(long id, String name, double stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public PieceEntity(long id) {
        this.id = id;
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
