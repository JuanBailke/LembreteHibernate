package lembretehibernate.infra;

import java.sql.*;

/**
 *
 * @author mello
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lembretes?useTimezone=true"
                    + "serverTimezone=UTC",
                    "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
