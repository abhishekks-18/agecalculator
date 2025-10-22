import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

/**
 * Age Calculator Application using Java Swing
 * Calculates age in years, months, and days from selected date of birth
 */
public class AgeCalculator extends JFrame {
    
    // GUI Components
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private JButton calculateButton;
    private JLabel resultLabel;
    
    // Month names array
    private final String[] months = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    
    /**
     * Constructor - initializes the GUI
     */
    public AgeCalculator() {
        // Set up the frame
        setTitle("Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        
        // Initialize components
        initComponents();
        
        // Make frame visible
        setVisible(true);
    }
    
    /**
     * Initialize and layout all GUI components
     */
    private void initComponents() {
        // Create main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Create gradient background
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(74, 144, 226),
                    0, getHeight(), new Color(138, 43, 226)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Add decorative circles
                g2d.setColor(new Color(255, 255, 255, 30));
                g2d.fillOval(-50, -50, 200, 200);
                g2d.fillOval(getWidth() - 150, getHeight() - 150, 200, 200);
                g2d.fillOval(getWidth() - 100, -80, 180, 180);
            }
        };
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        // Title label with icon
        JLabel titleLabel = new JLabel("🎂 Age Calculator 🎂", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Center panel with white rounded card effect
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw rounded rectangle with shadow
                g2d.setColor(new Color(0, 0, 0, 30));
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 30, 30);
                
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 30, 30);
            }
        };
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        // Label for date of birth
        JLabel dobLabel = new JLabel("📅 Select Your Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.BOLD, 22));
        dobLabel.setForeground(new Color(74, 144, 226));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(dobLabel, gbc);
        
        // Day ComboBox (1-31)
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel dayLabel = new JLabel("Day");
        dayLabel.setFont(new Font("Arial", Font.BOLD, 18));
        dayLabel.setForeground(new Color(100, 100, 100));
        centerPanel.add(dayLabel, gbc);
        
        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        dayComboBox.setPreferredSize(new Dimension(120, 50));
        dayComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        dayComboBox.setBackground(new Color(245, 245, 250));
        gbc.gridy = 2;
        centerPanel.add(dayComboBox, gbc);
        
        // Month ComboBox
        gbc.gridy = 1;
        gbc.gridx = 1;
        JLabel monthLabel = new JLabel("Month");
        monthLabel.setFont(new Font("Arial", Font.BOLD, 18));
        monthLabel.setForeground(new Color(100, 100, 100));
        centerPanel.add(monthLabel, gbc);
        
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setPreferredSize(new Dimension(160, 50));
        monthComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        monthComboBox.setBackground(new Color(245, 245, 250));
        gbc.gridy = 2;
        centerPanel.add(monthComboBox, gbc);
        
        // Year ComboBox (1900 to current year)
        gbc.gridy = 1;
        gbc.gridx = 2;
        JLabel yearLabel = new JLabel("Year");
        yearLabel.setFont(new Font("Arial", Font.BOLD, 18));
        yearLabel.setForeground(new Color(100, 100, 100));
        centerPanel.add(yearLabel, gbc);
        
        yearComboBox = new JComboBox<>();
        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear; i >= 1900; i--) {
            yearComboBox.addItem(i);
        }
        yearComboBox.setPreferredSize(new Dimension(120, 50));
        yearComboBox.setFont(new Font("Arial", Font.BOLD, 16));
        yearComboBox.setBackground(new Color(245, 245, 250));
        gbc.gridy = 2;
        centerPanel.add(yearComboBox, gbc);
        
        // Calculate button with hover effect
        calculateButton = new JButton("Calculate Age") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2d.setColor(new Color(255, 140, 0));
                } else if (getModel().isRollover()) {
                    g2d.setColor(new Color(255, 165, 0));
                } else {
                    g2d.setColor(new Color(255, 127, 80));
                }
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                
                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(getText(), x, y);
            }
        };
        calculateButton.setFont(new Font("Arial", Font.BOLD, 20));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorderPainted(false);
        calculateButton.setContentAreaFilled(false);
        calculateButton.setPreferredSize(new Dimension(280, 60));
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculateButton.addActionListener(new CalculateButtonListener());
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 15, 15, 15);
        centerPanel.add(calculateButton, gbc);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Result panel with card design
        JPanel resultPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 255, 255, 220));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        resultPanel.setOpaque(false);
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setPreferredSize(new Dimension(700, 80));
        
        resultLabel = new JLabel("🎉 Your age will be displayed here 🎉", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setForeground(new Color(138, 43, 226));
        resultPanel.add(resultLabel, BorderLayout.CENTER);
        
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
    }
    
    /**
     * ActionListener for Calculate button
     */
    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculateAge();
        }
    }
    
    /**
     * Calculate age based on selected date of birth
     */
    private void calculateAge() {
        try {
            // Get selected values
            int day = (Integer) dayComboBox.getSelectedItem();
            int month = monthComboBox.getSelectedIndex() + 1; // Index starts at 0
            int year = (Integer) yearComboBox.getSelectedItem();
            
            // Create LocalDate for DOB
            LocalDate dob = LocalDate.of(year, month, day);
            LocalDate today = LocalDate.now();
            
            // Check if DOB is in the future
            if (dob.isAfter(today)) {
                resultLabel.setText("Date of birth cannot be in the future!");
                resultLabel.setForeground(Color.RED);
                return;
            }
            
            // Calculate period between DOB and today
            Period age = Period.between(dob, today);
            
            // Display result
            String result = String.format("✨ Your age is: %d years, %d months, %d days ✨",
                    age.getYears(), age.getMonths(), age.getDays());
            resultLabel.setText(result);
            resultLabel.setForeground(new Color(0, 150, 0));
            
        } catch (Exception ex) {
            // Handle invalid date selection
            resultLabel.setText("Invalid date! Please select a valid date.");
            resultLabel.setForeground(Color.RED);
        }
    }
    
    /**
     * Main method to run the application
     */
    public static void main(String[] args) {
        // Run GUI on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculator();
            }
        });
    }
}
