package setzero02;

public class SetZeroTest {
    public static void main(String[] args) {
        int[][] matrix = {
                            {0, 1, 2, 0},
                            {3, 4, 5, 2},
                            {1, 3, 1, 5}};

        Solution.setZero(matrix);
    }
}
