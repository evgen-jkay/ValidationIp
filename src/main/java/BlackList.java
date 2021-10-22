import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class BlackList {
    public static StringBuilder readFile(String path) {
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

    public static void blackListCheck(String inputIp) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String filePath = "src/main/resources/blacklist.txt";

        int index = readFile(filePath).indexOf(userInput);

        if (index > -1) {
            System.out.println("Access disallowed");
        } else {
            System.out.println("Access allowed");
        }
    }
}