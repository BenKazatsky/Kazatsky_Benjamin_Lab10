import java.util.Scanner;

import static java.lang.System.out;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        String trash = "";
        boolean done = false;
        do {
            out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                out.println("Invalid input: '" + trash + "' You must enter an integer");
            }
        } while (!done);
        return retInt;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        String trash = "";
        boolean done = false;
        do {
            out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                out.println("Invalid input: '" + trash + "' you must enter a double value");
            }
        } while (!done);
        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        String trash = "";
        boolean done = false;
        do {
            out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt >= low && retInt <= high) {
                    done = true;
                } else {
                    out.println("Invalid input, Value must be between " + low + " and " + high + ".");
                }
            } else {
                trash = pipe.nextLine();
                out.println("Invalid input: '" + trash + "' You must enter an integer");
            }
        } while (!done);
        return retInt;
    }
    public static double getRangedDouble (Scanner pipe, String prompt,double low, double high){
        double retDouble = 0;
        String trash = "";
        boolean done = false;
        do {
            out.printf("\n%s [%.2f-%.2f]: ", prompt, low, high);
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retDouble >= low && retDouble <= high) {
                    done = true;
                } else {
                    out.println("Invalid input, Value must be between " + low + " and " + high + ".");
                }
            } else {
                trash = pipe.nextLine();
                out.println("Invalid input: '" + trash + "' You must enter a double value");
            }
        } while (!done);
        return retDouble;
    }
    public static boolean getYNConfirm (Scanner pipe, String prompt)
    {
        String input = "";
        boolean done = false;
        boolean confirmed = false;
        do {
            out.print("\n" + prompt + " Y/N: ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                confirmed = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) {
                confirmed = false;
                done = true;
            } else {
                out.println("Invalid input: '" + input + "' You must enter a Y/N.");
            }
        } while (!done);
        return confirmed;
    }
    public static String getRegExString (Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean done = false;
        do {
            // MODIFIED: Removed the " RegEx: " + regEx + ":" part
            out.print("\n" + prompt + " ");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                done = true;
            } else {
                out.println("Invalid input, the value must match the pattern: " + regEx);
            }
        } while (!done);
        return retString;
    }
    public static void prettyHeader (String msg)
    {
        int totalWidth = 60;
        int msgLength = msg.length();
        int availableSpace = totalWidth - 6 - msgLength;
        int spacing = availableSpace / 2;
        int remainder = availableSpace % 2;
        for (int i = 0; i < totalWidth; i++) {
            out.print("*");
        }
        out.println();
        out.print("***");
        for (int i = 0; i < spacing; i++) {
            out.print(" ");
        }
        out.print(msg);
        if (remainder != 0) {
            out.print(" ");
        }
        for (int i = 0; i < spacing; i++) {
            out.print(" ");
        }
        out.println("***");
        for (int i = 0; i < totalWidth; i++) {
            out.print("*");
        }
        out.println();
    }
}