import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class CustomCarBuilder_Refactored extends JFrame {
    private JComboBox<String> modelComboBox;
    private JComboBox<String> seatMaterialComboBox;
    private JCheckBox soundSystemCheckBox;
    private JCheckBox customSteeringCheckBox;
    private JCheckBox ambientLightingCheckBox;
    private JButton seatColorButton, dashColorButton, lightColorButton, summaryButton;
    private JTextArea summaryArea;
    private JLabel carImageLabel;

    private Color seatColor = Color.GRAY;
    private Color dashColor = Color.DARK_GRAY;
    private Color lightColor = Color.BLUE;

    private final HashMap<String, String> carImages = new HashMap<>();
    private final HashMap<String, Integer> carBasePrices = new HashMap<>();
    private final HashMap<String, Integer> seatPrices = new HashMap<>();

    public CustomCarBuilder_Refactored() {
        setTitle("Custom Car Builder");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add image paths
        carImages.put("Sedan", "sedan.jpg");
        carImages.put("SUV", "suv.jpg");
        carImages.put("Convertible", "convertible.jpg");

        // Base prices
        carBasePrices.put("Sedan", 1000000);
        carBasePrices.put("SUV", 1500000);
        carBasePrices.put("Convertible", 2000000);

        seatPrices.put("Leather", 50000);
        seatPrices.put("Fabric", 25000);
        seatPrices.put("Synthetic", 35000);

        // Top panel: model + image
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel modelPanel = new JPanel();
        modelPanel.add(new JLabel("Choose Car Model:"));
        modelComboBox = new JComboBox<>(new String[]{"Sedan", "SUV", "Convertible"});
        modelPanel.add(modelComboBox);
        topPanel.add(modelPanel, BorderLayout.NORTH);

        carImageLabel = new JLabel();
        carImageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateCarImage((String) modelComboBox.getSelectedItem());
        topPanel.add(carImageLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Center panel: customization options
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createTitledBorder("Customization"));

        seatMaterialComboBox = new JComboBox<>(new String[]{"Leather", "Fabric", "Synthetic"});
        centerPanel.add(new JLabel("Seat Material:"));
        centerPanel.add(seatMaterialComboBox);

        seatColorButton = new JButton("Choose Seat Color");
        seatColorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Select Seat Color", seatColor);
            if (chosen != null) seatColor = chosen;
        });
        centerPanel.add(seatColorButton);

        dashColorButton = new JButton("Choose Dashboard Color");
        dashColorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Select Dashboard Color", dashColor);
            if (chosen != null) dashColor = chosen;
        });
        centerPanel.add(dashColorButton);

        lightColorButton = new JButton("Choose Ambient Light Color");
        lightColorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Select Ambient Light Color", lightColor);
            if (chosen != null) lightColor = chosen;
        });
        centerPanel.add(lightColorButton);

        JPanel checkboxPanel = new JPanel(new GridLayout(3, 1));
        soundSystemCheckBox = new JCheckBox("Premium Sound System");
        customSteeringCheckBox = new JCheckBox("Custom Steering Wheel");
        ambientLightingCheckBox = new JCheckBox("Ambient Lighting Kit");
        checkboxPanel.add(soundSystemCheckBox);
        checkboxPanel.add(customSteeringCheckBox);
        checkboxPanel.add(ambientLightingCheckBox);
        centerPanel.add(checkboxPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel: summary
        JPanel bottomPanel = new JPanel(new BorderLayout());
        summaryButton = new JButton("Generate Summary");
        summaryButton.addActionListener(e -> generateSummary());
        bottomPanel.add(summaryButton, BorderLayout.NORTH);

        summaryArea = new JTextArea(10, 80);
        summaryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(summaryArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        modelComboBox.addActionListener(e -> updateCarImage((String) modelComboBox.getSelectedItem()));

        setVisible(true);
    }

    private void updateCarImage(String model) {
        String path = carImages.get(model);
        if (path != null) {
            ImageIcon icon = new ImageIcon(path);
            Image scaledImage = icon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            carImageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            carImageLabel.setIcon(null);
        }
    }

    private void generateSummary() {
        String model = (String) modelComboBox.getSelectedItem();
        String seatMaterial = (String) seatMaterialComboBox.getSelectedItem();
        int totalCost = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("Car Model: ").append(model).append("\n");
        sb.append("Seat Material: ").append(seatMaterial).append("\n");
        sb.append("Seat Color: ").append(colorToHex(seatColor)).append("\n");
        sb.append("Dashboard Color: ").append(colorToHex(dashColor)).append("\n");
        sb.append("Ambient Light Color: ").append(colorToHex(lightColor)).append("\n");
        sb.append("Optional Features:\n");

        totalCost += carBasePrices.getOrDefault(model, 0);
        totalCost += seatPrices.getOrDefault(seatMaterial, 0);

        if (soundSystemCheckBox.isSelected()) {
            sb.append(" - Premium Sound System (₹30000)\n");
            totalCost += 30000;
        }
        if (customSteeringCheckBox.isSelected()) {
            sb.append(" - Custom Steering Wheel (₹20000)\n");
            totalCost += 20000;
        }
        if (ambientLightingCheckBox.isSelected()) {
            sb.append(" - Ambient Lighting Kit (₹15000)\n");
            totalCost += 15000;
        }

        sb.append("\nTotal Estimated Cost: ₹").append(String.format("%,d", totalCost));
        summaryArea.setText(sb.toString());
    }

    private String colorToHex(Color color) {
        return "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomCarBuilder_Refactored::new);
    }
}