
import java.util.ArrayList;


public class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node p) {
        if (p == null) return; // nếu cây rỗng thì không in gì cả và return
        System.out.print(p.info + "  ");// in giá trị của của node p ra
    }

    //return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) return null; // này là return lại rỗng vì cây chưa có giá trị gì cả ( cây rỗng )
        if (p.info == key) return p; // này là trả về địa chỉ ô nhớ chưa node cần search.
        else if (p.info > key) return search(p.left, key); // này dùng đệ quy để duyệt qua cây để tìm node chứa giá trị cần tìm ( này là nếu node đang duyệt có giá trị bé hơn gía trị cần tìm )
        else return search(p.right, key); // này dùng đệ quy để duyệt qua cây để tìm node chứa giá trị cần tìm ( này là nếu node đang duyệt có giá trị lớn hơn gía trị cần tìm )
    }

    //insert a key x to the tree
    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, // node này l node cha của node trống để insert node mới vào
                q = root; // node này để coi node tiếp theo của node f có rỗng không để thực hiện vòng lặp để duyệt cây tìm node rỗng để insert vào
        while (q != null) { // này là vòng lă để tìm node rỗng thích hợp để insert vào
            if (q.info == x) { // kiểm tra xem node cần insert vào đã tồn tịa chưa, nếu có rồi thì return lại không insert vào nữa
                System.out.println("Key cannot be duplicated...");
                return;
            }
            if (q.info < x) { // kiểm tra xem giá trị của node cần insert có lớn hơn hay bé hơn node đang duyệt trong cây, nếu bé thì nằm bên left còn lớn thì right
                f = q; // gán địa chỉ ô nhớ của node đang duyệt cho f để xác định f là node cha của node insert vào sau khi node được duyệt tiếp theo là null
                q = q.right; // thực hiện chuyển tiếp node tiếp theo để duyệt xem có phù hợp để insert vào không, điều kiện là null
            } else {
                f = q;// gán địa chỉ ô nhớ của node đang duyệt cho f để xác định f là node cha của node insert vào sau khi node được duyệt tiếp theo là null
                q = q.left; // thực hiện chuyển tiếp node tiếp theo để duyệt xem có phù hợp để insert vào không, điều kiện là null

            }
        }
        if (f == null) root = p; // trees have no node ( cây rỗng )
        else if (p.info > f.info) f.right = p; // thực hiện gán địa chỉ ô nhớ mới hay còn gọi là insert node mới vào cây ( if này là giá trị insert vào lớn hơn giá trị của node cha )
        else f.left = p; // này là như trên nhưng là gắn bên node left của node cha vì giá trị bé hơn
    }

    //preorder a tree || in cây theo hướng duyệt cây preorder (root, left, right)
    public void preOrder(Node p) {
        if (p == null) return; // sẽ không in gì cả
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    //postorder a tree
    public void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //inorder a tree
    public void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    //bft
    public void BFT(Node p) {
        if (p == null) return;
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null) m.enqueue(q.left);
            if (q.right != null) m.enqueue(q.right);
        }
    }

    //height of tree
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) return (lDepth + 1);//use the larger one
            else return (rDepth + 1);
        }
    }

    /*Part 2___________________________________________________________________*/
    //delete a node on BST
    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) q = q.left;
            else q = q.right;
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) root = null;
            else if (f.left == p) f.left = null;
            else f.right = null;
        }
        //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) root = p.left;
            else if (f.left == p) f.left = p.left;
            else f.right = p.left;
        }
        //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) root = p.right;
            else if (f.left == p) f.left = p.right;
            else f.right = p.right;
        }
        //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) p.left = q.left;
            else f.right = q.left;
        }
    }

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) q = q.left;
            else q = q.right;
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) root = null;
            else if (f.left == p) f.left = null;
            else f.right = null;
        }
        //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) root = p.left;
            else if (f.left == p) f.left = p.left;
            else f.right = p.left;
        }
        //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) root = p.right;
            else if (f.left == p) f.left = p.right;
            else f.right = p.right;
        }
        //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) root = p.left;
            else if (f.left == p) f.left = p.left;
            else f.right = p.left;
        }
    }

    //balancing a BST
    //inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) return;
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //insert all items from an array to a new BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) return;
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        insert(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int l = a.size(), f = 0;
        //create a new tree and insert all items from a to the BST
        BSTree t = new BSTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    /*Part 3___________________________________________________________________*/
    public Node rotateLeft(Node p) {
        if (p.right == null) return p;
        Node p1 = p.right;
        p.right = p1.left;
        p1.left = p;
        return p1;
    }

    public Node rotateRight(Node p) {
        if (p.left == null) return p;
        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        return p1;
    }
}
