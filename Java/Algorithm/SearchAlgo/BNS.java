package SearchAlgo;

public class BNS {
    public static int binarySearch(int[] a,int l,int r,int target){
        //arr must be sorted
        if(l>r) return -1;
        int mid=(l+r)/2;
        if(a[mid]==target){
            return mid;
        }
        else{
            if(a[mid]<target) return binarySearch(a,mid+1,r,target);
            else return binarySearch(a,l,mid-1,target);
        }
    }
    public static int ternarySearch(int[] a,int target){
        int l=0;
        int r=a.length-1;
        while (r >= l) {
            int partition=(l+r)/3;
            int mid1=l+partition;
            int mid2=r-partition;
            if(target==a[mid1]) return mid1;
            else{
                if(target==a[mid2]) return mid2;
                else {
                    if(target<a[mid1]) r=mid1-1;
                    else {
                        if(target>a[mid2]) l=mid2+1;
                        else{
                            l=mid1+1;
                            r=mid2-1;
                        }
                    }
                }
            }

        }
        return -1;
    }
    public static int jumpSearch(int[] a,int target){
        int blockSize=(int) Math.sqrt(a.length);
        int start=0;
        int nextStep=blockSize;
        while(start<a.length && target>a[nextStep-1]){
            //can j, tim kieu cai ma target < a[blocksize]
            start=nextStep;
            nextStep+=blockSize;
            if(nextStep>=a.length){
                nextStep=a.length;
            }
        }
        for(int i=start;i<nextStep;i++){
            if(a[i]==target) return i;
        }
        return -1;
    }
    public static int exponentialSearch(int[] a,int target){
        int bound=1;
        while(bound<a.length&&target>a[bound]){
            bound=bound*2;
        }
        if(bound<a.length) return binarySearch(a,bound/2,Math.min(bound,a.length-1),target);
        return -1;
    }

}
