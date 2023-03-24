import java.util.Scanner;

public class Console {

    private static final Scanner input = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max) {
        double value;

        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please Enter a Value Between " + min + " and " + max);
        }
        return value;
    }
}
