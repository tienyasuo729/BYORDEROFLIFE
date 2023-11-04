import java.util.Arrays;

public class Main {
    static teacher[] tree_sort(teacher[] A) {
        BST T = new BST();
        for (teacher object : A) {
            T.insert(object);
        }
        return T.in_order().toArray(new teacher[A.length]);
    }
    public static void main(String[] args) {
        teacher[] A = new teacher[]{new teacher(5, 5), new teacher(3, 3), new teacher(2, 2),
                new teacher(4, 4), new teacher(7, 7), new teacher(6, 6), new teacher(8, 8),
                new teacher(1, 1), new teacher(9, 9)};
        BST T = new BST();
        for (teacher object : A) {
            T.insert(object);
        }
        System.out.println("Output all teachers in pre-order traversal (recursion).");
        T.pre_order();

        T.increase();
        System.out.println("Increase: "); T.level_order();

        T.determine_bal();
        System.out.println("Bal: "); T.level_order();

        System.out.println("Sorted: " + Arrays.toString(tree_sort(A)));

        T.level_recursion();
    }

}