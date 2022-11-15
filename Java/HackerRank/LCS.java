import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCS {
    public static void loiGiai(){
        String X = "abcdefghi123";
        String Y = "abc1def2ghi3";
        LCS(X, Y);
    }
    public static void LCS(String X, String Y) {
        int[][] F = new int[X.length() + 1][Y.length() + 1];
        Arrays.fill(F[0], 0);
        // F[i][j]=F[i-1][j-1] + 1
        // F[i][j]=Math.max();
        for (int i = 1; i < F.length; i++) {
            for (int j = 1; j < F[0].length; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) F[i][j] = F[i - 1][j - 1] + 1;
                else F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]);
            }
        }
        int j = X.length();
        int k = Y.length();
        List<Character> res = new ArrayList<>();
        while (F[j][k]!=0) {// ko biet la khi j=0 hay k=0
            if (X.charAt(j - 1) == Y.charAt(k - 1)) {res.add(X.charAt(j - 1)); j--; k--;}
            else {
                if (F[j - 1][k] > F[j][k - 1]) j--;
                else k--;
            }
        }

        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i));
        }
    }
}
