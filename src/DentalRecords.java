import java.util.Scanner;
public class DentalRecords {
    private static final Scanner keyboard = new Scanner (System.in);
    private static final int MAX_TEETH = 8;

    public static void main(String[] args) {

        // variable declaration
        int numFamMembers, i, j, k;
        String tooths;
        char menuOption;

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
        char [][][] teeth = new char [numFamMembers][2][];
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
                teeth [i][0] = tooths.toCharArray();

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
                teeth [i][1] = tooths.toCharArray();
        }

        menuOption = menuOpt();
        while (menuOption != 'X') {
            switch (menuOption) {
                case 'P':
                    printRecords(teeth, famNames, numFamMembers);
                    break;
                case 'E':
                    extract(famNames, teeth);
                    break;
                case 'R':
                    roots(numFamMembers, teeth);
                    break;
                case 'X':
                    break;
            }
        }
        System.out.println("Exiting the Floridian Tooth Records :-)");

    }//End of main method


    public static void printRecords(char[][][] teeth, String[] famNames, int numFamMembers) {


        for (int famIndex = 0; famIndex < numFamMembers; famIndex++){
            System.out.println(famNames[famIndex]);
            System.out.print("\tUppers: ");
            for (int toothIndex = 0; toothIndex < teeth[famIndex][0].length; toothIndex++) {
                System.out.printf("%d:%c ", (toothIndex+1), teeth[famIndex][0][toothIndex]);
            }
            System.out.println();
            System.out.print("\tLowers: ");
            for (int toothIndex = 0; toothIndex < teeth[famIndex][0].length; toothIndex++) {
                System.out.printf("%d:%c ", (toothIndex+1), teeth[famIndex][1][toothIndex]);
            }
            System.out.println();
        }


    }
    private static char menuOpt() {
        char choice;
        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it :");
        choice = keyboard.next().charAt(0);
        choice = Character.toUpperCase(choice);
        while (!(choice == 'P' || choice == 'E' || choice == 'R' || choice == 'X')) {
            System.out.print("Invalid menu option, try again : ");
            choice = keyboard.next().charAt(0);
            choice = Character.toUpperCase(choice);
        }
        return choice;
    }

    private static void Print(String[] famNames, char[][][] teeth) {
        for (String ignored : famNames)
            System.out.println();
        for (int info = 0; info < famNames.length; info++) {
            System.out.println(famNames[info]);
            System.out.print(" Uppers: ");
            for (int memb = 0; memb < teeth[info][0].length; memb++)
                System.out.print((memb + 1) + ":" + teeth[info][0][memb] + " ");
            System.out.print(" Lowers: ");
            for (int memb = 0; memb < teeth[info][1].length; memb ++)
                System.out.print((memb + 1) + ":" + teeth[info][1][memb] + " ");
            System.out.println();
        }

    }

    public static int famMember(String[] names, String name){

        for (int info = 0; info < names.length; info++) {
            if (!names[info].equals(name)) continue;
            return info;
        }
        return -1;
    }

    private static void extract(String[] famNames, char[][][] teeth) {
        String name;
        char row;
        System.out.print("Which family member : ");
        name = keyboard.next();
        int fam = famMember(famNames, name);
        while (fam < 0) {
            System.out.print("Invalid family member, try again : ");
            name = keyboard.next();
            fam = famMember(famNames, name);
        }
        System.out.print("Which tooth layer (U)pper or (L)ower : ");
        row = keyboard.next().charAt(0);
        row = Character.toUpperCase(row);
        while (!(row == 'U' || row == 'L')) {
            System.out.print("Invalid layer, try again : ");
            row = keyboard.next().charAt(0);
            row = Character.toUpperCase(row);
        }
        int UppersOrLowers;
        UppersOrLowers = 1;
        System.out.print("Which tooth number : ");
        int toothNumber = keyboard.nextInt();
        while (true) {
            if (toothNumber < 0 || toothNumber > MAX_TEETH) {
                System.out.print("Invalid tooth number, try again : ");
                toothNumber = keyboard.nextInt();
                continue;
            }
            if (teeth[fam][UppersOrLowers][toothNumber - 1] == 'M') {
                System.out.print("Missing tooth, try again : ");
                toothNumber = keyboard.nextInt();
                continue;
            }
            teeth[fam][UppersOrLowers][toothNumber - 1] = 'M';
            break;
        }


    }
    private static void roots(int numFamMembers, char [][][] teeth) {
        double a,b,c,root1, root2, discriminant;
        double iSum = 0.0;
        double bSum = 0.0;
        double mSum = 0.0;

        for (int famIndex = 0; famIndex < numFamMembers; famIndex++) {
            for (int rowIndex =0; rowIndex < MAX_TEETH;rowIndex ++){
                for (int toothIndex = 0; toothIndex < teeth[rowIndex][famIndex].length; toothIndex++) {
                    switch (teeth[famIndex][rowIndex][toothIndex]){
                        case 'I':
                            iSum += 1;
                            break;
                        case 'B':
                            bSum += 1;
                            break;
                        case 'M':
                            mSum += 1;
                            break;
                        default:
                            System.out.print("Error in reading teeth information                    :");
                    }
                }
            }
        }
        // Ix2+Bx-M
        a = iSum;
        b = bSum;
        c = -1*mSum;
        discriminant = b * b - 4.0 * a * c;
        if (discriminant == 0.0) {
            root1 = -b / (2.0 * a);
            System.out.printf("One root canal at %6.2f\n", root1);
            System.out.println();
        }else if (discriminant> 0.0) {
            root1 = (-b + Math.pow(discriminant, 0.5)) / (2.0 * a);
            root2 = (-b - Math.pow(discriminant, 0.5)) / (2.0 * a);
            System.out.printf("One root canal at %6.2f\nAnother root canal at %6.2f", root1, root2);
            System.out.println();
        }else {
            System.out.println("No real roots");
        }
    }
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