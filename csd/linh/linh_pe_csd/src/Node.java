public class Node implements  Comparable<Node>{
    Worker data;
    Node left, right;

    public Node(Worker data) {
        this.data = data;
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
