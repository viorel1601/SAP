package Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connect = null;
    public static Connection getConnection() {
        if (connect != null)
            return connect;
        // you can also get url, user, password from settings file
        String url = "jdbc:postgresql://localhost:5432/DatabaseViorel1";
        String user = "postgres";
        String password = "1234567";
        return getConnection(url, user, password);
    }

    private static Connection getConnection(String url, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return connect;
    }
}