import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Ex {
    public static void main(String[] args) {
        int[] nums = {1, 2 ,4};
        int[][] matrix = {{1, 2, 3,6}, {4, 5, 6}};
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
