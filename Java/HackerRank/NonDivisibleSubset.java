import java.util.List;

public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] temp = new int[k + 1];
        for (int i = 0; i < s.size(); i++) {
            temp[s.get(i) % k]++;
        }
        int count = 0;
        int cond = (k % 2 == 0) ? k / 2 : (k / 2) + 1;
        for (int j = 0; j < cond; j++) {
            if (temp[0] != 0 && j == 0) count++;
            else {
                count += temp[j] > temp[k - j] ? temp[j] : temp[k - j];
            }
        }
        if (k % 2 == 0) count++;
        return count;
    }
}
