import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void run(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader sc= new BufferedReader(inputStreamReader);
            int q = Integer.parseInt(sc.readLine());

            StringBuilder s = new StringBuilder();
            Stack<String> st = new Stack<>();
            st.push(s.toString());

            for (int i = 0; i < q; i++) {
                String[] queries = sc.readLine().split(" ");
                int t = Integer.parseInt(queries[0]);
                if (t == 1) {
                    s.append(queries[1].toLowerCase());
                    st.push(s.toString());
                }
                if (t == 2) {
                    s.delete(s.length() - Integer.parseInt(queries[1]), s.length());
                    st.push(s.toString());
                }
                if (t == 3) {
                    System.out.println(s.charAt(Integer.parseInt(queries[1]) - 1));
                }
                if (t == 4) {
                    st.pop();
                    s = new StringBuilder(st.peek());
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
