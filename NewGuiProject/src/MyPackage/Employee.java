/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyPackage;

/**
 *
 * @author HP-VICTUS
 */
public class Employee {
     private String empID;
    private String name;
    private String position;
    private String department;
    private String email;
    private String contact;

    public Employee(String empID, String name, String position, String department, String email, String contact) {
        this.empID = empID;
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.contact = contact;
    }

    // Getters
    public String getEmpID() { return empID; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }


}
