package com.validIp;

import java.util.Scanner;

public class ValidationIp {

    public static String inputIp;

    public static final String BLACK_LIST = "blacklist.txt";
    public static final String PATH_DIR = "src/main/resources/";

    public static void main(String[] args) {
        FileWatcherChenged fileWatcherChenged = new FileWatcherChenged();
        fileWatcherChenged.start();

        BlackListCheck blackListCheck = new BlackListCheck();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter IP address or 'quit' to exit");
            inputIp = scanner.nextLine();

            if (!IPv4ValidatorRegex.isValid(inputIp)) {
                System.out.println("Invalid IP address");
            } else {
                blackListCheck.blackListCheck(inputIp);
            }
        } while (!inputIp.equalsIgnoreCase("quit"));
        scanner.close();
    }
}
