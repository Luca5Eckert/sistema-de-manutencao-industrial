package sistema.de.manutencao.industrial.view.menu;

import sistema.de.manutencao.industrial.infrastructure.bean.PieceBeanUtil;
import sistema.de.manutencao.industrial.module.piece.application.register.RegisterPieceRequest;
import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.controller.PieceController;

public class MenuRegisterPiece extends Menu {

    private final PieceController pieceController;

    protected MenuRegisterPiece(Reader reader, PieceController pieceController) {
        super(reader);
        this.pieceController = pieceController;
    }

    @Override
    public void execute() {
        var registerPieceRequest = callMenu();

        Menu menu = switch (registerPieceRequest){
            case null -> Menus.toInstanceMainMenu(getReader());
            default -> registerPiece(registerPieceRequest);
        };

        setNextMenu(menu);
    }

    private Menu registerPiece(RegisterPieceRequest registerPieceRequest) {
        var pieceRegisterResponse = pieceController.register(registerPieceRequest);

        System.out.println("| Técnico registrado com succeso");
        System.out.println(pieceRegisterResponse);

        return new MenuMain(getReader());
    }

    private RegisterPieceRequest callMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                               CADASTRAR PEÇA");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" ");

        System.out.println(" Nome: ");
        String name = getReader().readLine();

        System.out.println(" Quantidade: ");
        double quantity = getReader().readDouble();

        return new RegisterPieceRequest(name, quantity);
    }

    public static Menu toInstance(Reader reader) {
        return new MenuRegisterPiece(reader, PieceBeanUtil.toInstanceController());
    }
}
