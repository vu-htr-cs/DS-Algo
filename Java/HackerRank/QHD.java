public class QHD {
    public static void quyHoach(int[] W,int[] V,int[][] F,int m,int n){
        // khong can phai fill vao
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                F[i][j]=F[i-1][j];
                if(j>=W[i-1] && F[i][j]<F[i][j-W[i-1]] +V[i-1] ) F[i][j]=F[i-1][j-W[i-1]] +V[i-1];
            }
        }
        for(int i=0;i< F.length;i++){
            for(int j=0;j<F[0].length;j++){
                System.out.print(F[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public static void Trace(int[]W ,int n,int[][] F,int M){
        while(n!=0) {
            if(F[n][M]!=F[n-1][M]) {
                System.out.println(n);
                M=M-W[n-1];
            }
            n--;
        }
    }
}
