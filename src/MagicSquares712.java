import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by dfreer on 7/17/2017.
 */
public class MagicSquares712 {

    public static void main(String[] args) {
        System.out.println("What is the size of one side of your magic square?");
        Scanner scanner = new Scanner(System.in);
        int side = scanner.nextInt();
        int magicSquare[][] = new int[side][side];
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                magicSquare[i][j] = scanner.nextInt();
            }
        }
        boolean isMagicSquare = true;
        int [] colSum = new int[side];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < side; i++){
            int nextRow = 0;
            for(int j = 0; j < side; j++){
                nextRow += magicSquare[i][j];
            }
            ans.add(nextRow);
        }

        int rowSum[] = new int[side];
        int nextRow = 0;
        for(int i = 0; i < side; i++){
            nextRow = 0;
            for(int j = 0; j < side; j++){
                nextRow += magicSquare[j][i];
            }
            ans.add(nextRow);
            nextRow = 0;
        }

        //check diagonals
        int diagonalSum [] = new int[2];
        int counter = 0;

        for(; counter < 2; counter++) {
            if(counter == 0)
            for (int i = 0; i < side; i++) {
                nextRow += magicSquare[i][i];
            }
            else{
                for(int i = side - 1; i >= 0; i--){
                    nextRow += magicSquare[i][i];
                }
            }

            ans.add(nextRow);
            nextRow = 0;
        }

        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
        for(int i = 0; i < ans.size()-1; i++){
            if(ans.get(i) != ans.get(i+1)){
                isMagicSquare = false;
            }
        }

        System.out.println("Is magic square = " + isMagicSquare);




    }
}
