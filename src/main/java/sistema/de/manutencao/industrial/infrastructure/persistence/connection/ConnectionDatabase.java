package sistema.de.manutencao.industrial.infrastructure.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema-de-manutencao-industrial-db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection toInstance() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
