import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mastermind2 {

    private static char[] colors = {'R', 'G', 'O', 'B'};
    private static String[] counters = {"st", "nd", "rd", "th", "th", "th", "th", "th", "th", "th"};
    private static ArrayList<Character> codeList = new ArrayList<>();
    private static String code = "";
    private static String[] input = new String[10];
    private static int[] correct = new int[10], exact = new int[10];
    private static int guessNumber = 0;

    public static void main(String[] args){
        System.out.println("Welcome to Mastermind!\n");
        System.out.println("You can tip (O)range, (G)reen, (B)lue and (R)ed!");
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean solved = false;

        for(int i = 0; i<4; i++){
            int n = rand.nextInt(4);
            codeList.add(colors[n]);
            code += codeList.get(i);
        }

        //System.out.println(code);
        //loop
        while(!solved && guessNumber < 10){
            ////input string
            try{
                System.out.printf("%d%s try: Please enter your guess: ", guessNumber+1, counters[guessNumber]);
                input[guessNumber] = in.next().substring(0,4).toUpperCase();
                //// validate
                if(!validateInput(input[guessNumber])){
                    throw new StringIndexOutOfBoundsException("It contained invalid characters!");
                }

            } catch(StringIndexOutOfBoundsException e){
                String error = e.toString().substring(43);
                if(error.contains("begin"))error = "It was too short!";
                System.out.println("Invalid Input. "+error);
            }

            String currentString = input[guessNumber];
            String codeString = code;
            ////count exact
            for(int i=0; i < 4; i++){

                if(currentString.charAt(i) == codeString.charAt(i)) {
                    exact[guessNumber]++;
                    currentString = currentString.substring(0, i)+"?"+currentString.substring(i+1);
                    codeString = codeString.substring(0, i)+"!"+codeString.substring(i+1);
                }
            }
            ////count correct
            for(int i = 0; i < 4; i++){
                int foundIndex = codeString.indexOf(currentString.charAt(i));
                if(foundIndex > 0){
                    correct[guessNumber]++;
                    currentString = currentString.substring(0, i)+"?"+currentString.substring(i+1);
                    codeString = codeString.substring(0, foundIndex)+"!"+codeString.substring(foundIndex+1);
                }
            }
            ////test if finished
            if(exact[guessNumber] == 4) solved = true;
            ////print
            System.out.printf("You had %d exact and %d correct colours!\n", exact[guessNumber], correct[guessNumber]);
            guessNumber++;
        }

        System.out.println("Game ended!");
        //present result
        if(solved){
            System.out.printf("Congratulations! You found my Code after %d rounds!\n", guessNumber);
        } else {
            System.out.printf("Uahahahaha! I was smarter than you filthy insect! The correct code was %s!" + code);
        }









    }
    private static boolean validateInput(String code){
        boolean valid = true;
        for(int i=0; i < code.length(); i++){
            char charVal = code.charAt(i);
            if(charVal != 'R' && charVal != 'B' && charVal != 'G' && charVal != 'O' ) {
                valid = false;
            }
        }
        return valid;
    }
}
