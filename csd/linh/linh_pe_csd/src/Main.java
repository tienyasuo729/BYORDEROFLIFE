public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        Worker worker1 = new Worker(5, "Alice", 28);
        Worker worker2 = new Worker(3, "Bob", 22);
        Worker worker3 = new Worker(7, "Charlie", 19);
        Worker worker4 = new Worker(2, "David", 30);

        tree.insertWorker(worker1);
        tree.insertWorker(worker2);
        tree.insertWorker(worker3);
        tree.insertWorker(worker4);

        System.out.println("Find Worker with key 3: " + tree.findWorker(3));
        System.out.println("Count of Workers under 25: " + tree.countWorkersUnder25());

        System.out.println("Printing Workers in Descending Order:");
        tree.printWorkersDescending();

        System.out.println("Calculating Height of the Tree: " + tree.calculateHeight());

        tree.deleteRightMostNode();

        System.out.println("After Deleting the Right-Most Node:");
        tree.printWorkersDescending();
    }
}