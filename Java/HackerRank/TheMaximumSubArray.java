import java.util.ArrayList;
import java.util.List;

public class TheMaximumSubArray {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here
        int max=arr.get(0);
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<arr.size();i++){
            if(max<arr.get(i)) max=arr.get(i);
        }
        if(max <0) {
            res.add(max); res.add(max); return res;
        }
        int maxSoFar=0;
        int currentSum=0;
        int positiveSum=0;
        for(int i=0;i<arr.size();i++){
            currentSum=Math.max(currentSum+arr.get(i),0);
            maxSoFar=Math.max(maxSoFar, currentSum);
            if(arr.get(i)>0) positiveSum+=arr.get(i);
        }
        res.add(maxSoFar);
        res.add(positiveSum);
        return res;
    }
}
