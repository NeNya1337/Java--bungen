import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class mastermind {
    //
    private char Zeichen = '_';
    private boolean gefunden = false;
    public void codeItem(char zeichen){
        this.Zeichen = zeichen;
    }
    public void codeItem(char zeichen, boolean value) {
        this.Zeichen = zeichen;
        this.gefunden = value;
    }
    //
    private static char[] colors = {'R', 'G', 'O', 'B'};
    private static String[] counters = {"st", "nd", "rd", "th", "th", "th", "th", "th", "th", "th"};
    private static ArrayList<Character> codeList = new ArrayList<>();
    private static String[] input = new String[10];
    private static ArrayList<ArrayList<codeItem>> stringList = new ArrayList<ArrayList<codeItem>>();
    private static ArrayList<ArrayList<ArrayList<codeItem>>> itemList = new ArrayList<ArrayList<ArrayList<codeItem>>>();
    private static int[] correct = new int[10], exact = new int[10];
    private static int guessNumber = 0;


    public static void main(String[] args) {
/*
        //codeItem newitem = new codeItem(in.next().charAt(0));

        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean solved = false;

        for(int i = 0; i<4; i++){
            int n = rand.nextInt(4);
            //code[i] = colors[n];
            codeList.add(colors[n]);
        }

        System.out.println("Mastermind!");
        //String codestring = String.valueOf(code); //debug
        /*///debug
        /*System.out.println(codestring);
        System.out.println(code);
        */

/*
        while(!solved && guessNumber < 10){
            System.out.printf("%d%s try: Please enter your guess: ", guessNumber+1, counters[guessNumber]);
            String tempString = in.next().substring(0,4).toUpperCase();
            char tempchar = tempString.charAt(0);
            ArrayList<codeItem> templist = new ArrayList<codeItem>();

            codeItem t1 = new codeItem();
            t1.Zeichen = tempchar;
            input[guessNumber] = tempString;
            //stringList.add(templist);

            if (validateInput(stringList.get(guessNumber))) {
                //System.out.println(input[guessNumber]);
                testCode(guessNumber);
                if(exact[guessNumber] == 4 ) {
                    solved=true;
                }
                guessNumber++;
            } else {
                System.out.println("Your code conained incorrect characters!");
            }
        }

        System.out.println("Game ended!");
        if(solved){
            System.out.printf("Congratulations! You found my Code after %d rounds!\n", guessNumber);
        } else {
            System.out.println("Uahahahaha! I was smarter than you filthy insect!" + ArrayPrint(codeList));
        }

*/
    }
/*
    private static boolean validateInput(ArrayList code){
        boolean valid = true;
        //System.out.println("vali:"+ArrayPrint(code));
        for(int i=0; i < code.size(); i++){
            //System.out.println(code.get(i));
            char charVal = code.get(i).toString().charAt(0);
            if(charVal != 'R' && charVal != 'B' && charVal != 'G' && charVal != 'O' ) {
                valid = false;
            }
        }
        return valid;
    }

    private static void testCode(int guessCount){
        ArrayList<Character> workingList = new ArrayList<>();

        System.out.println("ip"+Arrays.toString(input));

        System.out.println("clist:"+ArrayPrint(codeList));
        //System.out.println("slist:"+ArrayListPrint(stringList));

        for(int i = 0; i < codeList.size(); i++){
            workingList.add(codeList.get(i));
            /*if(stringList.get(guessCount).get(i) == codeList.get(i)){
                exact[guessCount]++;
                workingList.set(i,'?');
                stringList.get(guessCount).set(i,'!');
            }*/
/*
        }
        System.out.println("wlist"+ArrayPrint(workingList));
        //System.out.println("slist2:"+ArrayListPrint(stringList));

        for(int i = 0; i < workingList.size(); i++){

                /*if(stringList.get(guessCount).contains(workingList.get(i))){
                    //System.out.println("corr found");
                    correct[guessCount]++;
                    workingList.set(i,'?');
                    stringList.get(guessCount).set(i,'!');
                }*//*

            //if(ArrayPrint(workingList).indexOf(stringList.get(guessCount).get(i))>0){            }
        }
        System.out.println("wlist2"+ArrayPrint(workingList));

        System.out.printf("You have %d exact and %d correct colours!\n",exact[guessNumber], correct[guessNumber]);
    }

    private static String ArrayPrint(ArrayList<Character> list){
        String output = "";
        int size = list.size();
        for(int i = 0; i < size; i++){
            output = output.concat(list.get(i).toString());
        }
        return output;
    }
    private static String ArrayListPrint(ArrayList<ArrayList<Character>> alist){
        String output = "";
        int size = alist.size();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < alist.get(i).size(); j++){
                output = output.concat(alist.get(i).get(j).toString());
            }
        }
        return output;
    }
*/
}
