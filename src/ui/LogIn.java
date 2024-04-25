package ui;

import backend.MailingServiceImp;
import backend.User;
import backend.UserService;
import jdk.jshell.execution.Util;

import javax.mail.MessagingException;
import java.util.Random;

public class LogIn {
    private static UserService userService = new UserService();

    static void signUp() throws MessagingException {
        String username = Utils.enterStr("enter username");
        int age = Utils.enterInt("enter age: ");
        String email = Utils.enterStr("enter email");


        String verificationCode = generateRandomCode();
        MailingServiceImp.sendCode(email, "Your verification code: " + verificationCode);

        System.out.println("Verification code sent to your email.");

        String password = Utils.enterStr("enter Password: ");

        if (password.equals(verificationCode)) {
            userService.addUser(new User(username, age, email,password));
            System.out.println("SignUp successfully! 🥳🥳🥳");
        } else {
            System.out.println("SignUp failed! ❌❌❌");
        }
    }

    static void logIn() throws MessagingException {
        String email = Utils.enterStr("enter your email: ");
        String pass = Utils.enterStr("enter your password: ");

        if (authenticateUser(email, pass)) {
            System.out.println("Login successful! Welcome, " + email);
            myAccount();
        } else {
            System.out.println("Login failed! Invalid email or password.");
        }


    }

    private static void myAccount() throws MessagingException {
        String email = Utils.enterStr("Enter your email: ");
        String text = Utils.enterStr("Enter your message: ");

        MailingServiceImp.sendCode(email, text);
        System.out.println("Message sent successfully!");
    }

    private static String generateRandomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    private static boolean authenticateUser(String email, String password) {
        for (User user : userService.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}