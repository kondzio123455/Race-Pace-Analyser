import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class invoice {

    int invoiceID;
    int customerID;
    int productID;
    String runDate;

    public invoice(int customerID, int productID, String runDate) {
        this.customerID = customerID;
        this.productID = productID;
        this.runDate = runDate;

        String sql = "INSERT INTO invoices (CustomerID, ProductID, RunDate) VALUES (?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, customerID);
            ps.setInt(2, productID);
            ps.setString(3, runDate);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.invoiceID = rs.getInt(1);
            }

            System.out.println("Invoice created with ID: " + invoiceID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public invoice(int invoiceID, boolean delete) {
        this.invoiceID = invoiceID;
        String sql = "DELETE FROM invoices WHERE InvoiceID = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, invoiceID);
            int rows = ps.executeUpdate();
            System.out.println(rows + " invoice deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}