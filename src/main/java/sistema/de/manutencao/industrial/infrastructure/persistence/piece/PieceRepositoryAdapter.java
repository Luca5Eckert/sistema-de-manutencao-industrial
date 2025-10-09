package sistema.de.manutencao.industrial.infrastructure.persistence.piece;

import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;
import sistema.de.manutencao.industrial.module.piece.domain.port.PieceRepository;

public class PieceRepositoryAdapter implements PieceRepository {

    private final PieceDao pieceDao;

    public PieceRepositoryAdapter(PieceDao pieceDao) {
        this.pieceDao = pieceDao;
    }

    @Override
    public void save(PieceEntity piece) {
        pieceDao.save(piece);
    }

    @Override
    public boolean isUnique(PieceEntity piece) {
        return pieceDao.isUnique(piece);
    }
}
