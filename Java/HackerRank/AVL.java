public class AVL {
    static int getHeight(Node root){
        if(root==null) return -1;//null=1 and leaf=0
        return  1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    static Node rightRotate(Node root){
        Node x=root.left;
        root.left=x.right;
        x.right=root;
        root.ht=1+Math.max(getHeight(root.left),getHeight(root.right));
        x.ht=1+Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }
    static Node leftRotate(Node root){

        Node y=root.right;
        root.right=y.left;
        y.left=root;
        root.ht=1+Math.max(getHeight(root.left),getHeight(root.right));
        y.ht=1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
    static Node insert(Node root,int val)
    {
        if(root==null){
            root=new Node();
            root.val=val;
            root.ht=getHeight(root);
            return root;

        }
        if(val>root.val){
            root.right=insert(root.right,val);
        }
        else if(val<root.val) root.left=insert(root.left,val);
        else return root;//distinct
        root.ht=1+Math.max(getHeight(root.left),getHeight(root.right));
        int balanceFator=getHeight(root.left)-getHeight(root.right);

        if(balanceFator>1 && val<root.left.val){
            return rightRotate(root);
        }
        if(balanceFator<-1 &&val>root.right.val){
            return leftRotate(root);
        }
        if(balanceFator>1 &&val>root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balanceFator<-1 &&val<root.right.val){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
}
