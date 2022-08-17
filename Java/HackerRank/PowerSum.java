public class PowerSum {
    public static int powerSum(int X, int N) {
        // Write your code here
        return recursive(X, N, 1);

    }
    public static int recursive(int total,int power,int number){
        int value=total - (int)Math.pow(number,power);
        if(value<0) return 0;
        if(value==0) return 1;
        return recursive(value, power, number+1) + recursive(total, power, number+1);
    }
}
