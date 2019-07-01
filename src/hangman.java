import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class hangman {
    private static String[] words = {"Apfelbaum", "Mehlschwitze", "Rotbarschfilet"};
    private static String[] galgen = {
            "",
            "___________%n |/%n |%n |%n |%n |%n---%n",
            "___________%n |/     |%n |%n |%n |%n |%n---%n",
            "___________%n |/     |%n |      @%n |%n |%n |%n---%n",
            "___________%n |/     |%n |      @%n |     /|\\%n |%n |%n---%n",
            "___________%n |/     |%n |      @%n |     /|\\%n |     / \\%n |%n---%n"};
    public static void main(String[] args) {
        char conti;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Hangman!");

            Random rand = new Random();
            int n = rand.nextInt(words.length);
            String wort = words[n];
            int len = wort.length();
            ArrayList<Character> pattern = new ArrayList<>();
            for (int i = 0; i < len; i++) pattern.add('_');
            //System.out.println(wort);
            ArrayList<Character> buchstaben = new ArrayList<Character>();
            int fehler = 0, versuche = 5;
            boolean solved = false;
            while (fehler < versuche && !solved) {
                System.out.println(pattern);
                System.out.printf("%nGib einen Buchstaben ein: ");
                char input = in.next().charAt(0);
                if (buchstaben.contains(input)) {
                    System.out.println("Bereits geprüft!");
                    continue;
                }
                if (wort.toLowerCase().indexOf(input) == -1) {
                    fehler++;
                    System.out.println("Fehler: " + fehler);
                } else {
                    for (int i = 0; i < len; i++) {
                        if (input == wort.toLowerCase().charAt(i)) {
                            pattern.set(i, wort.charAt(i));
                        }
                    }
                }
                System.out.printf(galgen[fehler]); //f not redundant whatever ide says
                buchstaben.add(input);
                solved = !pattern.contains('_');
            }
            if (!solved) {
                System.out.printf("Du wurdest gehängt! die Lösung wäre %s gewesen.", wort);
            } else {
                System.out.println("Herzlichen Glühstrumpf");
            }
            System.out.print("Du hast folgende Zeichen verwendet: ");
            Collections.sort(buchstaben);
            for(int i= 0; i < buchstaben.size(); i++){
                System.out.print(buchstaben.get(i)+" ");
            }
            System.out.println("\nSchreibe 'y' um erneut zu spielen! Sonstige Eingaben beenden das Programm.");
            conti = in.next().charAt(0);
        }while(conti == 'y');
    }
}
