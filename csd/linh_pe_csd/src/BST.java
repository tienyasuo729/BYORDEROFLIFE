public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node search(Node p, int key) {
        if (p == null) return null; // này là return lại rỗng vì cây chưa có giá trị gì cả ( cây rỗng )
        if (p.getData().getKey() == key) return p; // này là trả về địa chỉ ô nhớ chưa node cần search.
        else if (p.getData().getKey() > key) return search(p.getLeft(), key); // này dùng đệ quy để duyệt qua cây để tìm node chứa giá trị cần tìm ( này là nếu node đang duyệt có giá trị bé hơn gía trị cần tìm )
        else return search(p.getRight(), key); // này dùng đệ quy để duyệt qua cây để tìm node chứa giá trị cần tìm ( này là nếu node đang duyệt có giá trị lớn hơn gía trị cần tìm )
    }

    public void insert(Worker x) {
        Node p = new Node(x);
        Node f = null, // node này l node cha của node trống để insert node mới vào
                q = root; // node này để coi node tiếp theo của node f có rỗng không để thực hiện vòng lặp để duyệt cây tìm node rỗng để insert vào
        while (q != null) { // này là vòng lă để tìm node rỗng thích hợp để insert vào
            if (q.getData().getKey() == x.getKey()) { // kiểm tra xem node cần insert vào đã tồn tịa chưa, nếu có rồi thì return lại không insert vào nữa
                System.out.println("Key cannot be duplicated...");
                return;
            }
            if (q.getData().getKey() < x.getKey()) { // kiểm tra xem giá trị của node cần insert có lớn hơn hay bé hơn node đang duyệt trong cây, nếu bé thì nằm bên left còn lớn thì right
                f = q; // gán địa chỉ ô nhớ của node đang duyệt cho f để xác định f là node cha của node insert vào sau khi node được duyệt tiếp theo là null
                q = q.getRight(); // thực hiện chuyển tiếp node tiếp theo để duyệt xem có phù hợp để insert vào không, điều kiện là null
            } else {
                f = q;// gán địa chỉ ô nhớ của node đang duyệt cho f để xác định f là node cha của node insert vào sau khi node được duyệt tiếp theo là null
                q = q.getLeft(); // thực hiện chuyển tiếp node tiếp theo để duyệt xem có phù hợp để insert vào không, điều kiện là null

            }
        }
        if (f == null) root = p; // trees have no node ( cây rỗng )
        else if (p.getData().getKey() > f.getData().getKey()) {
            f.getRight() = p; // thực hiện gán địa chỉ ô nhớ mới hay còn gọi là insert node mới vào cây ( if này là giá trị insert vào lớn hơn giá trị của node cha )
        } else {
            f.getLeft() = p; // này là như trên nhưng là gắn bên node left của node cha vì giá trị bé hơn
        }
    }
}
