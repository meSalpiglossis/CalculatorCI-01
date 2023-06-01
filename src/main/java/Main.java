import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calc("");
    }

    public static String calc(String input) {
        //a regular expression that matches the condition of the task (hopefully)
        final String regex = "^(?:[1-9]|10) ?[+\\-*/] ?(?:[1-9]|10)$";

        System.out.println("Input:");

        if (input.equals("")) {
            input = consoleInput();
        } else {
            System.out.println(input);
        }

        if (!input.matches(regex)) {
            try {
                throw new Exception("Invalid input");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        int[] operand = Arrays.stream(input.split(" ?[+\\-*/] ?")).mapToInt(Integer::parseInt).toArray();

        String operator = input.replaceAll("[^+\\-*/]", "");

        String result = switch (operator) {
            case "+" -> String.valueOf(operand[0] + operand[1]);
            case "-" -> String.valueOf(operand[0] - operand[1]);
            case "*" -> String.valueOf(operand[0] * operand[1]);
            case "/" -> String.valueOf(operand[0] / operand[1]);
            default -> "";
        };

        System.out.println("\nOutput:\n" + result);

        return result;
    }

    private static String consoleInput() {
        return new Scanner(System.in).nextLine();
    }
}
