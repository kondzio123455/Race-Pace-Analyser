import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {

    int productID;
    String productName;
    String description;
    double price;

    public Product(String productName, String description, double price) {
        this.productName = productName;
        this.description = description;
        this.price = price;

        String sql = "INSERT INTO products (ProductName, Description, Price) VALUES (?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, productName);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.productID = rs.getInt(1);
            }

            System.out.println("Product created with ID: " + productID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product(int productID, boolean delete) {
        this.productID = productID;
        String sql = "DELETE FROM products WHERE ProductID = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productID);
            int rows = ps.executeUpdate();
            System.out.println(rows + " product deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}