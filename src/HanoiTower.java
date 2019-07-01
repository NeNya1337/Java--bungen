import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class HanoiTower {
    private static String controls = "[A>][B>>] [<C][D>] [<<E][<F]\nX -> exit the game";
    private static final int startTower = 0;
    private static final int towerSize = 4;
    private static int[][] towers = new int[3][8];
    private static String[] disks = {"","-", "--", "---", "----", "-----", "------", "-------"};
    private static final char towerChar = '^';
    private static int count = 0;



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char input;

        initializeGame();
        printTowers();
/*
        moveDisk(0,1);
        printTowers();
*/
        while(true) {
            System.out.print("Pick your move: ");
            input = in.next().toUpperCase().charAt(0);
            boolean exit = false;
            switch (input) {
                case 'A':
                    moveDisk(0, 1);
                    printTowers();
                    break;
                case 'B':
                    moveDisk(0, 2);
                    printTowers();
                    break;
                case 'C':
                    moveDisk(1, 0);
                    printTowers();
                    break;
                case 'D':
                    moveDisk(1, 2);
                    printTowers();
                    break;
                case 'E':
                    moveDisk(2, 0);
                    printTowers();
                    break;
                case 'F':
                    moveDisk(2, 1);
                    printTowers();
                    break;
                case 'X':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Input!");
            }

            if(checkVictory(1)){
                System.out.println("You transferred all disks to the second Tower. Type 'y' to continue, other inputs lead to exit the game.");
                if(in.next().toLowerCase().charAt(0) != 'y') exit = true;
            }
            if(checkVictory(2)){
                System.out.println("You transferred all disks to the third Tower. Type 'y' to continue, other inputs lead to exit the game.");
                if(in.next().toLowerCase().charAt(0) != 'y') exit = true;
            }

            if(exit) break;
        }
    }

    private static void initializeGame(){
        for(int i = 0; i<towerSize; i++){
            towers[0][i] = i;
            towers[1][i] = 0;
            towers[2][i] = 0;
        }
    }


    private static void printTowers(){
        System.out.println("Welcome to Tower of Hanoi!\n");
        for(int i=0; i<towerSize; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(towerChar);
                count = towers[j][i];
                System.out.printf("%-8s", disks[count]);
            }
            System.out.print("\n");
        }
        System.out.println(controls);
    }

    private static void moveDisk(int fromTower, int toTower){
        int newHigh = getHigh(toTower);
        int oldHigh = getHigh(fromTower);
        System.out.println(newHigh);
        System.out.println(oldHigh);
        if((newHigh == 0 || newHigh > oldHigh) && oldHigh != 0){
            towers[toTower][getHighIndex(toTower)-1] = oldHigh;
            //System.out.println(Arrays.deepToString(towers));
            towers[fromTower][getHighIndex(fromTower)] = 0;
        }
        if(newHigh == 0 || newHigh > oldHigh) {
            System.out.println("Moved~");
        } else System.out.println("Move not available!");
    }

    private static int getHigh(int thisTower){
        int high = 0;
        for(int i = 0; i<towerSize; i++){
            if(towers[thisTower][i] > 0){
                high = towers[thisTower][i];
                return high;
            }
        }
        return high;
    }

    private static int getHighIndex(int thisTower){
        for(int i = 0; i<towerSize; i++){
            if(towers[thisTower][i] > 0){
                return i;
            }
        }
        return towerSize;
    }

    private static boolean checkVictory(int towerIndex){
        boolean won = true;
        for(int i = towerSize-1; i>=0; i--){
            if(towers[towerIndex][i] != i){
                won = false;
            }
        }
        return won;
    }
}