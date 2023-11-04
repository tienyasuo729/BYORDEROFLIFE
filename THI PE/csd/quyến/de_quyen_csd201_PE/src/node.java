public class node implements Comparable<node>{
    teacher data;
    node left, right;
    int bal;
    int level;
    public node(teacher data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.bal = 0;
        this.level = -1;
    }
    @Override public String toString() {
        return "["+data+":"+level+","+bal+"]";
    }
    @Override public int compareTo(node o) {
        return data.compareTo(o.data);
    }
}