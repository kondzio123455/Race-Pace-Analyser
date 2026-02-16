import javax.swing.*;
import java.awt.*;

public class InvoicesPage extends JPanel {

    JComboBox<String> customerBox = new JComboBox<>();
    JComboBox<String> productBox = new JComboBox<>();
    JTextField raceField = new JTextField(10);
    JTable table = new JTable();

    public InvoicesPage() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.add(new JLabel("Customer:"));
        form.add(customerBox);
        form.add(new JLabel("Product:"));
        form.add(productBox);
        form.add(new JLabel("Race:"));
        form.add(raceField);

        JButton createBtn = new JButton("Create Purchase");
        JButton deleteBtn = new JButton("Delete");

        form.add(createBtn);
        form.add(deleteBtn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

