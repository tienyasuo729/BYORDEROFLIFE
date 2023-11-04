import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    node root;
    public BST() {
        root = null;
    }
    void insert(teacher o) {
        node[] res = search(o);
        if (res[0] != null) return; // if này kiểm tra node được tìm kiếm nếu trùng với dữ liệu cần thêm vào cây thì return và không làm gì cả, còn nếu null thì thực hiện thêm dữ liệu vào cây
        node n = new node(o); // bắt đầu thêm dữ liệu vào cây từ đây
        if (res[1] == null) root=n;
        else if (n.compareTo(res[1]) < 0)
            res[1].left = n;
        else
            res[1].right = n;
    }
    node[] search(teacher o) { // tìm vị trí null hoặc có dữ liệu bằng với đối tượng đã cho rồi trả về một mảng gồm node chứa địa chỉ node đã tìm ra và địa chỉ node cha của node đã tìm ra
        node t = root, parent = null; // bắt đầu từ gốc
        while (t != null && t.data.compareTo(o) != 0) { // kiểm tra xem vị trí node được duyệt qua có bị null hoặc trùng với dữ liệu cần tìm kiếm hay không, nếu có thì sẽ dừng vòng lặp để return dữ liệu tìm kiếm về
            parent = t;
            if (t.data.compareTo(o) < 0) t= t.right; // nếu ở đoạn này mà thắt mắc lở như node đang duyệt bằng với dữ liệu cần tìm thì đã được năng chặn ở điều kiện của hàm while rồi nên không phỉa lo vị trí duyệt hiện tại bị đổi chổ sang node khác
            else t=t.left;
        }
        return new node[]{t, parent}; // trả về địa chỉ node có giá trị null hoặc bằng với dữ liệu cần tìm kiếm và địa chỉ node cha của node đã tìm ra
    }
    //    [1.0 m] Output all teachers in pre-order traversal (recursion).
    void pre_order() {
        pre_order(root);
    }
    void pre_order(node t) {
        if (t == null) return;
        System.out.println(""+t);
        pre_order(t.left);
        pre_order(t.right);
    }
    //  2.  Print all nodes in the form of <data, level>.
    void level_order() {
        Queue<node> q = new LinkedList<>();
        q.add(root); root.level = 0;
        while (!q.isEmpty()) {
            node t = q.poll(); System.out.println(""+t);
            if (t.left != null) {
                q.add(t.left); t.left.level = t.level + 1;
            }
            if (t.right != null) {
                q.add(t.right); t.right.level = t.level + 1;
            }
        }
    }
    //    [1.0 m] Determine the field bal for all node.
    void determine_bal() {
        determine_bal(root);
    }
    int determine_bal(node t) {
        if (t == null) return 0;
        int hLeft = determine_bal(t.left);
        int hRight = determine_bal(t.right);
        t.bal = hLeft - hRight;
        return 1 + Math.max(hLeft, hRight);
    }
    //    int height(node t) {
//        if (t == null) return 0;
//        int max_left = height(t.left);
//        int max_right = height(t.right);
//        return 1 + Math.max(max_left, max_right);
//    }
//    [1.0 m] Increase M / 2.0 to the coeff of each teacher where M is the maximum coeff.
    void increase() {
        double M = max_coeff(root);
        increase(root, M / 2.0);
    }
    void increase(node t, double delta) {
        if (t == null) return;
        t.data.coeff += delta;
        increase(t.left, delta);
        increase(t.right, delta);
    }
    double max_coeff(node t) {
        if (t == null) return Integer.MIN_VALUE;
        double max_left = max_coeff(t.left);
        double max_right = max_coeff(t.right);
        return Math.max(t.data.coeff, Math.max(max_left, max_right));
    }
    ArrayList<teacher> in_order() {
        ArrayList<teacher> res = new ArrayList<>();
        in_order(root, res);
        return res;
    }
    void in_order(node t, ArrayList<teacher> res) {
        if (t == null) return;
        in_order(t.right, res);
        res.add(t.data);
        in_order(t.left, res);
    }
    void level_recursion() {
        level_recursion(root, 0);
    }
    void level_recursion(node t, int level) {
        if (t == null) return;
        System.out.println(""+ t + " = " + level);
        level_recursion(t.left, level+1);
        level_recursion(t.right, level+1);
    }
}