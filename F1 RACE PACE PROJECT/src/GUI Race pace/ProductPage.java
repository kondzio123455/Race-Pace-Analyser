import java.awt.*;
import javax.swing.*;

public class ProductPage extends JPanel {

    JTextField nameField = new JTextField(15);
    JTextField priceField = new JTextField(8);
    JTable table = new JTable();

    public ProductPage() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.add(new JLabel("Analysis Type:"));
        form.add(nameField);
        form.add(new JLabel("Price:"));
        form.add(priceField);

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        form.add(addBtn);
        form.add(deleteBtn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

