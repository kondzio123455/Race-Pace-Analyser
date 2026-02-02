import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

    int customerID;
    String firstName;
    String secondName;
    String email;

    public Customer(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;

        String sql = "INSERT INTO customers (FirstName, SecondName, Email) VALUES";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, firstName);
            ps.setString(2, secondName);
            ps.setString(3, email);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.customerID = rs.getInt(1);
            }

            System.out.println("Customer created with ID: " + customerID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer(int customerID, boolean delete) {
        this.customerID = customerID;
        String sql = "DELETE FROM customers WHERE CustomerID = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerID);
            int rows = ps.executeUpdate();
            System.out.println(rows + " customer deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
