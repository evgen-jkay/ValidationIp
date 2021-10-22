import java.util.Scanner;

public class ValidationIp {
    public static String inputIp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter IP address or 'quit' to exit");
            inputIp = scanner.nextLine();

            if (!IPv4ValidationRegex.isValid(inputIp)) {
                BlackList.blackListCheck(inputIp);
                System.out.println("Invalid IP address");
            }
        } while (!inputIp.equalsIgnoreCase("quit"));
        scanner.close();
    }
}
