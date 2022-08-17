package SortAlgo;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        root=null;
    }
    public BinarySearchTree(int value){
        root =new Node(value);
    }
    public Node insertRec(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data < root.data){
            root.left=insertRec(root.left,data);
        }
        if(data > root.data){
            root.right=insertRec(root.right,data);
        }
        return root;
    }
    public void insert(int data){
        root =insertRec(root,data);
    }
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.print(root.data +" ");
            inorderRec(root.right);
        }
    }
    public void treeins(int[] arr){
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
    }
}
