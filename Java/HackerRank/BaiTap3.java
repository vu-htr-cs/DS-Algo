import java.util.ArrayList;
import java.util.List;

public class BaiTap3 {
    public static void loigiai(){
        int[] arr={0,23,14,26,17,12,20,15,1,99,10,4};

        int Sum=0;
        for(int jk=0;jk<arr.length;jk++){
            Sum+=arr[jk];
        }
        int mid=Sum/2;
        int[] b=new int[mid+1];
        chiaKeo(arr,mid,b);
        int T;// T<= M va T lon nhat co the
        for(int j=mid;j>=1;j--){
            if(b[j] <Integer.MAX_VALUE){
                T=j;
                System.out.println("Nhom thu nhat");
                List<Integer> res=Result(arr,T,b);
                if(res.size()!=0){
                    System.out.println("Nhom thu hai");
                    System.out.print("[");
                    for(int i=1;i<arr.length;i++){
                        if(!res.contains(arr[i])) System.out.print(arr[i] +" ");
                    }
                    System.out.println("]");
                }

                break;
            }
        }

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
    public static List<Integer> Result(int[] arr, int M, int[] b){
        List<Integer> res=new ArrayList<>();
        int n=M;
        if(b[M]==Integer.MAX_VALUE) {
            System.out.println("Khong co cach chon");
            return res;
        }
        System.out.print("[");
        while (n!=0){
            System.out.print(arr[b[n]] +" ");// M
            res.add(arr[b[n]]);
            n=n-arr[b[n]];// in ra M-arr[b[M]]
        }
        System.out.println("]");
        return res;
    }
}
