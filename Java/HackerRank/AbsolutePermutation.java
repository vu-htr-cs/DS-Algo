import java.util.ArrayList;
import java.util.List;

public class AbsolutePermutation {
    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        List<Integer> res=new ArrayList<>();
        if(k==0){
            for(int i=1;i<=n;i++){
                res.add(i);
            }
            return res;
        }
        if((n/k)%2!=0||k>n/2||n%2!=0){
            res.add(-1);
            return res;
        }
        else{
            int[] vis=new int[n+1];
            boolean add=true;
            for(int i=1;i<=n;i++){
                if(add){
                    if((i+k)<=n&&vis[i+k]==0){
                        vis[i+k]=1;
                        res.add(i+k);
                    }
                    else{
                        List<Integer> temp=new ArrayList<>();
                        temp.add(-1);
                        return temp;
                    }

                }
                else{
                    if(vis[i-k]==0){
                        vis[i-k]=1;
                        res.add(i-k);
                    }else{
                        List<Integer> temp=new ArrayList<>();
                        temp.add(-1);
                        return temp;
                    }
                }

                if(i%k==0){
                    if(add) add=false;
                    else add=true;
                }
            }
            return res;
        }

    }

}
