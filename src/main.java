import java.util.Scanner;

/*
 * Lab 6 Jeff Choi 2/2/2017
*/

public class main {
    public static boolean isVowel(char theChar) {
        if (theChar == 'a' || theChar == 'e' || theChar == 'i' ||
            theChar == 'o' || theChar == 'u' || theChar == 'A' ||
            theChar == 'E' || theChar == 'I' || theChar == 'O' ||
            theChar == 'U') {
            return true;
        }
        return false;
    }
    
    public static boolean checkValid(String theString) {
        boolean allLetters = true;
        for (int i = 0; i < theString.length(); i++) {
            if (!Character.isLetter(theString.charAt(i))) {
                allLetters = false;
            } 
        }

        return allLetters;
    }
   
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        String[] splitStr;

        System.out.println("Welcome to the Pig Latin Translator!");
        System.out.println("");

        while (true) {
            System.out.print("Enter a line to be translated: ");
            userInput = sc.nextLine();
            splitStr = userInput.split("\\s+");

            // checks to make sure that the line is there
            while (splitStr[0].equals("")) {
                System.out.print("Enter a line to be translated: ");
                userInput = sc.nextLine();
                splitStr = userInput.split("\\s+");
            }


            for (int i = 0; i < splitStr.length; i++) {
                // check to make sure splitStr only has characters and no numbers
                if (!checkValid(splitStr[i])) {
                    continue;
                } 

                if (isVowel(splitStr[i].charAt(0))) {
                    splitStr[i] += "way";      
                }
                else {
                    int constHelper = 0;
                    String mover = "";
                    
                    while (constHelper < splitStr[i].length()) {
                        constHelper = 0;
                        if (isVowel(splitStr[i].charAt(constHelper))) {
                            break;
                        }
                        else {
                            mover += splitStr[i].charAt(constHelper);
                            splitStr[i] = splitStr[i].substring(1);

                        }
                        
                        constHelper+=1; 
                    }

                    splitStr[i] += mover + "ay";

                }
            }

            for(int i = 0; i < splitStr.length; i++) {
                System.out.print(splitStr[i] + " ");
            }

            System.out.println("");

            char theAnswer;

            while (true) {
                System.out.println("Translate another line? (Y/N)");
                theAnswer = sc.nextLine().charAt(0);

                if (theAnswer == 'y' || theAnswer == 'Y' || theAnswer == 'n' || theAnswer == 'N') break;
            }

            if (theAnswer == 'n' || theAnswer == 'N') break;
            else;




        }



    }
}
