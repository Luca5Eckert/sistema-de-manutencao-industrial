package sistema.de.manutencao.industrial.infrastructure.bean;

import sistema.de.manutencao.industrial.infrastructure.persistence.piece.PieceDao;
import sistema.de.manutencao.industrial.infrastructure.persistence.piece.PieceRepositoryAdapter;
import sistema.de.manutencao.industrial.module.piece.application.controller.PieceControllerAdapter;
import sistema.de.manutencao.industrial.module.piece.domain.mapper.PieceMapper;
import sistema.de.manutencao.industrial.module.piece.domain.port.PieceRepository;
import sistema.de.manutencao.industrial.module.piece.domain.service.PieceService;
import sistema.de.manutencao.industrial.view.controller.PieceController;

public class PieceBeanUtil {


    private final static PieceDao PIECE_DAO = new PieceDao();
    private final static PieceRepository PIECE_REPOSITORY = new PieceRepositoryAdapter(PIECE_DAO);
    private final static PieceMapper PIECE_MAPPER = new PieceMapper();
    private final static PieceService PIECE_SERVICE = new PieceService(PIECE_REPOSITORY, PIECE_MAPPER);
    private final static PieceController PIECE_CONTROLLER = new PieceControllerAdapter(PIECE_SERVICE);


    public static PieceController toInstanceController(){
        return PIECE_CONTROLLER;
    }

}
