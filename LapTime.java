import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LapTime {

    int lapID;
    int driverID;
    String raceName;
    int lapNumber;
    double lapTimeSeconds;

    public LapTime(int driverID, String raceName, int lapNumber, double lapTimeSeconds) {
        this.driverID = driverID;
        this.raceName = raceName;
        this.lapNumber = lapNumber;
        this.lapTimeSeconds = lapTimeSeconds;

        String sql = "INSERT INTO lap_times (DriverID, RaceName, LapNumber, LapTimeSeconds) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, driverID);
            ps.setString(2, raceName);
            ps.setInt(3, lapNumber);
            ps.setDouble(4, lapTimeSeconds);
            ps.executeUpdate();

            System.out.println("Lap time recorded for driver ID: " + driverID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
