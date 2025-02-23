import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(textModifier());
    }

    public static String textModifier() {
        Scanner s = new Scanner(System.in);
        String enteredText = s.nextLine();
        String str = enteredText.trim();
        char[] charArray = str.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ' && charArray[i + 1] == ' ') {
            } else {
                char c = charArray[i];
                strBuilder.append(String.valueOf(c));
            }
        }

        String strBuilderArray = strBuilder.toString();
        List<String> myList = new ArrayList<String>(Arrays.asList(strBuilderArray.split("")));
        ArrayList<String> myNewList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals("-")) {
                myNewList.add(myNewList.size() - 1, myList.get(i + 1));
                myList.remove(i);
            } else {
                myNewList.add(myList.get(i));
            }
        }

        for (int i = 0; i < myList.size(); i++) {
            if (myNewList.get(i).equals("+")) {
                myNewList.set(i, "!");
            }
        }

        StringBuilder strInteger = new StringBuilder();
        StringBuilder strLetter = new StringBuilder();

        for (int i = 0; i < myList.size(); i++) {
            String c = myNewList.get(i);
            if (myNewList.get(i).equals("0") || myNewList.get(i).equals("1") || myNewList.get(i).equals("2")
                    || myNewList.get(i).equals("3") || myNewList.get(i).equals("4") ||
                    myNewList.get(i).equals("5") || myNewList.get(i).equals("6") || myNewList.get(i).equals("7") ||
                    myNewList.get(i).equals("8") || myNewList.get(i).equals("9")) {
                strInteger.append(c);
            } else {
                strLetter.append(c);
            }
        }

        int totalInteger = 0;
        for (char c : strInteger.toString().toCharArray()) {
            if (Character.isDigit(c)) {
                totalInteger += Character.getNumericValue(c);
            }
        }

        String strFinal;
        String strFinalLetter = strLetter.toString();
        if (totalInteger > 0) {
            strFinal = strLetter + " " + totalInteger;
        } else {
            strFinal = strFinalLetter;
        }

        char[] charstrFinalArray = strFinal.toCharArray();
        StringBuilder charstrFinalBuilder = new StringBuilder();
        for (int i = 0; i < charstrFinalArray.length; i++) {
            if (charstrFinalArray[i] == ' ' && charstrFinalArray[i + 1] == ' ') {
            } else {
                char c = charstrFinalArray[i];
                charstrFinalBuilder.append(c);
            }
        }

        return charstrFinalBuilder.toString();
    }
}