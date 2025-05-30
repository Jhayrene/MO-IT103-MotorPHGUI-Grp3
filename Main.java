/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.group3comprog2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Group3Comprog2 {


public class Main {
    static final String EMPLOYEE_FILE = "employee_details.csv";
    static final String ATTENDANCE_FILE = "attendance_records.csv";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n--- Employee Attendance System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Record Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> recordAttendance();
                case "3" -> viewAttendance();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addEmployee() throws IOException {
        System.out.print("Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("First Name: ");
        String fn = scanner.nextLine();
        System.out.print("Last Name: ");
        String ln = scanner.nextLine();
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        System.out.print("Position: ");
        String pos = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Date Hired (YYYY-MM-DD): ");
        String dateHired = scanner.nextLine();

        Employee emp = new Employee(id, fn, ln, dept, pos, email, contact, dateHired);
        writeToCSV(EMPLOYEE_FILE, emp.toCSV(), true);
        System.out.println("Employee added successfully!");
    }

    static void recordAttendance() throws IOException {
        System.out.print("Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Attendance Code (P, A, L, SL, VL, OB, UT): ");
        String code = scanner.nextLine();

        Attendance att = new Attendance(id, code);
        writeToCSV(ATTENDANCE_FILE, att.toCSV(), true);
        System.out.println("Attendance recorded!");
    }

    static void viewAttendance() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ATTENDANCE_FILE));
        String line;
        System.out.println("\n--- Attendance Records ---");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    static void writeToCSV(String fileName, String data, boolean append) throws IOException {
        FileWriter fw = new FileWriter(fileName, append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        bw.close();
    }
}

}
