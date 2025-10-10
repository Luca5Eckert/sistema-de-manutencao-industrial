package sistema.de.manutencao.industrial.module.order_piece.domain.service;

import sistema.de.manutencao.industrial.module.maintenance_order.domain.MaintenanceOrderEntity;
import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceRequest;
import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceResponse;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceEntity;
import sistema.de.manutencao.industrial.module.order_piece.domain.OrderPieceId;
import sistema.de.manutencao.industrial.module.order_piece.domain.exception.OrderPieceNotUniqueException;
import sistema.de.manutencao.industrial.module.order_piece.domain.mapper.OrderPieceMapper;
import sistema.de.manutencao.industrial.module.order_piece.domain.port.OrderPieceRepository;
import sistema.de.manutencao.industrial.module.piece.domain.PieceEntity;

public class OrderPieceService {

    private final OrderPieceRepository orderPieceRepository;
    private final OrderPieceMapper orderPieceMapper;

    public OrderPieceService(OrderPieceRepository orderPieceRepository, OrderPieceMapper orderPieceMapper) {
        this.orderPieceRepository = orderPieceRepository;
        this.orderPieceMapper = orderPieceMapper;
    }

    public CreateOrderPieceResponse create(CreateOrderPieceRequest createOrderPieceRequest) {
        MaintenanceOrderEntity maintenanceOrderEntity = new MaintenanceOrderEntity(createOrderPieceRequest.idMaintenanceOrder());
        PieceEntity pieceEntity = new PieceEntity(createOrderPieceRequest.idPiece());

        OrderPieceId orderPieceId = new OrderPieceId(maintenanceOrderEntity, pieceEntity);

        if(!orderPieceRepository.isUnique(orderPieceId)) throw new OrderPieceNotUniqueException();

        OrderPieceEntity orderPieceEntity = new OrderPieceEntity(orderPieceId, createOrderPieceRequest.quantity());

        orderPieceRepository.create(orderPieceEntity);

        return orderPieceMapper.toCreateResponse(orderPieceEntity);
    }
}
