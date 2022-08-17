import java.util.List;

public class ThreeDSurfaceArea {
    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int totalArea=2*A.size()*A.get(0).size();
        int m=A.size();
        int n=A.get(0).size();
        int northView=0,southView=0,leftView=0,rightView=0;

        for(int i=0;i<A.get(0).size();i++){
            northView+=A.get(0).get(i);
            southView+=A.get(A.size()-1).get(i);
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                northView+=(A.get(i).get(j) > A.get(i-1).get(j))?
                        A.get(i).get(j) - A.get(i-1).get(j)
                        :0;
                southView+=A.get(m-i-1).get(j)>A.get(m-i).get(j)?
                        A.get(m-i-1).get(j)-A.get(m-i).get(j):0;
            }
        }
        totalArea+=northView+southView;

        for(int i=0;i<m;i++){
            leftView+=A.get(i).get(0);
            rightView+=A.get(i).get(n-1);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                leftView+=A.get(j).get(i)>A.get(j).get(i-1)?
                        A.get(j).get(i)-A.get(j).get(i-1):0;
                rightView+=A.get(j).get(n-1-i)>A.get(j).get(n-i)?
                        A.get(j).get(n-1-i)-A.get(j).get(n-i):0;
            }
        }
        totalArea+=leftView+rightView;
        return totalArea;

    }
}
