import java.util.ArrayList;
import java.util.List;

public class CodeThieuNhi3 {
    public static void loiGiai(){
        QHD("edabcd");
    }
    public static void QHD(String str){
        int[][] F=new int[str.length()][str.length()];
        for(int jk=0;jk<str.length();jk++) F[jk][jk]=0;

        for(int i=0;i+1<str.length();i++){
            if(str.charAt(i)==str.charAt(i+1)) F[i][i+1]=0;
            else F[i][i+1]=1;
        }

        for(int i=2;i<str.length();i++){// do dai cua mang
            for(int j=0;j+i<str.length();i++){
                int len=j+i;
                if(str.charAt(j)==str.charAt(len)) F[j][len]=F[j+1][len-1];
                else {
                    F[j][j+i]=Math.min(F[j][len-1],F[j+1][len])+1;
                }
            }
        }
        //truy vet
        int l=0;int r=str.length()-1;
        List<Character> temp=new ArrayList<>() ;
        for(char racter : str.toCharArray()){
            temp.add(racter);
        }
        while(l<r){
            if(str.charAt(l)==str.charAt(r)) {
                l++;r--;
            }else{
                if(F[l][r-1]>F[l+1][r]) {
                    // a(_101_b)a
                    temp.add(r+1,str.charAt(l++));


                }
                else{
                    // b(a_101_)b
                    temp.add(l,str.charAt(r));
                    r=r-2;// vi add thi se them 1, tru 2 de xuong khoang duoi
                    l++;
                }
            }
        }
        temp.forEach(item-> System.out.print(item));

    }
}
