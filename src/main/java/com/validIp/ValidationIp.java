package com.validIp;

/**
 * Входной класс программы.
 *
 * @author      Eugen Landarenko
 * @version     1.0
 * @link        https://github.com/evgen-jkay/ValidationIp
 */

import java.io.File;
import java.util.Scanner;

public class ValidationIp {

    public static String inputIp;

    public static final String BLACK_LIST = "blacklist.txt";
    public static final String PATH_DIR = "./";

    public static void main(String[] args) {
        FileWatcherChenged fileWatcherChenged = new FileWatcherChenged();
        fileWatcherChenged.start();

        BlackListCheck blackListCheck = new BlackListCheck();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter IP address or 'quit' to exit");
            inputIp = scanner.nextLine();

            if (inputIp.equalsIgnoreCase("quit")) System.exit(0);

            if (!IPv4Validator.isValid(inputIp)) {
                System.out.println("Invalid IP address");
            } else {
                blackListCheck.blackListCheck(inputIp);
            }
        } while (!inputIp.equalsIgnoreCase("quit"));

        scanner.close();
    }
}
