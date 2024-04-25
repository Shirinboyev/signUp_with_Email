package ui;

import javax.mail.*;
import static ui.LogIn.*;
import java.util.Scanner;

public class FrontEnd {

    public static void main(String[] args) throws MessagingException {
        System.out.println("Welcome");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. logIn
                    2. SignUp
                    0. Exit
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> logIn();
                case 2 -> signUp();
                case 0 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }


}
