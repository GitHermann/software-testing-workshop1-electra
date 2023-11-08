package info.dmerej;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Worksshop1 {
    public static ArrayList<Integer> stack;
    public static String inputString;
    public static List<String> tokens;
    public static void initiateStack() {
        stack = new ArrayList<Integer>();
    }
    public static void enterInputString(String str) {
        inputString = str;
        //System.out.println(inputString);
    }

    public static void splitInput() {

        tokens = Arrays.asList(inputString.split(" "));

    }

    public static void readNextToken() {
        String token = null;
        try {
            token = tokens.remove(0);
            System.out.println(token);
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
            //System.out.println(tokens);
            readNextToken();
        }
    }

    public static void askUserInput(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter an expression (only natural numbers, all tokens separated by exactly one space): ");
        //String str= sc.nextLine();
        System.out.print("You have entered: "+str);
        if (str != null && !str.isEmpty()) {
            enterInputString(str);
        }
        else{
            System.out.println("Cannot enter an empty expression");

        }
        String str = "";
        while (str == null && ) {

        }

    }

    public static void main(String[] args) {
        //System.out.println("Hello World");
        //enterInputString("2 2 -");
        //splitInput();
        askUserInput();
    }
}
