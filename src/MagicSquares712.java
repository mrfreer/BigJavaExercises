import java.util.Arrays;
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

        for(int i = 0; i < side; i++){
            int nextRow = 0;
            for(int j = 0; j < side; j++){
                nextRow += magicSquare[i][j];
            }
            colSum[i] = nextRow;
        }

        int rowSum[] = new int[side];
        int nextRow = 0;
        for(int i = 0; i < side; i++){
            nextRow = 0;
            for(int j = 0; j < side; j++){
                nextRow += magicSquare[j][i];
            }
            rowSum[i] = nextRow;
        }

        //check diagonals
        int diagonalSum [] = new int[2];
        int counter = 0;
        int nextRow = 0;
        for(; counter < 2; counter++) {
            for (int i = 0; i < side; i++) {
                nextRow += magicSquare[i][i];
            }
            diagonalSum[counter] = nextRow;
        }

        Arrays.sort(colSum);
        Arrays.sort(rowSum);
        Arrays.sort(diagonalSum);
        int toCheck = colSum[0];
        for(int i : colSum){

        }

    }
}
