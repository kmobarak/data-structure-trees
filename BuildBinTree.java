import aud.BinaryTree;
import aud.util.DotViewer;

/*
Binäre Baume sind aus knoten besteht. und jeder Knoten hat maximal 2 kinder. Rechts und Links.b
 */

public class BuildBinTree {
    public static void main(String[] args) {

        // Erstellen des Wurzelknotens und des Binärbaums
        Node root = new Node(30);   // Die Wurzel des Baums hat den Wert 30
        root.left = new Node(20);   // Der linke Teilbaum von root hat den Wert 20
        root.right = new Node(40);  // Der rechte Teilbaum von root hat den Wert 40
        root.right.left = new Node(25);  // Der linke Teilbaum von root.right hat den Wert 25
        root.right.right = new Node(50); // Der rechte Teilbaum von root.right hat den Wert 50
        root.left.left = new Node(10);   // Der linke Teilbaum von root.left hat den Wert 10
        root.left.right = new Node(35);  // Der rechte Teilbaum von root.left hat den Wert 35

        // Erstellen des Binärbaum-Objekts aus dem Wurzelknoten
        BinaryTree<Node> tree = new BinaryTree<>(root);

        // Anzeigen des Binärbaums mithilfe der DotViewer-Klasse
        DotViewer.displayWindow(tree.toDot(),"tree");

        // Ausgabe des Binärbaums im TikZ-Format
        System.out.println(tree.toTikZ());

        // Ausgabe der Knotenwerte in den verschiedenen Traversierungsreihenfolgen
        System.out.println("preOrder:" + tree.preorder() );   // Ausgabe der Pre-Order Traversierung
        System.out.println("inOrder:" + tree.inorder());      // Ausgabe der In-Order Traversierung
        System.out.println("postOrder:" +  tree.postorder()); // Ausgabe der Post-Order Traversierung
        System.out.println("levelOrder:" +  tree.levelorder());// Ausgabe der Level-Order Traversierung

    }
}

// Definition der Knoten-Klasse
class Node {

    int data;       // Der Wert des Knotens
    Node left;      // Der linke Nachfolger-Knoten
    Node right;     // Der rechte Nachfolger-Knoten

    // Konstruktor für die Knoten-Klasse
    Node (int data){
        this.data = data;
    }
}
