public class Table {
    private Node _root;

    public Table() {
        _root = null;
    }

    public Keyed search(Keyed key ) {
        return search(key, _root);
    }
    private Keyed search(Keyed key, Node node ) {
        if(node == null) return null;

        int comp = key.keyComp(node.data);
        Keyed data = null;
        if(comp == 0) return node.data;
        else if(comp > 0) data = search(key, node.right);
        else data = search(key, node.left);
        return data;
    }

    public int getHeight() {
        return getHeight(_root);
    }
    private int getHeight(Node node) {
        if( node == null ) {
            return 0;
        }

        int leftTree = getHeight(node.left);
        int rightTree = getHeight(node.right);
        return leftTree > rightTree ? leftTree + 1 : rightTree + 1;

    }

    public int getSize() {
        return getSize(_root);
    }

    private int getSize(Node node) {
        if(node == null ) {
            return 0;
        }
        return 1 + getSize(node.right) + getSize(node.left);
    }

    public void showTree() {
        int spacing = 0;
        showTree(_root, spacing);
    }
    private void showTree(Node node, int spacing) {
        int moreSpace = 5;
        if(node == null) {
            return;
        }
        spacing += moreSpace;

        showTree(node.right, spacing);
        System.out.println("");
        for (int i = moreSpace; i < spacing; i++) {
            System.out.print(" ");
        }
        System.out.print(node.data.briefSummary()+ "\n");

        showTree(node.left, spacing);

    }

    public Table initialize() {
      return new Table();
    }

    public void insertion( Keyed data ) {
        if(_root == null) {
            Node newNode = new Node(data);
            _root = newNode;
        } else {
            Node newRoot = insertion(data, _root);
            if(newRoot != null) _root = newRoot;
        }
    }
    private Node insertion(Keyed data, Node root ) {
        int comp;

        if(root == null) {
            return new Node(data);
        }
        else {
            comp = data.keyComp(root.data);
            if(comp > 0) {
                root.right = insertion(data, root.right);
            }
            else if (comp < 0) {
                root.left = insertion(data, root.left);
            }
            else return null;
        }
        return root;
    }
    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.data);
            printInOrder(node.right);
        }
    }

    @Override
    public String toString() {
        printInOrder(_root);
        return "";
    }

}
