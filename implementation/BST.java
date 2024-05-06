public class BST {
    private int key;
    private BST left;
    private BST right;

    // Default constructor
    public BST(int key) {
        this.key = key;
    }

    // Another constructor
    public BST(int key, BST left, BST right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // Search
    // Return the BST node that contains the searchKey
    // Return the BST rooted at the node whose key matched the searchKey
    public BST search(BST T, int searchKey) {
        // Using recursion

        // Base case
        if (T == null) {
            return null;
        }
        if (searchKey == T.key) { // be careful with the "==" here, only works with Primitive type
            return T;
        }

        // recursive call
        if (searchKey < T.key) {
            // search left branch
            return search(T.left, searchKey);
        } else {
            // search right branch
            return search(T.right, searchKey);
        }
    }

    // Insert
    // This "recursion" solution is bad
    // Rookie mistake, bad habit to avoid
    // Half-assed recursion, I did not trust the base case to do its thing
    // The section where if (T.left == null) T.left = new BST(newKey) (bad!!!!!!!!!!!!)
    // I did not 100% trust the recursion (the base case) to do its job
    public void insert1(BST T, int newKey) {
        // if found, do nothing
        // if not found, create new node and set appropriate link

        if (newKey == T.key) {
            // do nothing
            return;
        }

        // recursive call
        if (newKey < T.key) {
            // search left branch
            if (T.left == null) {
                // create new node and set link
                T.left = new BST(newKey);
                return;
            } else {
                insert1(T.left, newKey);
            }
        } else {
            // search right branch
            if (T.right == null) {
                // create new node and set link
                T.right = new BST(newKey);
                return;
            } else {
                insert1(T.right, newKey);
            }
        }
    }

    // Another insert
    // Return a full BST with the new node inserted at the correct position
    public BST insert(BST T, int insertKey) {
        if (T == null) {
            // if passed below the leaf already, return a new BST node
            // kinda like reconstructing the tree
            return new BST(insertKey);
        }

        if (insertKey < T.key) {
            // reconstructing the left branch
            T.left = insert(T.left, insertKey);
        } else {
            // reconstructing the right branch
            T.right = insert(T.right, insertKey);
        }

        // in the end, return the new reconstructed BST
        return T;
    }

}