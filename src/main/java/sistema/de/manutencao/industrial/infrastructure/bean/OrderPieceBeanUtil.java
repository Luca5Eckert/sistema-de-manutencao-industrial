package sistema.de.manutencao.industrial.infrastructure.bean;

import sistema.de.manutencao.industrial.infrastructure.persistence.order_piece.OrderPieceDao;
import sistema.de.manutencao.industrial.infrastructure.persistence.order_piece.OrderPieceRepositoryAdapter;
import sistema.de.manutencao.industrial.module.order_piece.application.controller.OrderPieceControllerAdapter;
import sistema.de.manutencao.industrial.module.order_piece.domain.mapper.OrderPieceMapper;
import sistema.de.manutencao.industrial.module.order_piece.domain.port.OrderPieceRepository;
import sistema.de.manutencao.industrial.module.order_piece.domain.service.OrderPieceService;
import sistema.de.manutencao.industrial.view.controller.OrderPieceController;

public class OrderPieceBeanUtil {


    private final static OrderPieceDao ORDER_PIECE_DAO = new OrderPieceDao();
    private final static OrderPieceRepository ORDER_PIECE_REPOSITORY = new OrderPieceRepositoryAdapter(ORDER_PIECE_DAO);
    private final static OrderPieceMapper ORDER_PIECE_MAPPER = new OrderPieceMapper();
    private final static OrderPieceService ORDER_PIECE_SERVICE = new OrderPieceService(ORDER_PIECE_REPOSITORY, ORDER_PIECE_MAPPER);
    private final static OrderPieceController ORDER_PIECE_CONTROLLER = new OrderPieceControllerAdapter(ORDER_PIECE_SERVICE);

    public static OrderPieceController toInstanceController(){
        return ORDER_PIECE_CONTROLLER;
    }
}
