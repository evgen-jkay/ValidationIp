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

    private final String BLACK_LIST = "blacklist.txt";
    private final String PATH_DIR = "./";

    public String getBLACK_LIST() {
        return BLACK_LIST;
    }

    public String getPATH_DIR() {
        return PATH_DIR;
    }

    public static void main(String[] args) {
        FileWatcherChenged fileWatcherChenged = new FileWatcherChenged();
        fileWatcherChenged.start();

        IPv4Validator iPv4Validator = new IPv4Validator();
        BlackListCheck blackListCheck = new BlackListCheck();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter IP address or 'quit' to exit");
            inputIp = scanner.nextLine();

            if (inputIp.equalsIgnoreCase("quit")) System.exit(0);

            if (!iPv4Validator.isValid(inputIp)) {
                System.out.println("Invalid IP address");
            } else {
                blackListCheck.blackListCheck(inputIp);
            }
        } while (!inputIp.equalsIgnoreCase("quit"));

        scanner.close();
    }

}
