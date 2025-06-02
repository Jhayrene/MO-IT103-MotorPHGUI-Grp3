/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollCalculations;

import models.EmployeeProfile;
import models.WeeklyTotals;
import governmentContribution.CalculatePagIbig;
import governmentContribution.CalculatePhilHealth;
import GovernmentContribution.CalculateSss;
import GovernmentContribution.CalculateWithholdingTax;

public class CaculateandDisplay {

    public static void processAndDisplay(EmployeeProfile employee, WeeklyTotals weeklyTotals) {
        double grossWeeklyPay = weeklyTotals.getTotalHoursWorked() * employee.getHourlyRate()
                + employee.getRiceSubsidy() + employee.getPhoneAllowance() + employee.getClothingAllowance();

        double pagibig = CalculatePagIbig.computeFromWeekly(grossWeeklyPay);
        double philhealth = CalculatePhilHealth.computeFromWeekly(grossWeeklyPay);
        double sss = CalculateSss.computeFromWeekly(grossWeeklyPay);
        double withholdingTax = CalculateWithholdingTax.compute(grossWeeklyPay);

        double totalDeductions = pagibig + philhealth + sss + withholdingTax;
        double netWeeklyPay = grossWeeklyPay - totalDeductions;

        // Display results
        System.out.println("Payroll Summary for " + employee.getFirstName() + " " + employee.getLastName() + " (" + employee.getEmployeeNumber() + ")");
        System.out.println("Pay Period: " + weeklyTotals.getPeriodStart() + " to " + weeklyTotals.getPeriodEnd());
        System.out.printf("Gross Weekly Pay: %.2f%n", grossWeeklyPay);
        System.out.printf("Pag-IBIG: %.2f%n", pagibig);
        System.out.printf("PhilHealth: %.2f%n", philhealth);
        System.out.printf("SSS: %.2f%n", sss);
        System.out.printf("Withholding Tax: %.2f%n", withholdingTax);
        System.out.printf("Total Deductions: %.2f%n", totalDeductions);
        System.out.printf("Net Weekly Pay: %.2f%n", netWeeklyPay);
        System.out.println("Total Hours Worked: " + weeklyTotals.getTotalHoursWorked());
        System.out.println("Total Overtime: " + weeklyTotals.getTotalOvertime());
        System.out.println("---------------------------------------------------");
    }

    public static void processandDisplay(EmployeeProfile selected, WeeklyTotals weeklyTotals) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

