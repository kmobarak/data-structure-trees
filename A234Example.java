import aud.A234Tree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

public class A234Example {
    public static void main(String[] args) {
        A234Tree<Integer> tree = new A234Tree<>();

        int[] numbers = {3, 7, 5, 15, 17, 9, 13, 21, 11, 19};

        // Insert numbers into the tree
        for (int number : numbers) {
            tree.insert(number);
        }

        DotViewer viewer = DotViewer.displayWindow(tree, "2-3-4 Tree");

        SingleStepper stepper = new SingleStepper(viewer.parent());

        System.out.println("Initial Tree:");
        System.out.println(tree);

        stepper.halt("Initial Tree");

        for (int number : numbers) {
            tree.insert(number);
            stepper.halt("Insert " + number);
        }

        System.out.println("Final Tree:");
        System.out.println(tree);
    }
}

