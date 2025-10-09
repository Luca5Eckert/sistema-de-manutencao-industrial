package sistema.de.manutencao.industrial.module.piece.domain.port;

import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

public interface PieceRepository {
    void save(PieceEntity piece);

    boolean isUnique(PieceEntity piece);
}
