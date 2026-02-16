import java.awt.*;
import javax.swing.*;

public class CustomerPage extends JPanel {

    JTextField teamField = new JTextField(15);
    JTextField emailField = new JTextField(15);
    JTable table = new JTable();

    public CustomerPage() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.add(new JLabel("Team Name:"));
        form.add(teamField);
        form.add(new JLabel("Email:"));
        form.add(emailField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        form.add(addBtn);
        form.add(updateBtn);
        form.add(deleteBtn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Hook buttons to JDBC later
    }
}
