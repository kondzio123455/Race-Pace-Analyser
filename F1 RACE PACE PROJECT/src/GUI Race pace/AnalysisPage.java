import java.awt.*;
import javax.swing.*;

public class AnalysisPage extends JPanel {

    JTextField driverField = new JTextField(10);
    JTextField lapField = new JTextField(6);
    JComboBox<String> tyreBox = new JComboBox<>(new String[]{"Soft", "Medium", "Hard"});
    JTable table = new JTable();

    public AnalysisPage() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.add(new JLabel("Driver:"));
        form.add(driverField);
        form.add(new JLabel("Lap Time:"));
        form.add(lapField);
        form.add(new JLabel("Tyre:"));
        form.add(tyreBox);

        JButton addLapBtn = new JButton("Add Lap");
        JButton analyzeBtn = new JButton("Run Analysis");

        form.add(addLapBtn);
        form.add(analyzeBtn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

