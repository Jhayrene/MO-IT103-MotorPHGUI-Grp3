/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorphgui;

/**
 *
 * @author HP-VICTUS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MotorPHGUI extends JFrame {

    private JTextField txtEmployeeID, txtName, txtPosition, txtTimeIn, txtTimeOut;
    private JTextArea outputArea;

    public MotorPHGUI() {
        setTitle("Payroll System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel for Inputs
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Employee ID:"));
        txtEmployeeID = new JTextField();
        inputPanel.add(txtEmployeeID);

        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Position:"));
        txtPosition = new JTextField();
        inputPanel.add(txtPosition);

        inputPanel.add(new JLabel("Time In:"));
        txtTimeIn = new JTextField("08:00");
        inputPanel.add(txtTimeIn);

        inputPanel.add(new JLabel("Time Out:"));
        txtTimeOut = new JTextField("17:00");
        inputPanel.add(txtTimeOut);

        JButton btnCalculate = new JButton("Calculate Payroll");
        inputPanel.add(btnCalculate);

        add(inputPanel, BorderLayout.NORTH);

        // Text area for output
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Action Listener
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculatePayroll();
            }
        });

        setVisible(true);
    }

    private void handleCalculatePayroll() {
        String id = txtEmployeeID.getText();
        String name = txtName.getText();
        String position = txtPosition.getText();
        String timeIn = txtTimeIn.getText();
        String timeOut = txtTimeOut.getText();

        // Example logic
        Employee emp = new Employee(Integer.parseInt(id), name, position);
        Attendance attendance = new Attendance(timeIn, timeOut);
        Payroll payroll = new Payroll();

        double hoursWorked = attendance.calculateWorkedHours();
        double grossSalary = payroll.calculateGrossSalary(hoursWorked, 0, 0);
        double netPay = payroll.calculateNetPay();

        outputArea.setText(
                "Payroll for " + emp.getName() + ":\n"
                + "Hours Worked: " + hoursWorked + "\n"
                + "Gross Salary: " + grossSalary + "\n"
                + "Net Pay: " + netPay
                                
    
                
                
                
        );
    }
    
    

    public static void main(String[] args) {
        new MotorPHGUI();
    }
}
