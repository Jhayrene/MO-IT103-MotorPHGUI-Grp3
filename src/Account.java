/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brent
 */
public class Account {
     private String userName;
    private String password;

    public void getLogin() {
        System.out.println("Logging in user: " + userName);
    }

    public void generatePassword() {
        password = "Default123"; // logic for generating password
    }
    
}
