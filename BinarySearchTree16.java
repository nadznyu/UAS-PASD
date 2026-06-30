public class BinarySearchTree16 {
    Node16 root;

    Node16 insert(Node16 root, int data) {
        if (root == null) {
            return new Node16(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    boolean search(Node16 root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    Node16 minValue(Node16 node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    Node16 delete(Node16 root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = delete(root.left, key);

        else if (key > root.data)
            root.right = delete(root.right, key);

        else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            Node16 temp = minValue(root.right);

            root.data = temp.data;

            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    void inOrder(Node16 root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    int countNode(Node16 root) {
        if (root == null)
            return 0;

        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree16 tree = new BinarySearchTree16();

        int[] data = {
                63, 15, 98,
                13, 20, 89, 112,
                11, 14, 16, 25, 72, 95
        };

        for (int x : data)
            tree.root = tree.insert(tree.root, x);

        System.out.println("BST Awal (InOrder): ");
        tree.inOrder(tree.root);

        System.out.println("\n\nCari 98 : " + (tree.search(tree.root, 98) ? "Ditemukan" : "Tidak ditemukan"));

        tree.root = tree.insert(tree.root, 73);

        System.out.println("\n\nSetelah Insert 73: ");
        tree.inOrder(tree.root);

        tree.root = tree.delete(tree.root, 98);

        System.out.println("\n\nSetelah Delete 98: ");
        tree.inOrder(tree.root);

        System.out.println("\n\nJumlah total node = " + tree.countNode(tree.root));
    }
}