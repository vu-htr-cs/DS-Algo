import java.util.List;

public class StockMaximize {
    public static long stockmax(List<Integer> prices) {
        // Write your code here
        long mywallet=0;
        int max=0;
        for(int i=prices.size()-1;i>=0;i--){
            if(prices.get(i)>max) max=prices.get(i);
            mywallet+= max-prices.get(i);
        }
        return mywallet;
    }
}
