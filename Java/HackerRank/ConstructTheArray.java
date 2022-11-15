public class ConstructTheArray {
    public static long countArray(int n, int k, int x) {
        // Return the number of ways to fill in the array.
        long[] F=new long[n+1];
        long[] G=new long[n+1];
        G[2]=0;
        F[2]=1;
        for(int i=3;i<=n;i++){
            G[i]=F[i-1]*(k-1);
            F[i]=G[i-1]+F[i-1]*(k-2);
            G[i]%=1e9+7;
            F[i]%=1e9+7;
        }
        return x==1?G[n]:F[n];
    }
}
