import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

    int driverID;
    String driverName;
    String team;

    public Driver(String driverName, String team) {
        this.driverName = driverName;
        this.team = team;

        String sql = "INSERT INTO drivers (DriverName, Team) VALUES (?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, driverName);
            ps.setString(2, team);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.driverID = rs.getInt(1);
            }

            System.out.println("Driver created with ID: " + driverID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver(int driverID, boolean delete) {
        this.driverID = driverID;
        String sql = "DELETE FROM drivers WHERE DriverID = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, driverID);
            int rows = ps.executeUpdate();
            System.out.println(rows + " driver deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}