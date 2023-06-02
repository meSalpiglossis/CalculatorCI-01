import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input:");
        String input = new Scanner(System.in).nextLine();

        System.out.println("\nOutput:\n" + calc(input));
    }

    public static String calc(String input) {
        final String regex = "^(?:[1-9]|10) ?[+\\-*/] ?(?:[1-9]|10)$";

        if (!input.matches(regex)) {
            try {
                throw new Exception("Invalid input");
            } catch (Exception e) {
                System.out.println("\nOutput:\nthrows Exception");
                return "throws Exception";
            }
        }

        int[] operand = Arrays.stream(input.split(" ?[+\\-*/] ?")).mapToInt(Integer::parseInt).toArray();

        String operator = input.replaceAll("[^+\\-*/]", "");

        return switch (operator) {
            case "+" -> String.valueOf(operand[0] + operand[1]);
            case "-" -> String.valueOf(operand[0] - operand[1]);
            case "*" -> String.valueOf(operand[0] * operand[1]);
            case "/" -> String.valueOf(operand[0] / operand[1]);
            default -> "";
        };
    }
}
