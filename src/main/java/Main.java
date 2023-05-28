import java.util.Arrays;

public class Main {
    public static String calc(String input) throws Exception {

        //a regular expression that matches the conditions of the task(hopefully)
        final String regex = "^(?:[1-9]|10) ?[\\+\\-\\*\\/] ?(?:[1-9]|10)$";

        if (!input.matches(regex)) {
                throw new Exception("Invalid input");
        }

        int[] operand = Arrays.stream(input.split(" ?[\\+\\-\\*\\/] ?")).mapToInt(Integer::parseInt).toArray();

        String operator = input.replaceAll("[^+\\-*\\/]", "");

        return switch (operator) {
            case "+" -> String.valueOf(operand[0] + operand[1]);
            case "-" -> String.valueOf(operand[0] - operand[1]);
            case "*" -> String.valueOf(operand[0] * operand[1]);
            case "/" -> String.valueOf(operand[0] / operand[1]);
            default -> "";
        };
    }
}
