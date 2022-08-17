import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlmostSorted {
    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        List<Integer> sorted=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            sorted.add(arr.get(i));
        }
        Collections.sort(sorted);
        List<Integer> indice=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=sorted.get(i)){
                indice.add(i);
            }
        }
        if (isAsc(arr)) {
            System.out.println("yes");
            return;
        }

        if(indice.size()==2){
            swap(indice.get(0),indice.get(1),arr);
            if(isAsc(arr)){
                System.out.println("yes");
                System.out.println("swap "+(indice.get(0)+1)+ " " +(indice.get(1)+1));
            }else System.out.println("no");
        }
        else{
            if(indice.size()>2){
                int l=indice.get(0);
                int r=indice.get(indice.size()-1);
                while(l<r){
                    swap(l++, r--, arr);
                }
                if(isAsc(arr)){
                    System.out.println("yes");
                    System.out.println("reverse "+(indice.get(0)+1)+ " " +(indice.get(indice.size()-1)+1));
                }
                else System.out.println("no");
            }
            else System.out.println("no");
        }

    }
    public static void swap(int a,int b,List<Integer> arr){
        int temp=arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);

    }
    public static boolean isAsc(List<Integer> d) {
        for (int i = 0; i < d.size()-1; ++i) {
            if (d.get(i) > d.get(i+1)) return false;
        }
        return true;
    }
}
