public class PPS{
    public static void run(){
        bai9();
    }
    public static void taphop(int[] arr,int k){
        int[] first=new int[k];
        for(int i=0;i<k;i++){
            first[i]=i+1;
        }
        //first configure
        int index=first.length-1;
        while(index>=0){
            show(first);
            index=first.length-1;
            while(index>=0&&first[index] >= arr.length - k+ index+1) index--;
            if(index>=0) {
                first[index]++;
                for(int jk=index+1;jk<first.length;jk++) first[jk]=first[jk-1]+1;
            }
        }
    }
    public static void generation(int n){
        int[] arr=new int[n];
        int i=n-1;
        while(i>=0){
            i=n-1;
            show(arr);
            while(i>=0 && arr[i]==1) i--;
            if(i>=0){
                arr[i]=1;
                fill(arr,i+1,n,0);
            }
        }

    }
    public static void show(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void fill(int[] arr,int start,int end,int val){
        for(int i=start;i<end;i++){
            arr[i]=val;
        }
    }
    public static void hoanvi(int[] arr){
        int i=arr.length-1;
        while(i>=0){
            show(arr);
            i=arr.length-2;
            while(i>=0 && arr[i]>arr[i+1]) i--;
            if(i>=0) {
                int k=arr.length -1;
                while(k>=0&&arr[k]<arr[i]) k--;
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                int a=i+1;int b=arr.length-1;
                while(a<b){
                    temp=arr[a];
                    arr[a]=arr[b];
                    arr[b]=temp;
                    a++;b--;
                }
                
            }
        }

    }
     public static void bai9(){
        //IMPS ,
        // First Configure IIIIMPPSSSS
        // Last Configure  SSSSPPMIIII
        char[] configure={'I','I','I','I','M','P','P','S','S','S','S'};
        int i=configure.length-1;
        while(i>=0){
            i=configure.length -2;
            showChar(configure);
            while(i>=0 && configure[i]>=configure[i+1]) i--;

            if(i>=0){
                int k=configure.length-1;
                while(k>=0 && configure[k] <= configure[i]) k--;
                char temp=configure[i];
                configure[i]=configure[k];
                configure[k]=temp;
            }
            int a=i+1;int b=configure.length-1;
            while(a<b){
                char temp=configure[a];
                configure[a]=configure[b];
                configure[b]=temp;
                a++;b--;
            }
        }

    }
    public static void showChar(char[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}