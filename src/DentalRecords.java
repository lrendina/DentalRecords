import java.util.Scanner;
public class DentalRecords {
    private static final Scanner keyboard = new Scanner (System.in);

    public static double roots(int A, int B, int C) {

    }
    public static void main(String[] args) {

        // variable declaration
        int numFamMembers, i, j, k;
        String tooths;

        //input
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        System.out.print("Please enter the number of people in your family: ");
        numFamMembers = keyboard.nextInt();

        while (numFamMembers < 1 || numFamMembers > 6) {
            System.out.print("Invalid number of people, try again: ");
            numFamMembers = keyboard.nextInt();
        }

        String [] famNames = new String[numFamMembers];
        char [][][] teeth = new char [numFamMembers][2][8];
        for (i = 0; i < numFamMembers; i++){
            System.out.printf("Please enter the name of Family member %d \t: ", (i+1));
            famNames[i] = keyboard.next();
            System.out.println();

            //uppers
                System.out.printf("Please enter the uppers for %s \t: ", famNames[i]);
                tooths = keyboard.next();
                tooths = tooths.toUpperCase();
                for (int letter = 0; letter < tooths.length(); letter++) {
                    while (tooths.charAt(letter) != 'I' && tooths.charAt(letter) != 'B' && tooths.charAt(letter) != 'M') {
                        System.out.print("Invalid teeth types, try again\t\t: ");
                        tooths = keyboard.next();
                        tooths = tooths.toUpperCase();
                    }
                }

                while (tooths.length() > 8) {
                    System.out.print("Too many teeth, try again\t: ");
                    tooths = keyboard.next();
                }

                for (k = 0; k < tooths.length(); k++) {
                    teeth [i][0][k] = tooths.charAt(k);
                }

            // lowers
                System.out.printf("Please enter the lowers for %s \t: ", famNames[i]);
                tooths = keyboard.next();
                tooths = tooths.toUpperCase();
                for (int letter = 0; letter < tooths.length(); letter++) {
                    while (tooths.charAt(letter) != 'I' && tooths.charAt(letter) != 'B' && tooths.charAt(letter) != 'M') {
                        System.out.print("Invalid teeth types, try again\t\t: ");
                        tooths = keyboard.next();
                        tooths = tooths.toUpperCase();
                    }
                }

                while (tooths.length() > 8) {
                    System.out.print("Too many teeth, try again\t: ");
                    tooths = keyboard.next();
                }

                for (k = 0; k < tooths.length(); k++) {
                    teeth [i][1][k] = tooths.charAt(k);
                }

        }
        String menuOption;
        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it\t\t: ");
        menuOption = (keyboard.next()).toUpperCase();

        // checks input
        while (menuOption.charAt(0) != 'P' && menuOption.charAt(0) != 'E' && menuOption.charAt(0) != 'R' && menuOption.charAt(0) != 'X') {
            System.out.print("Invalid menu option, please try again\t\t: ");
            menuOption = (keyboard.next()).toUpperCase();
            String famMember;

            //print handling
            if (menuOption.charAt(0) == 'P') {
                for (i = 0; i < numFamMembers; i++){
                    System.out.println(famNames[i]);
                    System.out.print("\tUppers: ");
                    for (j = 0; j < teeth[i][0].length; j++) {
                        System.out.printf("%d:%c ", (j+1), teeth[i][0][j]);
                    }
                    System.out.println();
                    System.out.print("\tLowers: ");
                    for (j = 0; j < teeth[i][0].length; j++) {
                        System.out.printf("%d:%c ", (j+1), teeth[i][1][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }

            //Extract handling
            else if (menuOption.charAt(0) == 'E') {
                System.out.print("Which family member \t\t: ");
                famMember = keyboard.next();

            }
            //root handling
            else if (menuOption.charAt(0) == 'R') {
                System.out.printf("One root canal at\t%f", );
            }
            // exit handling
            else if (menuOption.charAt(0) == 'X') {
                System.out.println("Exiting the Floridian Tooth Records :-)");
                break;
            }


        }

        //processing

        //output
    }//end of main method

}// end of class
/*
1. Input
    1.1 Print welcome message
    1.2 Input number of family members
        1.2.1 reject input < 0
        1.2.2 reject input > 6
    1.3 Input names
    1.4 Input tooth types for uppers and lowers
        1.4.1 Reject input other than specified tooth types
        1.4.2 change tooth input to uppercase
2. Menu of Options
    2.1 Print
        2.1.1 Print family members and tooth types for each
    2.2 Extract
        2.2.1 ask user for tooth position
        2.2.2 Change tooth value to 'm'
    2.3 Roots
        2.3.1 Sum each tooth type
        2.3.2 find roots of quadratic equation using quadratic formula
    2.4 Exit
        2.4.1 Print exit message
 */