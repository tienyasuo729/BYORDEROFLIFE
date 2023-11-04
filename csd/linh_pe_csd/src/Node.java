public class Node implements  Comparable<Node>{
    private Worker data;
    private Node left, right;

    public Node(Worker data) {
        this.data = data;
    }

    public Worker getData() {
        return data;
    }

    public void setData(Worker data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "["+data+"]";
    }

    @Override
    public int compareTo(Node o) {
        return data.compareTo(o.data);
    }
}
