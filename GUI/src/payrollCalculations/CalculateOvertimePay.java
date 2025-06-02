/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollCalculations;

public class CalculateOvertimePay {

    private static final double OVERTIME_MULTIPLIER = 1.25;

    /**
     * Calculates the overtime pay for the given overtime hours and hourly rate.
     * @param overtimeHours The number of overtime hours worked.
     * @param hourlyRate The employee's hourly rate.
     * @return The total overtime pay.
     */
    public static double calculateOverTimePay(double overtimeHours, double hourlyRate) {
        return overtimeHours * hourlyRate * OVERTIME_MULTIPLIER;
    }
}
