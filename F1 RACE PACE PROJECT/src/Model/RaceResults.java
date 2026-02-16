import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RaceResults {

    int resultID;
    int invoiceID;
    int driverID;
    double averagePace;
    double fastestLap;

    public RaceResults(int invoiceID, int driverID, double averagePace, double fastestLap) {
        this.invoiceID = invoiceID;
        this.driverID = driverID;
        this.averagePace = averagePace;
        this.fastestLap = fastestLap;

        String sql = "INSERT INTO race_results (InvoiceID, DriverID, AveragePace, FastestLap) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, invoiceID);
            ps.setInt(2, driverID);
            ps.setDouble(3, averagePace);
            ps.setDouble(4, fastestLap);
            ps.executeUpdate();

            System.out.println("Race result recorded for driver ID: " + driverID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}