package Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection con = null;
    public static Connection getConnection() {
        if (con != null)
            return con;
        // you can also get url, user, pass from settings file
        String url = "jdbc:postgresql://localhost:5432/DatabaseViorel1";
        String user = "postgres";
        String pass = "1234567";
        return getConnection(url, user, pass);
    }

    private static Connection getConnection(String url, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}