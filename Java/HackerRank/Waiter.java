import java.util.ArrayList;
import java.util.List;

public class Waiter {
    public void seive(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= N; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public List<Integer> factorize(int N) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= N; ++i) {
            while (N % i == 0) {
                res.add(i);
                N /= i;
            }
        }
        if (N != 1) {
            res.add(N);
        }
        return res;
    }

    public void eratos(int N) {
        int[] minPrime = new int[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (minPrime[i] == 0) {
                for (int j = i * i; j < N; j = j + i) {
                    if (minPrime[j] == 0) {
                        minPrime[j] = i;
                    }
                }
            }
        }
    }


}
