package ui;

import java.util.Scanner;

public class Utils {
    public static String enterStr(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextLine();
    }  public static int enterInt(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextInt();
    }
}
