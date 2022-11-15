import java.util.List;
import java.util.Stack;

public class LargestRectangle {
    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        h.add(0);
        Stack<Integer> mystack=new Stack<>();
        int max=0;
        for(int i=0;i<h.size();i++){
            while(!mystack.isEmpty()&& h.get(mystack.peek()) >=h.get(i)){
                int height=h.get(mystack.pop());
                int width=mystack.isEmpty()?i:(i-mystack.peek()-1);
                max=Math.max(max,height*width);
            }
            mystack.push(i);
        }
        return max;
    }
}
