public class DivineK {
    public static void dynamicProgram(int k,int[] arr){
        int[][] F=new int[arr.length+1][k];
        for (int i = 1; i < F[0].length; i++) {
            F[0][i]=255;
        }
        for(int i=1;i<=arr.length;i++){
            for(int t=0;t<k;t++){
                F[i][t]=Math.min(F[i-1][t],F[i-1][sub(t,arr[i-1],k)]+1);
            }
        }
        printResult(F,k,arr);
    }
    public static int sub(int x,int y,int k){
        int temp=(x-y)%k;
        if (temp>=0) return temp;
        else return temp+k;
    }
    public static void printResult(int[][] F,int k,int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];// arr[arr.length-1]
        }
        int t=sum%k;
        int sumArr=0;
        System.out.println(F[arr.length][t]);
        for(int i=arr.length;i>0;i--){
            if(F[i][t]==F[i-1][t]){
                System.out.printf("arr[%d]=%d \n",i-1,arr[i-1]);
                sumArr+=arr[i-1];
            }else t=sub(t,arr[i-1],k);
        }
        System.out.println(sumArr);
    }
}
