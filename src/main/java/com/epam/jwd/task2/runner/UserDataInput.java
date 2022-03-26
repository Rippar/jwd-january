package com.epam.jwd.task2.runner;

import java.util.Scanner;

public class UserDataInput {
    public String enterFromConsole(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
}
