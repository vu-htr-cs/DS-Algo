import java.util.List;

public class MagicSquare {
    private static int[][][] possiblePermutations = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1

            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2

            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3

            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4

            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5

            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6

            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7

            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
    };


    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int min = 100;
        for (int i = 0; i < 8; i++) {
            int temp = calculateArg(s, possiblePermutations[i]);
            if (temp < min) min = temp;
        }
        return min;
    }

    public static int calculateArg(List<List<Integer>> s, int[][] kernel) {
        int loss = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                loss += Math.abs(s.get(i).get(j) - kernel[i][j]);
            }
        }
        return loss;
    }

}


