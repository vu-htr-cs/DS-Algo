import java.util.ArrayList;
import java.util.List;

public class SherlockHome {
    public static int sherlockAndAnagrams(String s) {
        List<String> temp=getAllSubString(s);
        int count=0;
        for(int i=0;i<temp.size()-1;i++){
            for(int j=i+1;j<temp.size();j++){
                if(temp.get(i).length()==temp.get(j).length()&&isAnangram(temp.get(i), temp.get(j))){
                    count++;
                }
            }
        }
        return count;


    }
    public static List<String> getAllSubString(String s){
        List<String> res=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                res.add(s.substring(i,j));
            }
        }
        return res;
    }
    public static boolean isAnangram(String str1,String str2){
        int[] willam=new int[26];
        for(int i=0;i<str1.length();i++){
            willam[str1.charAt(i)-'a']++;
            willam[str2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(willam[i]!=0) return false;
        }
        return true;
    }
}
