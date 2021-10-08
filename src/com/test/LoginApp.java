package com.test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "admin");
        map.put(2, "user");

        int key = 2;


        System.out.println("Enter 1 for sign in  \n" +
                "Enter 2 to register ");

        int i = scanner.nextInt();

        while (i <= 3) {
            switch (i) {
                case 1:
                    System.out.println("Please enter your user name!");
                    scanner.nextLine();
                    String s = scanner.nextLine().toLowerCase();
                    if (map.get(1).equals(s) || map.get(2).equals(s)) {
                        System.out.println("Welcome!!");
                        return;
                    }
                    System.out.println("User not found!");
                    return;
                case 2:
                    System.out.println(" Registration PAGE!\n Enter Your username! ");
                    scanner.nextLine();
                    String newUser = scanner.nextLine();
                    map.put(++key, newUser);
                    System.out.println("Your successfully registered!!\n " +
                            "--Enter username !!-- ");
                    i++;
                    break;
                case 3:
                    String s1 = scanner.nextLine();
                    String result = map.entrySet().stream()
                            .filter(entry -> s1.equals(entry.getValue()))
                            .map(entry -> entry.getValue())
                            .collect(Collectors.joining());
//                    System.out.println(result);
                    result.toLowerCase(Locale.ROOT);
                    if (s1.equals(result)) {
                        System.out.println("Welcome! " + result);
                        return;
                    }
                    System.out.println("user not found");
                    --i;
                    break;
            }

        }


    }

}
