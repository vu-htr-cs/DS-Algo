import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    private static int n;
    private static int[] arr;
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        arr=new int[A.size()];
        n=A.size()-1;
        for(int i=0;i<=A.size()-1;i++){
            arr[i]=A.get(i);
        }
        runMinHeap();
        int count=0;
        while(arr[0]<k && n!=1 ){
            int a=popMin();
            int b=popMin();
            insertElement(a+2*b);
            count++;
        }

        if(n==1&&arr[0]<k) return -1;
        else return count;

    }
    public static void minHeap(int i){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<=n && arr[left]<arr[smallest]) smallest=left; // left > small
        if(right<=n && arr[right] <arr[smallest]) smallest=right;// right > left > small
        if(smallest!=i){
            swap(smallest,i);
            minHeap(smallest);
        }
    }
    public static void swap(int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void runMinHeap(){
        for(int i=n/2 -1 ;i>=0;i--){
            minHeap(i);
        }
    }
    public static int popMin(){
        if(n==0) {
            System.out.println("Prior Queue is empty!");
            return -1;
        }
        int min=arr[0];
        arr[0]=arr[n];
        n--;
        minHeap(0);
        return min;
    }
    public static void insertElement(int val){
        n++;
        int k=n;
        arr[n]=val;
        while (k>=0 && arr[(k-1)/2]>arr[k]){
            swap((k-1)/2,k);
            k=(k-1)/2;
        }
    }
    public static void heapSort(){
        int heapSize=n;
        runMinHeap();
        for(int i=n;i>=0;i--){
            swap(0, i);
            n--;
            minHeap(0);
        }
        n=heapSize;
    }
    public static int useLibrary(int k, List<Integer> A){
        int count=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer num : A) pq.add(num);
        if(pq.size()==0) return -1;
        if(pq.size()==1 && pq.peek()<k ) return -1;
        while(pq.size()>1 && pq.peek()<k){
            count++;
            int firstNum=pq.poll();
            int secondNum=pq.poll();
            pq.add(firstNum+2*secondNum);
        }
        if(pq.size()==1 && pq.peek()<k) return -1;
        else return count;
    }

}
