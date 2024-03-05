uimport aud.KTreeNode;
import aud.util.DotViewer;
import aud.util.SingleStepper;

import java.util.Random;

public class MyBTree<T extends Comparable<T>> extends aud.BTree<T> {
    /**
     * create an empty tree of order 2*m+1
     *
     * @param m
     */
    public MyBTree(int m) {
        super(m);
    }

    public int getHeight() {
        return height(this.root(), 0);
    }

    private int height(KTreeNode<T> root, int h) {
        if (root == null) {
            return h;
        }
        return height(root.getChild(0), h + 1);
    }

    public static void main(String[] args) {
        // Create an instance of MyBTree with m = 2
        MyBTree<Integer> bTree = new MyBTree<>(2);

        // Insert values into the B-Tree
        bTree.insert(6);
        bTree.insert(18);
        bTree.insert(22);
        bTree.insert(3);
        bTree.insert(11);
        bTree.insert(16);
        bTree.insert(7);
        bTree.insert(10);
        bTree.insert(1);
        bTree.insert(8);
        bTree.insert(12);

        // Visualize the B-Tree
        DotViewer viewer = DotViewer.displayWindow(bTree.toString(), "B-Tree");
        System.out.println("Height of the B-Tree: " + bTree.getHeight());

        // Test with random values
        for (int key = 1; key <= 100; key += 3) {
            MyBTree<Integer> randomTree = new MyBTree<>(key);

            Random random = new Random();
            for (int j = 0; j < 1000000; j++) {
                randomTree.insert(random.nextInt());
            }

            System.out.println("For m = " + key + ", height = " + randomTree.getHeight());
        }
    }
}
