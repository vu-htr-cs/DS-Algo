import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int[] c={1,3,5};
        System.out.println(getWays(5,c));
    }
    public static void makeDirectory(){
        final Path CURRENT_FOLDER= Paths.get(System.getProperty(("user.dir")));
        Path imgPath= Paths.get("serverimg","productimg");
        Path target= CURRENT_FOLDER.getParent().resolve(imgPath);
        File temp =new File(CURRENT_FOLDER.getParent().resolve(imgPath).toUri());
        if(!temp.exists()){
            System.out.println("Khong ton tai");
            temp.mkdirs();
        }
        else{
            System.out.println("Ton tai");
        }
        System.out.println(target);
    }
    public static long getWays(int n,int[] c){
        int[] min=new int[n+1];
        for(int i=0;i<min.length;i++){
            min[i]=Integer.MAX_VALUE;
        }
        min[0]=0;
        for(int i=1;i<min.length;i++){
            for(int j=0;j<c.length;j++){
                if(c[j]<=i && min[i-c[j]]+1<min[i]) min[i]=min[i-c[j]]+1;
            }
        }
        return min[n];
    }
}
