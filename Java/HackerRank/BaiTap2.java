import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class BaiTap2 {
    @Deprecated
    public static void loigiai(){
        int[] arr={0,23,14,26,17,12,20,15,1,99,10,4};
        int M=110;
        int[] b=new int[M+1];
        chiaKeo(arr,M,b);
        Result(arr,M,b);
    }
    public static void chiaKeo(int[] arr,int M,int[] b){
        b[0]=0;// co so quy hoach dong
        for(int i=1;i<=M;i++){
            b[i]=Integer.MAX_VALUE;
        }

        for(int i=1;i<=M;i++){
            //dung cac ket qua cua bai toan con de tim ra ket qua cua bai toan lon hon
            //b[0] = 0, chi so 0
            int minK=arr.length;//minK o tren phan tu cuoi
            for(int k=1;k<arr.length;k++){
                if(arr[k]<=i && b[i-arr[k]] <k && k<minK) minK=k ;
            }
            if(minK!=arr.length){
                b[i]=minK;
            }
        }

    }
    public static void Result(int[] arr,int M,int[] b){
        int n=M;
        if(b[M]==Integer.MAX_VALUE) {
            System.out.println("Khong co cach chon");
            return;
        }
        while (n!=0){
            System.out.println(b[n]);// M
            n=n-arr[b[n]];// in ra M-arr[b[M]]
        }
    }
    @Target(ElementType.TYPE)
    public @interface myinterface{
        String sayHello();
    }
}
