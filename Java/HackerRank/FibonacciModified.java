import java.io.*;
import java.math.BigInteger;


public class FibonacciModified {
    public static void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        BigInteger t1 = BigInteger.valueOf(Integer.parseInt(firstMultipleInput[0]));

        BigInteger t2 = BigInteger.valueOf(Integer.parseInt(firstMultipleInput[1]));

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigInteger result = Result.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    class Result {

        /*
         * Complete the 'fibonacciModified' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER t1
         *  2. INTEGER t2
         *  3. INTEGER n
         */

        public static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {
            // Write your code here
            BigInteger[] F = new BigInteger[n + 1];
            F[0] = t1;
            F[1] = t2;
            for (int i = 2; i < F.length; i++) {
                F[i] = F[i - 2].add(F[i - 1].multiply(F[i - 1]));
            }
            return F[n - 1];
        }

    }
}
