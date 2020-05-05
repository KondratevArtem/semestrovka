package SemestrovkaAATree;

public interface AATree<T extends Comparable<T>>{
    void clear();

    boolean isEmpty();

    Node<T> skew(Node<T> node);

    Node<T> split(Node<T> node);

    void insert(T value);

    Node<T> search(T value);

    Node<T> delete(T value, Node<T> current);
}