package sistema.de.manutencao.industrial.infrastructure.util;

import sistema.de.manutencao.industrial.view.Reader;

import java.util.Scanner;

public class ReaderAdapter implements Reader {

    private final Scanner scanner;

    public ReaderAdapter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInteger() {
        try{
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("Integer");
        }
    }

    @Override
    public double readDouble() {
        try{
            return scanner.nextDouble();
        } catch (Exception e) {
            throw new RuntimeException("Double");
        }
    }

    @Override
    public long readLong() {
        try{
            return scanner.nextLong();
        } catch (Exception e) {
            throw new RuntimeException("Long");
        }
    }
}
