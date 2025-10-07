package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.MaintenanceOrderBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.bean.OrderPieceBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.bean.PieceBeanUtil;
import sistema.de.manutencao.industrial.infrastructure.exception.NoMatchArrayInput;
import sistema.de.manutencao.industrial.infrastructure.util.ConsoleUtil;
import sistema.de.manutencao.industrial.infrastructure.util.ListUtil;
import sistema.de.manutencao.industrial.module.order_piece.application.dto.create.CreateOrderPieceRequest;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.MaintenanceOrderController;
import sistema.de.manutencao.industrial.view.controller.OrderPieceController;
import sistema.de.manutencao.industrial.view.controller.PieceController;

public class MenuCreateOrderPiece extends Menu {

    private final OrderPieceController orderPieceController;

    private final PieceController pieceController;
    private final MaintenanceOrderController maintenanceOrderController;

    protected MenuCreateOrderPiece(Reader reader, OrderPieceController orderPieceController, PieceController pieceController, MaintenanceOrderController maintenanceOrderController) {
        super(reader);
        this.orderPieceController = orderPieceController;
        this.pieceController = pieceController;
        this.maintenanceOrderController = maintenanceOrderController;
    }

    @Override
    public void execute() {
        CreateOrderPieceRequest createOrderPieceRequest = callMenu();

        Menu menu = switch (createOrderPieceRequest){
            case null -> Menus.toInstanceMainMenu(getReader());
            default -> createOrderPiece(createOrderPieceRequest);
        };

        setNextMenu(menu);
    }

    private Menu createOrderPiece(CreateOrderPieceRequest createOrderPieceRequest) {
        var createOrderPieceResponse = orderPieceController.create(createOrderPieceRequest);

        System.out.println("| Order piece register with sucess");
        System.out.println(createOrderPieceResponse);

        return Menus.toInstanceMainMenu(getReader());
    }

    private CreateOrderPieceRequest callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                            CRIAR ORDEM DE PEÇA ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" Digite os dados da ordem de peça: ( Digite 0 para cancelar ) ");


        System.out.println(" Ordem de manutenção: ");
        long maintenanceOrder = getMaintenanceOrder();

        if(maintenanceOrder == -1) return null;

        System.out.println(" Piece: ");
        long piece = getPiece();

        System.out.println(" Quantiy: ");
        double quantity = getReader().readDouble();

        return new CreateOrderPieceRequest(maintenanceOrder, piece, quantity);

    }

    private long getPiece() {

        var pieceList = pieceController.getAll();

        ConsoleUtil.printList(pieceList);
        int input = getReader().readInteger();

        if(input == -1) return input;


        if(ListUtil.isAItemInList(pieceList, input)){
            return pieceList.get(input).id();
        }

        throw new NoMatchArrayInput();
    }

    private long getMaintenanceOrder() {

        var maintenanceList = maintenanceOrderController.getAll();

        ConsoleUtil.printList(maintenanceList);
        int input = getReader().readInteger();

        if(input == -1) return input;


        if(ListUtil.isAItemInList(maintenanceList, input)){
            return maintenanceList.get(input).id();
        }

        throw new NoMatchArrayInput();
    }

    public static Menu toInstance(Reader reader) {
        return new MenuCreateOrderPiece(reader, OrderPieceBeanUtil.toInstanceController(), PieceBeanUtil.toInstanceController(), MaintenanceOrderBeanUtil.toInstanceController());
    }
}
