public class Payroll {
    private double totalHoursWorked;
    private double totalLate;
    private double overtimeHours;
    private double grossSalary;
    private double totalDeduction;
    private double totalBonus;
    private double netSalary;
    private double taxCalculation;

    public double calculateGrossSalary(double workedHours, double late, double overTime) {
        // Sample logic
        grossSalary = (workedHours * 100) + (overTime * 120) - (late * 50);
        return grossSalary;
    }

    public double calculateDeduction() {
        Deduction deduction = new Deduction();
        totalDeduction = deduction.calculateTotalDeduction();
        return totalDeduction;
    }

    public double calculateNetPay() {
        Bonus bonus = new Bonus();
        totalBonus = bonus.calculateTotalBonus();
        netSalary = grossSalary + totalBonus - totalDeduction - taxCalculation;
        return netSalary;
    }

    public void generatePayslip() {
        System.out.println("Payslip Generated.");
    }
}
