package com.validIp;

import java.util.Scanner;

public class ValidationIp {

    public static String inputIp;

    public static void main(String[] args) {
        BlackList blackList = new BlackList();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter IP address or 'quit' to exit");
            inputIp = scanner.nextLine();

            if (!IPv4ValidatorRegex.isValid(inputIp)) {
                System.out.println("Invalid IP address");
            } else {
                blackList.blackListCheck(inputIp);
            }
        } while (!inputIp.equalsIgnoreCase("quit"));
        scanner.close();
    }
}
