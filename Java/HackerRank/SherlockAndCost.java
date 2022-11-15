import java.util.List;

public class SherlockAndCost {
    public static int cost(List<Integer> B) {
        // Write your code here
        int[][] F=new int[2][B.size()];
        F[0][1]=0;
        F[1][1]=0;
        for(int i=1;i<B.size();i++){
            F[1][i]=F[0][i-1]+(int)Math.abs(1-B.get(i-1));
            F[0][i]=Math.max(F[1][i-1] + Math.abs(B.get(i)- 1) ,F[0][i-1]
                    +Math.abs(B.get(i)- B.get(i-1))
            );
        }
        return Math.max(F[0][B.size()-1], F[1][B.size()-1]);

    }
}
