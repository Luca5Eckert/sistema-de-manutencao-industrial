package sistema.de.manutencao.industrial.infrastructure.util;

import sistema.de.manutencao.industrial.view.Reader;
import sistema.de.manutencao.industrial.view.exception.ReaderException;

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
            var num = scanner.nextInt();
            scanner.nextLine();
            return num;
        } catch (Exception e) {
            scanner.nextLine();
            throw new ReaderException("Integer");
        }
    }

    @Override
    public double readDouble() {
        try{
            var num = scanner.nextDouble();
            scanner.nextLine();
            return num;
        } catch (Exception e) {
            scanner.nextLine();
            throw new ReaderException("Double");
        }
    }

    @Override
    public long readLong() {
        try{
            var num = scanner.nextLong();
            scanner.nextLine();
            return num;
        } catch (Exception e) {
            scanner.nextLine();
            throw new ReaderException("Long");
        }
    }
}
