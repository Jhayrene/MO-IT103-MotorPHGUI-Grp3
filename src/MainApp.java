/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brent
 */
public class MainApp {
    public static void main(String[] args) {
        Employee emp = new Employee();
        

        Payroll payroll = new Payroll();
        payroll.calculateGrossSalary(160, 2, 10);
        payroll.calculateDeduction();
        payroll.calculateNetPay();
        payroll.generatePayslip();
    }
    
}
