package info.dmerej;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Worksshop1 {
    public static ArrayList<Double> stack;
    public static String inputString;
    public static List<String> tokens;
    public static void initiateStack() {
        stack = new ArrayList<Double>();
    }
    public static void enterInputString(String str) {
        inputString = str;
        //System.out.println(inputString);
    }

    public static void splitInput() {
        tokens = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        System.out.println(tokens.get(0));
    }

    public static void readNextToken() {
        String token = null;
        try {
            token = tokens.remove(0);
            Double parsedDouble = Double.parseDouble(token);
            stack.add(parsedDouble);
        } catch (NumberFormatException e) {
            switch (token) {
                case "+":
                    stack.add(stack.remove(0)+stack.remove(0));
                    break;
                case "-":
                    stack.add(stack.remove(0)-stack.remove(0));
                    break;
                case "*":
                    stack.add(stack.remove(0)*stack.remove(0));
                    break;
                case "sqrt":
                    stack.add(Math.sqrt(stack.remove(stack.size()-1)));
                    break;
                case "max":
                    double max = stack.get(0);
                    for(double d : stack) {
                        if (d>max) {
                            max = d;
                        }
                    }
                    stack.set(0,max);
            }
        }
    }

    public static void loopTokens() {
        while (!tokens.isEmpty()) {
            readNextToken();
        }
    }

    public static String askUserInput(){
        String str = "";
        while (str.isEmpty()) {
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter an expression (only natural numbers, all tokens separated by exactly one space): ");
            str= sc.nextLine();
            if (str != null && !str.isEmpty()) {
                System.out.print("You have entered: "+str);
                enterInputString(str);
                break;
            }
            else{
                System.out.println("Error: You cannot enter an empty expression.");
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        //enterInputString("2 2 -");
        //splitInput();
        //System.out.println(askUserInput());
    }
}
