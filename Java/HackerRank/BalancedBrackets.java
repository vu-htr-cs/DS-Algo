import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> mystack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') mystack.push(c);
            else switch (c) {
                case '}':
                    if (mystack.isEmpty() || mystack.pop() != '{') return "NO";
                    break;
                case ']':
                    if (mystack.isEmpty() || mystack.pop() != '[') return "NO";
                    break;
                case ')':
                    if (mystack.isEmpty() || mystack.pop() != '(') return "NO";
                    break;
                default:
                    return "NO";
            }// neu stack rong ma con ben phai, du ky tu ben phai return "NO";
        }

        if (mystack.isEmpty()) return "YES";// Khong du ky tu ben nao ca
        else return "NO";// neu du ky tu ben phai return "NO";
    }

    public static String loiGiai2(String s) {
        Stack<Character> mystack = new Stack<>();
        Map<Character, Character> mymap = new HashMap<>();
        mymap.put('[', ']');
        mymap.put('{', '}');
        mymap.put('(', ')');
        Set<Character> positive = mymap.keySet();
        for (char c : s.toCharArray()) {
            if (positive.contains(c)) mystack.push(c);
            else {
                if (mystack.isEmpty() || c != mymap.get(mystack.pop())) return "NO";
            }
        }
        if (mystack.isEmpty()) return "YES";
        else return "NO";
    }
    public static String loiGiai3(String s){
        int n=-1;
        while(n!=s.length()){
            n=s.length();
            s=s.replace("()","");
            s=s.replace("[]","");
            s=s.replace("{}","");
        }
        if(s.length()==0) return "YES";
        else return "NO";
    }

}
