public class PTS{
    public static void run(String[] args){
        int[] S={1,2,3,4,5,6};
        int[] t=new int[7];
        int[] x = new int[7];
        x[0]=1;
        t[0]=0;
        PTS(x,t,1);
    }
    public static void PTS(int[] x,int[] t,int i){
        for(int j=x[i-1];j<=(6-t[i-1])/2;j++){// Goi tiep chu k phai gan
            x[i]=j;
            t[i]=t[i-1]+j;
            PTS(x,t,i+1);
        }
        x[i]=6-t[i-1];// ko goi tiep nen lay phan tu khop lun
        printResult(x,i);
    }
    public static void printResult(int[]x,int k){
        for(int i=1;i<=k;i++){
            System.out.print(x[i]);
        }
        System.out.println();
    }
}