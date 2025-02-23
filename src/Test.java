
import java.util.Scanner;
import static java.lang.Integer.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {

        String[] partsForRome = input.split(" ");
        String[] parts = input.split(" ");
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        int countOperator = 0;
        int arabDigit = 0;
        int romeDigit = 0;
        String operator = new String();

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("+") || parts[i].equals("-") || parts[i].equals("*") || parts[i].equals("/")) {
                countOperator = countOperator + 1;
                operator = parts[i];

            }
            for (int j = 0; j < arab.length; j++) {
                if (parts[i].equals(arab[j])) {
                    arabDigit = arabDigit + 1;
                }
            }
            for (int c = 0; c < rome.length; c++) {
                if (parts[i].equals(rome[c])) {
                    romeDigit = romeDigit + 1;
                }
            }
        }

        if (countOperator >= 2 || countOperator == 0) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (romeDigit == 1 && arabDigit == 1) {
            throw new Exception("Используются одновременно разные системы счисления");
        }

        if (arabDigit == 1) {
            throw new Exception("Строка не является математической операцией");
        }

        if (romeDigit == 1) {
            throw new Exception("Строка не является математической операцией");
        }

        for (int i = 0; i < parts.length; i++) {
            for (int c = 0; c < rome.length; c++) {
                if (parts[i].equals(rome[c])) {
                    for (int j = 0; j < arab.length; j++) {
                        if (c == j) {
                            parts[i] = arab[j];
                            break;
                        }
                    }
                }
            }
        }

        int num1 = parseInt(parts[0]);
        int num2 = parseInt(parts[2]);
        int resultArab = 0;
        int resultRome = 0;


        if (operator.equals("+")) {
            resultArab = num1 + num2;
        }
        if (operator.equals("-")) {
            resultArab = num1 - num2;
        }
        if (operator.equals("*")) {
            resultArab = num1 * num2;
        }
        if (operator.equals("/")) {
            resultArab = num1 / num2;
        }
        resultRome = resultArab;

        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i <  partsForRome.length; i++) {
            for (int v = 0; v < rome.length; v++) {
                if (partsForRome[i].equals(rome[v])) {
                    if (resultArab <= 0) {
                        throw new Exception("В римской системе нет отрицательных чисел");
                    }
                    for (int g = 0; g < arabicValues.length; g++) {
                        while (resultRome >= arabicValues[g]) {
                            roman.append(romanSymbols[g]);
                            resultRome -= arabicValues[g];
                        }
                    }
                }
            }
        }

        if (roman.isEmpty()) {
            return String.valueOf(resultArab);
        }
        return roman.toString();
    }
}