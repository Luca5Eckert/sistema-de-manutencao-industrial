package sistema.de.manutencao.industrial.module.piece.application.dto.list;

public record PieceListResponse(long id, String name, double quantity) {

    @Override
    public String toString() {
        return " Nome: " + name + "       Quantidade: " + quantity;
    }
}
