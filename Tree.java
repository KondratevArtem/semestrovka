package SemestrovkaAATree;

public class Tree <T extends Comparable<T>> implements AATree<T> {
    private Node<T> root;
    private Node<T> lastNode;
    private Node<T> deleteNode;

    public Tree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root != null;
    }

    @Override
    public Node skew(Node node) {
        if (node == null)
            return null;
        else if (node.left == null)
            return node;
        else if (node.left.level == node.level) {
            Node<T> newNode = node.left;
            node.left = newNode.right;
            newNode.right = node;
            return newNode;
        } else
            return node;

    }

    @Override
    public Node split(Node node) {
        if (node == null)
            return null;
        else if ((node.right == null) || (node.right.right == null))
            return node;
        else if (node.right.right.level == node.level) {
            Node<T> newNode = node.right;
            node.right = newNode.left;
            newNode.left = node;
            newNode.level = newNode.level + 1;
            return newNode;
        } else
            return node;

    }

    @Override
    public void insert(T value) {
        this.root = insert(value, this.root);
    }

    private Node<T> insert(T value, Node<T> parent){
        if(parent == null)
            parent = new Node<>(value, null, null);
        else if(value.compareTo(parent.value) < 0)
            parent.left = insert(value, parent.left);
        else if(value.compareTo(parent.value) > 0)
            parent.right = insert(value, parent.right);
        else
            return parent;
        parent = skew(parent);
        parent = split(parent);
        return parent;
    }

    @Override
    public Node search(T value) {
        Node<T> current = this.root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) < 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public Node<T> delete(T value, Node<T> curr) {
        if (curr != null && curr.left != null && curr.right != null) {
            lastNode = curr;
            if (value.compareTo(curr.value) < 0)
                curr.left = delete(value, curr.left);
            else {
                deleteNode = curr;
                curr.right = delete(value, curr.right);
            }
            if (curr == lastNode) {
                if (deleteNode == null)
                    return curr;
                deleteNode.value = curr.value;
                curr = curr.right;
            } else if (curr.left.level < curr.level - 1 || curr.right.level < curr.level - 1) {
                if (curr.right.level > --curr.level)
                    curr.right.level = curr.level;
                curr = skew(curr);
                curr.right = skew(curr.right);
                curr.right.right = skew(curr.right.right);
                curr = split(curr);
                curr.right = split(curr.right);
            }
        }
        return curr;
    }
}

