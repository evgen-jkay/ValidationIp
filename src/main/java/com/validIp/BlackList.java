package com.validIp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BlackList {
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
        return builder;
    }

    public void blackListCheck(String inputIp) {
        String filePath = "src/main/resources/blacklist.txt";

        int index = readFile(filePath).indexOf(inputIp);

        if (index > -1) {
            System.out.println("Access disallowed");
        } else {
            System.out.println("Access allowed");
        }
    }
}