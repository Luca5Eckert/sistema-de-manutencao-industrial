package sistema.de.manutencao.industrial.module.piece.domain.port;

import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

import java.util.Arrays;
import java.util.List;

public interface PieceRepository {
    void save(PieceEntity piece);

    boolean isUnique(PieceEntity piece);

    List<PieceEntity> getAll();
}
