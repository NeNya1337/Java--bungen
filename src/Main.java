import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String myline = "Guess the number!";
        System.out.println(myline);

        Scanner in = new Scanner(System.in);/*
        String mysecond = in.nextLine();
        System.out.println("Your String: "+mysecond);
        */

        Random rand = new Random();
        int n = rand.nextInt(100);
        System.out.println(n);



        boolean solution = false;
        int trys = 0;

        while(solution == false){
            ++trys;
            int a =  in.nextInt();
            if (a < n) {
                System.out.println("Meine ist größer!");
            } else if (a > n){
                System.out.println("Meine ist kleiner!");
            } else {
                solution = true;
                break;
            }
        }
        System.out.println("Gelöst in "+trys+" Versuchen!");
    }
}
