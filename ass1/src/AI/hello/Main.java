package AI.hello;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int [][]state=new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };
        Board k =new Board();
        Board.with_bruning(true);
        Scanner sc=new Scanner(System.in);
        while (!Board.isFull()){
            System.out.println("Enter column you want : ");
            int col=sc.nextInt();
            Board.human_take_decision(col);
            print_array(Board.getState());
            System.out.println("\n0 1 2 3 4 5 6\n------------------------");
            long start=System.currentTimeMillis();
            Board.take_decision();
            long end=System.currentTimeMillis();
            print_array(Board.getState());
            System.out.println("Player 1: "+scoreCalculator.playerOneScore(Board.getState()));
            System.out.println("Player 2: "+scoreCalculator.playerTwoScore(Board.getState()));
            System.out.println(Board.explored_nodes);
            float time=(end-start)/1000F;
            System.out.println("Time consumed: "+time+" seconds");
        }
        System.out.println();


    }
    public static void print_array(int[][]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
