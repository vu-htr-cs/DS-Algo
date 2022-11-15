public class Node {
    private int data;
    private char character;
    private Node left;
    private Node right;

    public Node(int data, char character) {
        this.data = data;
        this.character = character;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.character = '\0';
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public char getCharacter() {
        return character;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null && character != '\0';
    }
}
