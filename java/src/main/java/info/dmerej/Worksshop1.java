package info.dmerej;

import java.util.ArrayList;
import java.util.Arrays;


public class Worksshop1 {
    public static ArrayList<Integer> stack;
    public static String inputString;
    public static ArrayList<String> tokens;
    public static void initiateStack() {
        stack = new ArrayList<Integer>();
    }
    public static void enterInputString(String str) {
        inputString = str;
        //System.out.println(inputString);
    }

    public static void splitInput() {
        tokens = (ArrayList<String>) Arrays.asList(inputString.split(" "));
        System.out.println(tokens);
    }

    public static void readNextToken() {
        String token = null;
        try {
            token = tokens.remove(0);
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            int e1 = stack.remove(0);
            int e2 = stack.remove(0);
            switch (token) {
                case "+":
                    stack.add(e1+e2);
                    break;
                case "-":
                    stack.add((e1-e2));
                    break;
                case "*":
                    stack.add((e1*e2));
                    break;
            }
        }
    }

    public static void loopTokens() {
        while (!tokens.isEmpty()) {
            readNextToken();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        //enterInputString("2 2 -");
        //splitInput();
    }
}
