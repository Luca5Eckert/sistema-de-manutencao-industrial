package sistema.de.manutencao.industrial.view.controller;

import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceRequest;
import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceResponse;

public interface OrderPieceController {
    CreateOrderPieceResponse create(CreateOrderPieceRequest createOrderPieceRequest);
}
