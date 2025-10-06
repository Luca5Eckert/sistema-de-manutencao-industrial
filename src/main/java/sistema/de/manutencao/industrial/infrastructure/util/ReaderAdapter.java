package sistema.de.manutencao.industrial.infrastructure.util;

import sistema.de.manutencao.industrial.view.Reader;

import java.util.Scanner;

public class ReaderAdapter implements Reader {

    private final Scanner scanner;

    public ReaderAdapter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String lerLinha() {
        return scanner.nextLine();
    }

    @Override
    public int lerInteger() {
        try{
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Integer");
        }
    }

    @Override
    public double lerDouble() {
        try{
            return scanner.nextDouble();
        } catch (Exception e) {
            throw new RuntimeException("Double");
        }
    }

    @Override
    public long lerLong() {
        try{
            return scanner.nextLong();
        } catch (Exception e) {
            throw new RuntimeException("Long");
        }
    }
}
