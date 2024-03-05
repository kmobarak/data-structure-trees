import aud.BinaryTree;    //to use BinaryTree<T>
import aud.Queue;         //to use Queue<T>

//------------------------------------------------------------------//
public class MyBinTree<T> extends BinaryTree<T> {
    //----------------------------------------------------------------//
    public MyBinTree(T data) {
        super(data);
    }

    //----------------------------------------------------------------//
    public MyBinTree(T data,MyBinTree<T> left,MyBinTree<T> right) {
        super(data, left, right);
    }

    //----------------------------------------------------------------//
    public int maxWidth() {
        int width = 0;
        int counter = 0;
        Queue<BinaryTree<T>> queue = new Queue<>();
        queue.enqueue(getRoot());
        counter++;
        while (!queue.is_empty()) {
            int nodesAtCurrentLevel = counter;
            counter = 0;
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                BinaryTree<T> node = queue.dequeue();

                if (node.getLeft() != null) {
                    queue.enqueue(node.getLeft());
                    counter++;
                }

                if (node.getRight() != null) {
                    queue.enqueue(node.getRight());
                    counter++;
                }
            }

            if (nodesAtCurrentLevel > width) {
                width = nodesAtCurrentLevel;
            }
        }
        return width;
    }


    //---------------------------------------------------------------//
   public static void main(String[] args) {
        // Create a binary tree
        BinaryTree<Integer> root = new BinaryTree<>(1);
        BinaryTree<Integer> leftChild = new BinaryTree<>(2);
        BinaryTree<Integer> rightChild = new BinaryTree<>(3);

        root.setLeft(leftChild);
        root.setRight(rightChild);

        MyBinTree<Integer> tree = new MyBinTree<Integer>(root.getData());

        int maxWidth = tree.maxWidth();

        System.out.println("Maximum width: " + maxWidth);

    }
}
