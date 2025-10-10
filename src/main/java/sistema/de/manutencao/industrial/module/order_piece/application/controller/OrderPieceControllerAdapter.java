package sistema.de.manutencao.industrial.module.order_piece.application.controller;

import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceRequest;
import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceResponse;
import sistema.de.manutencao.industrial.module.order_piece.domain.service.OrderPieceService;
import sistema.de.manutencao.industrial.view.controller.OrderPieceController;

public class OrderPieceControllerAdapter implements OrderPieceController {

    private final OrderPieceService orderPieceService;

    public OrderPieceControllerAdapter(OrderPieceService orderPieceService) {
        this.orderPieceService = orderPieceService;
    }

    @Override
    public CreateOrderPieceResponse create(CreateOrderPieceRequest createOrderPieceRequest) {
        return orderPieceService.create(createOrderPieceRequest);
    }

}
