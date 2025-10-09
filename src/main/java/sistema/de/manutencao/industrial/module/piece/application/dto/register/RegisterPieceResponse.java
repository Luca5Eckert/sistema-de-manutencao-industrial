package sistema.de.manutencao.industrial.module.piece.application.dto.register;

public record RegisterPieceResponse(String name, double quantity) {

    @Override
    public String toString() {
        return " Nome: " + name
                + " Estoque: " + quantity;
    }

}
