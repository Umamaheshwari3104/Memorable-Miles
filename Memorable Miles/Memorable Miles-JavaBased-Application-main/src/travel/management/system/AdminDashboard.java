package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton viewBookingsButton, managePackagesButton, manageHotelsButton, logoutButton, reportButton, reportButton1, reportButton2, reportButton3, reportButton4;
    JTextArea resultTextArea;

    public AdminDashboard() {
    setTitle("Admin Dashboard");
    setBounds(400, 150, 1500, 800);  // Updated window size
    getContentPane().setBackground(new Color(6, 7, 15));
    setLayout(null);
    setLocationRelativeTo(null);

    JLabel dashboardLabel = new JLabel("Admin Dashboard (Memorable Miles)");
    dashboardLabel.setBounds(50, 60, 300, 30);  // Adjusted label position
    dashboardLabel.setFont(new Font("Poppins", Font.BOLD, 15));
    dashboardLabel.setForeground(Color.WHITE);
    add(dashboardLabel);

    viewBookingsButton = new JButton("View Bookings");
    viewBookingsButton.setBackground(new Color(82, 94, 183));
    viewBookingsButton.setForeground(Color.WHITE);
    viewBookingsButton.setBounds(50, 200, 200, 30);
    viewBookingsButton.setFont(new Font("Poppins", Font.PLAIN, 12));
    viewBookingsButton.addActionListener(this);
    viewBookingsButton.setBorderPainted(false);
    add(viewBookingsButton);

    managePackagesButton = new JButton("View Users");
    managePackagesButton.setBackground(new Color(82, 94, 183));
    managePackagesButton.setForeground(Color.WHITE);
    managePackagesButton.setBounds(50, 250, 200, 30);
    managePackagesButton.setFont(new Font("Poppins", Font.PLAIN, 12));
    managePackagesButton.addActionListener(this);
    managePackagesButton.setBorderPainted(false);
    add(managePackagesButton);

    manageHotelsButton = new JButton("View Hotels");
    manageHotelsButton.setBackground(new Color(82, 94, 183));
    manageHotelsButton.setForeground(Color.WHITE);
    manageHotelsButton.setBounds(50, 300, 200, 30);
    manageHotelsButton.setFont(new Font("Poppins", Font.PLAIN, 12));
    manageHotelsButton.addActionListener(this);
    manageHotelsButton.setBorderPainted(false);
    add(manageHotelsButton);
    JLabel dashboardLabe2 = new JLabel("Generate Reports");
    dashboardLabe2.setBounds(50, 370, 300, 30);  // Adjusted label position
    dashboardLabe2.setFont(new Font("Poppins", Font.BOLD, 13));
    dashboardLabe2.setForeground(Color.WHITE);
    add(dashboardLabe2);
    reportButton = new JButton("Package Booking ");
    reportButton.setBackground(new Color(0, 45, 143));
    reportButton.setForeground(Color.WHITE);
    reportButton.setBounds(50, 420, 200, 30);
    reportButton.setFont(new Font("Poppins", Font.PLAIN, 12));
    reportButton.addActionListener(this);
    reportButton.setBorderPainted(false);
    add(reportButton);
    reportButton1 = new JButton("Hotel Booking");
    reportButton1.setBackground(new Color(0, 45, 143));
    reportButton1.setForeground(Color.WHITE);
    reportButton1.setBounds(50, 470, 200, 30);
    reportButton1.setFont(new Font("Poppins", Font.PLAIN, 12));
    reportButton1.addActionListener(this);
    reportButton1.setBorderPainted(false);
    add(reportButton1);
    reportButton2 = new JButton("Package Details");
    reportButton2.setBackground(new Color(0, 45, 143));
    reportButton2.setForeground(Color.WHITE);
    reportButton2.setBounds(50, 520, 200, 30);
    reportButton2.setFont(new Font("Poppins", Font.PLAIN, 12));
    reportButton2.addActionListener(this);
    reportButton2.setBorderPainted(false);
    add(reportButton2);
    reportButton3 = new JButton("Hotel Stay");
    reportButton3.setBackground(new Color(0, 45, 143));
    reportButton3.setForeground(Color.WHITE);
    reportButton3.setBounds(50, 570, 200, 30);
    reportButton3.setFont(new Font("Poppins", Font.PLAIN, 12));
    reportButton3.addActionListener(this);
    reportButton3.setBorderPainted(false);
    add(reportButton3);
    reportButton4 = new JButton("Hotel Details");
    reportButton4.setBackground(new Color(0, 45, 143));
    reportButton4.setForeground(Color.WHITE);
    reportButton4.setBounds(50, 620, 200, 30);
    reportButton4.setFont(new Font("Poppins", Font.PLAIN, 12));
    reportButton4.addActionListener(this);
    reportButton4.setBorderPainted(false);
    add(reportButton4);

    logoutButton = new JButton("Logout");
    logoutButton.setBackground(new Color(82, 94, 183));
    logoutButton.setForeground(Color.WHITE);
    logoutButton.setBounds(50, 700, 200, 30);
    logoutButton.setFont(new Font("Poppins", Font.PLAIN, 12));
    logoutButton.addActionListener(this);
    logoutButton.setBorderPainted(false);
    add(logoutButton);

    resultTextArea = new JTextArea();
    resultTextArea.setBackground(new Color(28, 30, 50));
    resultTextArea.setForeground(Color.WHITE);
    resultTextArea.setFont(new Font("Poppins", Font.PLAIN, 14));
    resultTextArea.setEditable(false);

    JScrollPane scrollPane = new JScrollPane(resultTextArea);
    scrollPane.setBounds(300, 200, 1100, 500);  // Adjusted the scroll pane size
    add(scrollPane);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBookingsButton) {
            displayBookings();
        } else if (e.getSource() == managePackagesButton) {
            displayPackages();
        } else if (e.getSource() == manageHotelsButton) {
            displayHotels();
        } else if (e.getSource() == reportButton) {
            packagereport(); // Call generateReport method
        } else if (e.getSource() == reportButton1) {
            hotelreport(); // Call generateReport method
        } else if (e.getSource() == reportButton2) {
            popularpkg(); // Call generateReport method
        } else if (e.getSource() == reportButton3) {
            hotelstay(); // Call generateReport method;
        } else if (e.getSource() == reportButton4) {
            packagereport(); // Call generateReport method
        } else if (e.getSource() == logoutButton) {
            dispose();
        }
    }

    private void displayBookings() {
        executeQuery("SELECT * FROM bookpackage");
    }

    private void displayPackages() {
        executeQuery("SELECT * FROM account");
    }

    private void displayHotels() {
        executeQuery("SELECT * FROM bookHotel");
    }

    private void executeQuery(String query) {
    try {
        Conn c = new Conn();
        try (Statement statement = c.s;
ResultSet resultSet = statement.executeQuery(query)) {
            StringBuilder result = new StringBuilder();
    while (resultSet.next()) {
        if (query.equals("SELECT * FROM bookpackage")) {
            // Assuming you have columns named "booking_id", "username", etc. in bookpackage
            result.append("Booking ID: ").append(resultSet.getString("booking_id")).append("\t");
            result.append("Username: ").append(resultSet.getString("username")).append("\t");
            result.append("Package: ").append(resultSet.getString("package")).append("\t");
            result.append("Persons: ").append(resultSet.getString("persons")).append("\t");
            result.append("Email: ").append(resultSet.getString("email")).append("\t");
            result.append("Price: ").append(resultSet.getString("price")).append("\n");
        } else if (query.equals("SELECT * FROM account")) {
            // Assuming you have columns named "username", "name", etc. in account
            result.append("Username: ").append(resultSet.getString("username")).append("\t");
            result.append("Name: ").append(resultSet.getString("name")).append("\t");
            result.append("Password: ").append(resultSet.getString("password")).append("\t");
            result.append("Question: ").append(resultSet.getString("question")).append("\t");
            result.append("Answer: ").append(resultSet.getString("answer")).append("\t");
            result.append("Email: ").append(resultSet.getString("email")).append("\n");
        } else if (query.equals("SELECT * FROM bookhotel")) {
            // Assuming you have columns named "hotelBooking_id", "username", etc. in bookHotel
            result.append("Booking ID: ").append(resultSet.getString("bookingid")).append("\t");
            result.append("Username: ").append(resultSet.getString("username")).append("\t");
            result.append("Hotel Type: ").append(resultSet.getString("selectedHotelType")).append("\t");
            result.append("Persons: ").append(resultSet.getString("numberOfPersons")).append("\t");
            result.append("Days: ").append(resultSet.getString("totalDays")).append("\t");
            result.append("Swimming Pool: ").append(resultSet.getString("swimmingpool")).append("\t");
            result.append("Food: ").append(resultSet.getString("food")).append("\t");
            result.append("Cost: ").append(resultSet.getString("price")).append("\n");
        }
            result.append("-------------------------------\n");
            }
            resultTextArea.setText(result.toString());
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    private void packagereport() {
    try {
        // Compile JRXML to Jasper file
        String jrxmlPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\PKGBookingReport.jrxml";
        String jasperPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\PKGBookingReport.jasper";
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        // Load the compiled JasperReport file (.jasper)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null, new Conn().c);

        // Display the report using JasperViewer
        JasperViewer.viewReport(jasperPrint, false);

    } catch (JRException ex) {
        ex.printStackTrace();
        // Handle the exception, show an error message, etc.
        resultTextArea.setText("Error generating report: " + ex.getMessage());
    }
}


    private void hotelreport() {
    try {
        // Compile JRXML to Jasper file
        String jrxmlPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\hotelBooking.jrxml";
        String jasperPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\hotelBooking.jasper";
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        // Load the compiled JasperReport file (.jasper)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null, new Conn().c);

        // Display the report using JasperViewer
        JasperViewer.viewReport(jasperPrint, false);

    } catch (JRException ex) {
        ex.printStackTrace();
        // Handle the exception, show an error message, etc.
        resultTextArea.setText("Error generating report: " + ex.getMessage());
    }
}
    private void popularpkg() {
    try {
        // Compile JRXML to Jasper file
        String jrxmlPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\popularpackager.jrxml";
        String jasperPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\popularpackager.jasper";
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        // Load the compiled JasperReport file (.jasper)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null, new Conn().c);

        // Display the report using JasperViewer
        JasperViewer.viewReport(jasperPrint, false);

    } catch (JRException ex) {
        ex.printStackTrace();
        // Handle the exception, show an error message, etc.
        resultTextArea.setText("Error generating report: " + ex.getMessage());
    }
}
    private void hotelstay() {
    try {
        // Compile JRXML to Jasper file
        String jrxmlPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\hotelstay.jrxml";
        String jasperPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\hotelstay.jasper";
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        // Load the compiled JasperReport file (.jasper)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null, new Conn().c);

        // Display the report using JasperViewer
        JasperViewer.viewReport(jasperPrint, false);

    } catch (JRException ex) {
        ex.printStackTrace();
        // Handle the exception, show an error message, etc.
        resultTextArea.setText("Error generating report: " + ex.getMessage());
    }
}
    private void popularhotel() {
    try {
        // Compile JRXML to Jasper file
        String jrxmlPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\popularhotel.jrxml";
        String jasperPath = "C:\\Users\\iamsu\\OneDrive\\Documents\\Travel-Planner-main\\Travel-Planner-main\\src\\Reports\\popularhotel.jasper";
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

        // Load the compiled JasperReport file (.jasper)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, null, new Conn().c);

        // Display the report using JasperViewer
        JasperViewer.viewReport(jasperPrint, false);

    } catch (JRException ex) {
        ex.printStackTrace();
        // Handle the exception, show an error message, etc.
        resultTextArea.setText("Error generating report: " + ex.getMessage());
    }
}
    public static void main(String[] args) {
        new AdminDashboard().setVisible(true);
    }
}
