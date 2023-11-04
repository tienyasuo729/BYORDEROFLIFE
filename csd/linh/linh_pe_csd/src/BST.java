public class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    public Worker findWorker(int key) {
        return findWorker(root, key);
    }

    private Worker findWorker(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.worker.key) {
            return node.worker;
        } else if (key < node.worker.key) {
            return findWorker(node.left, key);
        } else {
            return findWorker(node.right, key);
        }
    }

    public void insertWorker(Worker worker) {
        root = insertWorker(root, worker);
    }

    private TreeNode insertWorker(TreeNode node, Worker worker) {
        if (node == null) {
            return new TreeNode(worker);
        }

        if (worker.key < node.worker.key) {
            node.left = insertWorker(node.left, worker);
        } else if (worker.key > node.worker.key) {
            node.right = insertWorker(node.right, worker);
        }

        return node;
    }

    public void printWorkersDescending() {
        printWorkersDescending(root);
    }

    private void printWorkersDescending(TreeNode node) {
        if (node == null) {
            return;
        }

        printWorkersDescending(node.right);
        System.out.println(node.worker);
        printWorkersDescending(node.left);
    }

    public int countWorkersUnder25() {
        return countWorkersUnder25(root);
    }

    private int countWorkersUnder25(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int count = countWorkersUnder25(node.left) + countWorkersUnder25(node.right);

        if (node.worker.age < 25) {
            count++;
        }

        return count;
    }

    public void deleteRightMostNode() {
        root = deleteRightMostNode(root);
    }

    private TreeNode deleteRightMostNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.left;
        }

        node.right = deleteRightMostNode(node.right);

        return node;
    }

    public int calculateHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
