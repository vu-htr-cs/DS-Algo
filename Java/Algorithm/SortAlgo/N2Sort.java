package SortAlgo;

public class N2Sort {
    public static int[] bubbleSort(int[] a){
        int temp;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j]; a[j]=a[j+1];a[j+1]=temp;
                }
            }
        }
        return a;
    }
    public static int[] insertionSort(int[] a){
        int key,j;
        for(int i=1;i<a.length;i++){
            key=a[i];
            j=i-1;
            while(j>=0&&a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        return a;
    }
    public static int[] selectionSort(int[] a){
        for(int i=0;i<a.length;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]) min=j;
            }
            swap(a,i,min);
        }
        return a;
    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void mergeSort(int[] a,int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            merge(a,l,r,mid);
        }
    }
    public static int[] merge(int[] a,int l,int r,int mid){
        int i=0;int j=0;
        int[] L=new int[mid-l+1];
        int[] R=new int[r-mid];
        int[] M=new int[r-l+1];
        for(int k=l;k<=r;k++){
            if(k<=mid) L[i++]=a[k];
            else R[j++]=a[k];
        }
        i=j=0;
        int k=0;
        while(i<L.length&&j<R.length){
            if(L[i]<=R[j]) M[k++]=L[i++];
            else M[k++]=R[j++];
        }
        while(i<L.length){
            M[k++]=L[i++];
        }
        while (j<R.length){
            M[k++]=R[j++];
        }
        for(int x=l;x<=r;x++){
            a[x]=M[x-l];
        }
        return M;
    }
    public static void quickSort(int[] a,int l,int r){
        int p=a[(l+r)/2];
        int i=l;int j=r;
        while(i<j){
            while(a[i]<p){
                i++;
            }
            while(a[j]>p){
                j--;
            }
            if(i<=j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;j--;
            }
        }
        if(i<r){
            quickSort(a,i,r);
        }
        if(l<j){
            quickSort(a,l,j);
        }
    }

}
