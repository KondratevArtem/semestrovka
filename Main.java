package SemestrovkaAATree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        System.out.println(tree.getRoot().value);
        System.out.println(tree.getRoot().left.value);
        System.out.println(tree.getRoot().right.value);
        System.out.println(tree.getRoot().right.right.value);
        System.out.println(tree.getRoot().right.left.value);

    }
}
