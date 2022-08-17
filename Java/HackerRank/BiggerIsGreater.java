public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] temp=w.toCharArray();
        if(nextPermutate(temp)){
            StringBuilder str=new StringBuilder();
            for(char c:temp){
                str.append(c);
            }
            return str.toString();
        }
        else return "no answer";


    }
    private static boolean nextPermutate(char[] arr){
        int i=arr.length-1;
        while(i>0&&arr[i-1]>=arr[i]){
            i--;
        }//Suffix not increase
        if(i<=0){
            return false;
        }
        //arr[i-1] is pivot
        int j=arr.length-1;
        while(arr[i-1]>=arr[j]){
            j--;
        }
        //arr[j] is the new pivot
        char temp=arr[i-1];
        arr[i-1]=arr[j];
        arr[j]=temp;
        j=arr.length-1;
        while(i<j){
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return true;
    }
}
