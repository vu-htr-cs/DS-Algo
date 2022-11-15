public class QuayLui{
    public static void run(){
    }
    public static void printResult(int[] x){
        for(int i=0;i<x.length;i++){
            System.out.print(x[i]);
        }
        System.out.println();
    }
    public static void getStarted(int[] x,int j){
        for(int i=0;i<=1;i++){
            x[j]=i;
            if(j==x.length-1) printResult(x);
            else getStarted(x,j+1);
        }
    }
    public static void tapcon(int[] x,int k,int i,int[] y){
        // x[i-1]+ 1 = < x[i] = < x[n-k+i]
        //n = last index
        int n=x.length -1;
        for(int j=x[i-1]+1;j<=x[n-k+i];j++){
            y[i]=j;
            if(i==k-1) printResult(y);
            else tapcon(x,k,i+1,y);
        }

    }

}