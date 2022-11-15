import java.util.List;
import java.util.Stack;

public class EqualStack {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sum1=0;int sum2=0;int sum3=0;
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        Stack<Integer> s3=new Stack<>();

        for(int i=0;i<h1.size();i++) {sum1+=h1.get(i); s1.push(h1.get(h1.size()-i -1));}
        for(int i=0;i<h2.size();i++) {sum2+=h2.get(i); s2.push(h2.get(h2.size()-i -1));}
        for(int i=0;i<h3.size();i++) {sum3+=h3.get(i); s3.push(h3.get(h3.size() -i -1));}

        while(sum1!=sum2 || sum2!=sum3){
            int max=Math.max(sum1,Math.max(sum2, sum3));
            if(max==sum1) sum1-=s1.pop();
            else{
                if(max==sum2) sum2-=s2.pop();
                else sum3-=s3.pop();
            }
            if(sum1==0|| sum2==0||sum3==0) return 0;
        }
        return sum1;
    }
}
