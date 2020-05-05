package SemestrovkaAATree;

public class Node<T> {
    public int level;
    public T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value, Node<T> right, Node<T> left) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.level = 1;
    }

    public Node(T value) {
        this(value, null, null);
    }

    public Node() {
        this.level = 0;
        this.value = null;
        this.left = this.right = this;
    }
}
