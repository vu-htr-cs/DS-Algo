public class BaiTap4 {
    public static void loiGiai(){
        int[][] A={
                {1,2,6,7,9},
                {7,6,5,6,7},
                {1,2,3,4,2},
                {4,7,8,7,6}
        };
        int[][] B=new int[4][5];
        B[0][0]=1;B[1][0]=7;B[2][0]=1;B[3][0]=4;
        gameStart(A,B);
        System.out.println(B[3][2]);
    }
    public static void gameStart(int[][] A,int[][] B){
        for(int i=0;i<B.length;i++){
            for(int j=1;j<B[0].length;j++){
                if(i>0 && i<B.length-1)
                    B[i][j]=Math.max(Math.max(B[i][j-1],B[i+1][j-1]),B[i-1][j-1] );
                else {
                    if(i==0) B[i][j] =Math.max(B[i][j-1],B[i+1][j-1]);
                    else B[i][j] =Math.max(B[i][j-1],B[i-1][j-1]);
                }
                B[i][j]+= A[i][j];
            }
        }
    }
}
