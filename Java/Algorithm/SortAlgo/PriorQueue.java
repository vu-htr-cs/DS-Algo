package SortAlgo;

public class PriorQueue {
    private int[] arr;
    private int n=0;
    public void maxheap(int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<=n && arr[left] > arr[largest]){
            largest=left;
        }
        if(right<=n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest);
            maxheap(largest);
        }
    }
    public void minheap(int i){
        int smallest=i;int left=2*i+1;int right=2*i+2;
        if(left<=n&&arr[left]<arr[smallest]) {
            smallest = left;
        }
        if(right<=n&& arr[right]<arr[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            swap(i,smallest);
            minheap(smallest);
        }
    }
    public void swap(int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public PriorQueue(int[] arr){
        this.arr=arr;
        this.n=arr.length-1;
    }
    public void runMaxHeap(){
        for(int i=n/2;i>=0;i--){
            maxheap(i);
        }
    }
    public void show(){
        for (int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public void runMinHeap(){
        for(int i=n/2;i>=0;i--){
            minheap(i);
        }
    }
    public void maxHeapSort(){
        int heapSize=n;
        runMaxHeap();
        for(int i=n;i>=1;i--){
            swap(0,i);//doi vi tri cuoi cung
            n--;
            maxheap(0);
        }
        n=heapSize;
    }
    public void addMax(int element){
        if(n==0){
            arr=new int[1];
            arr[0]=element;
            n=1;
        }else{
            n++;
            int k=n;
            int[] res=new int[k+1];
            for(int i=0;i<n-1;i++){
                res[i]=arr[i];
            }
            res[n-1]=element;
            arr=res;
            while (k>0 && arr[k/2]<arr[k]){
                swap(k/2,k);
                k=k/2;
            }
        }
    }
    public int popMax(){
        if(n==0){
            System.out.println("Prior Queue is empty!");
            return -1;
        }
        int max=arr[0];
        arr[0]=arr[n];
        n--;
        maxheap(0);
        return max;
    }

}
