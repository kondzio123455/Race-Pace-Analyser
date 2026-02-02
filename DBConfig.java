import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {

    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load database config file");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}