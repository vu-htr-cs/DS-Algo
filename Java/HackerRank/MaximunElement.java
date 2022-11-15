import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximunElement {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        List<Integer> res=new ArrayList<>();
        Stack<Integer> mystack=new Stack<>();
        Stack<Integer> trackingStack=new Stack<>();
        for(String str:operations){
            String[] temp=str.split(" ");
            if(temp[0].equals("1")){
                int cur=Integer.parseInt(temp[1]);
                mystack.push(cur);
                if(mystack.size()==1) trackingStack.push(cur);
                else{
                    if(cur>trackingStack.peek()) trackingStack.push(cur);
                    else trackingStack.push(trackingStack.peek());
                }
                continue;
            }
            if(temp[0].equals("2")){
                mystack.pop();
                trackingStack.pop();
            }
            else res.add(trackingStack.peek());
        }
        return res;// O(n)
    }
    //https://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/
}
