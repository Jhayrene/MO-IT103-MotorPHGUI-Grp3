/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dataLoader.LoadEmployeeData;
import dataLoader.LoadTimeSheet;
import models.EmployeeProfile;
import models.TimeLog;
import models.WeeklyTotals;
import payrollCalculations.CalculateWeeklyTotals;
import UI.ConsoleUI;

import java.util.List;
import java.util.Scanner;
import payrollCalculations.CaculateandDisplay;

public class GUI {
    public static void main(String[] args) {
        MotorPHGUI.PayrollGUI.main(args);
        String employeeFile = "src/main/resources/Employee Details.csv";
        String attendanceFile = "src/main/resources/Attendance Record.csv";

        List<EmployeeProfile> employees = LoadEmployeeData.loadFromFile(employeeFile);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            
            while (running) {
                ConsoleUI.displayMenu();
                String option = scanner.nextLine();
                
                switch (option) {
                    case "1" -> {
                        System.out.print("Enter Employee Number: ");
                        String empNum = scanner.nextLine().trim();
                        EmployeeProfile selected = employees.stream()
                                .filter(e -> e.getEmployeeNumber().equals(empNum))
                                .findFirst().orElse(null);
                        
                        if (selected != null) {
                            ConsoleUI.displayEmployeeDetails(selected);
                            
                            List<TimeLog> logs = LoadTimeSheet.loadForEmployee(attendanceFile, empNum);
                            List<WeeklyTotals> weeklyTotalsList = CalculateWeeklyTotals.calculateWeeklyTotals(selected, logs);
                            
                            for (WeeklyTotals weeklyTotals : weeklyTotalsList) {
                                ConsoleUI.displayWeeklySalary(weeklyTotals);
                                CaculateandDisplay.processandDisplay(selected, weeklyTotals);
                            }
                        } else {
                            ConsoleUI.displayMessage("Employee not found.");
                        }
                    }
                    case "2" -> {
                        System.out.print("Enter Employee Number: ");
                        String empNum2 = scanner.nextLine().trim();
                        EmployeeProfile selected2 = employees.stream()
                                .filter(e -> e.getEmployeeNumber().equals(empNum2))
                                .findFirst().orElse(null);
                        
                        if (selected2 != null) {
                            List<TimeLog> logs2 = LoadTimeSheet.loadForEmployee(attendanceFile, empNum2);
                            List<WeeklyTotals> weeklyTotalsList2 = CalculateWeeklyTotals.calculateWeeklyTotals(selected2, logs2);
                            
                            if (weeklyTotalsList2.isEmpty()) {
                                ConsoleUI.displayMessage("No weekly salary information found for this employee.");
                            } else {
                                for (WeeklyTotals weeklyTotals : weeklyTotalsList2) {
                                    ConsoleUI.displayWeeklySalary(weeklyTotals);
                                }
                            }
                        } else {
                            ConsoleUI.displayMessage("Employee not found.");
                        }
                    }
                    case "3" -> {
                        running = false;
                        ConsoleUI.displayMessage("Exiting...");
                    }
                    default -> ConsoleUI.displayMessage("Invalid option. Please try again.");
                }
            }
        }
    }
}

