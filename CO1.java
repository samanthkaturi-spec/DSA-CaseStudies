/*Student Record Management System Using AVL Tree*/
class Node {
    int key;
    Node left, right;
    Node(int key) {
        this.key = key;
        left = right = null;
    }
}
public class Main {
    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
    static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key < root.key)
            return search(root.left, key);
        return search(root.right, key);
    }
    public static void main(String[] args) {
        Node root = null;
        int[] studentIds = {50, 30, 70, 20, 40};
        for (int id : studentIds)
            root = insert(root, id);
        int searchId = 40;
        if (search(root, searchId))
            System.out.println("Student ID " + searchId + " Found");
        else
            System.out.println("Student ID " + searchId + " Not Found");
    }
}
