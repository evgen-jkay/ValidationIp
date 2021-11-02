package com.validIp;

/**
 * Клас обработки ВАЛИДНЫХ IP адресов
 *
 * @author      Eugen Landarenko
 * @version     1.0
 * @link        https://github.com/evgen-jkay/ValidationIp
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BlackListCheck {
    /**
     *
     * @param path      Path to file
     * @return          comparing strings from input
     */
    public StringBuilder readFile(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();

        if (!file.exists()) throw new RuntimeException("File not found");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    /**
     * @param inputIp   Input IP address
     */
    public void blackListCheck(String inputIp) {
        String filePath = ValidationIp.PATH_DIR + ValidationIp.BLACK_LIST;

        int index = readFile(filePath).indexOf(inputIp);

        if (index > -1) {
            System.out.println("Access disallowed");
        } else {
            System.out.println("Access allowed");
        }
    }


}
