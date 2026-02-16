import javax.swing.*;

public class RacePaceAnalyzer extends JFrame {

    public RacePaceAnalyzer() {
        setTitle("F1 Race Pace Analyzer");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Customers", new CustomerPage());
        tabs.addTab("Products", new ProductPage());
        tabs.addTab("Purchases", new InvoicePage());
        tabs.addTab("Analysis", new AnalysisPage());

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RacePaceAnalyzer::new);
    }
}
