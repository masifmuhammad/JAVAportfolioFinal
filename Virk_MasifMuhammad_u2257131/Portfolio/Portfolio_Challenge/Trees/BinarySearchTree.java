package Portfolio.Portfolio_Challenge.Trees;

/**
 * Implements a Binary Search Tree
 */
public class BinarySearchTree implements BinaryTree {

    private TreeNode root;   // A pointer to the root of the tree
    private int size;        // The number of nodes in the tree

    /**
     * Creates a binary search tree
     */
    public BinarySearchTree() {
        // Initialize tree in O(1)
        this.root = null;
        size = 0;
    }

    @Override
    public String toString() {
        // Implement in O(n)
        return toString(root);
    }

    /* Collection Interface */

    @Override
    public int size() {
        // Implement in O(1)
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Implement in O(1)
        return size()==0;
    }

    @Override
    public boolean contains(String element) {
        // Implement in O(logn)
        TreeNode currNode = root;
        while (currNode != null) {
            if (element.compareTo(currNode.getElement()) == 0) {
                return true;
            } else if (element.compareTo(currNode.getElement()) < 0) {
                currNode = currNode.getLeftChild();
            } else {
                currNode = currNode.getRightChild();
            }
        }
        return false;
    }

    /* BinaryTree Interface */

    /* Core functions */

    @Override
    public TreeNode root() {
        // Implement in O(1)
        return root;
    }

    @Override
    public TreeNode parent(TreeNode node) {
        // Implement in O(1)
        return node.getParent();
    }

    @Override
    public TreeNode left(TreeNode node) {
        // Implement in O(1)
        return node.getLeftChild();
    }

    @Override
    public TreeNode right(TreeNode node) {
        // Implement in O(1)
        return node.getRightChild();
    }

    @Override
    public TreeNode sibling(TreeNode node) {
        // Implement in O(1)
        if(node == root || node.getParent() == null){
            return null;
        }

        if(node.getParent().getLeftChild() == node){
            return node.getParent().getRightChild();
        } else if (node.getParent().getRightChild() == node){
            return node.getParent().getLeftChild();
        }

        return null;
    }

    @Override
    public int numChildren(TreeNode node) {
        // Implement in O(1)
        int count = 0;
        if(node.getLeftChild() != null) count++;
        if (node.getRightChild() != null) count++;

        return count;
    }

    @Override
    public boolean isInternal(TreeNode node) {
        // Implement in O(1)
        return node.getLeftChild() != null || node.getRightChild() != null;
    }

    @Override
    public boolean isExternal(TreeNode node) {
        // Implement in O(1)
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    @Override
    public boolean isRoot(TreeNode node) {
        // Implement in O(1)
        return node == root;
    }

    /* Add element */

    @Override
    public TreeNode add(String element) {
        // Implement in O(logn)
        TreeNode newNode = new TreeNode(element,null,null,null);
        if (root == null) {
            root = newNode;
            size++;
            return root;
        }

        TreeNode currNode = root;
        TreeNode parentNode = null;
        while (true) {
            parentNode = currNode;
            if (element.compareTo(currNode.getElement()) < 0) {
                currNode = currNode.getLeftChild();
                if (currNode == null) {
                    parentNode.setLeftChild(newNode);
                    newNode.setParent(parentNode);
                    size++;
                    return newNode;
                }
            } else {
                currNode = currNode.getRightChild();
                if (currNode == null) {
                    parentNode.setRightChild(newNode);
                    newNode.setParent(parentNode);
                    size++;
                    return newNode;
                }
            }
        }
    }

    /* Get element */

    @Override
    public TreeNode get(String element) {
        // Implement in O(logn)
        TreeNode currNode = root;
        while (currNode != null) {
            if (element.compareTo(currNode.getElement()) == 0) {
                return currNode;
            } else if (element.compareTo(currNode.getElement()) < 0) {
                currNode = currNode.getLeftChild();
            } else {
                currNode = currNode.getRightChild();
            }
        }
        return null;
    }

    /* Remove element */

    @Override
    public String remove(String element){
        // Note: Implement in O(logn)
        TreeNode currNode = root;
        TreeNode parentNode = root;
        boolean isLeftChild = true;

        while (currNode.getElement().compareTo(element) != 0) {
            parentNode = currNode;
            if (element.compareTo(currNode.getElement()) < 0) {
                isLeftChild = true;
                currNode = currNode.getLeftChild();
            } else {
                isLeftChild = false;
                currNode = currNode.getRightChild();
            }
            if (currNode == null) {
                return null;
            }
        }

        if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
            if (currNode == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } else if (currNode.getRightChild() == null) {
            if (currNode == root) {
                root = currNode.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currNode.getLeftChild());
            } else {
                parentNode.setRightChild(currNode.getLeftChild());
            }
        } else if (currNode.getLeftChild() == null) {
            if (currNode == root) {
                root = currNode.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currNode.getRightChild());
            } else {
                parentNode.setRightChild(currNode.getRightChild());
            }
        } else {
            TreeNode successor = getSuccessor(currNode);
            if (currNode == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.setLeftChild(successor);
            } else {
                parentNode.setRightChild(successor);
            }
            successor.setLeftChild(currNode.getLeftChild());

        }
        return currNode.getElement();
    }

    private String toString(TreeNode node) {
        if (node == null) {
            return "";
        }
        return toString(node.getLeftChild()) + node.getElement() + " " + toString(node.getRightChild());
    }

    private TreeNode getSuccessor(TreeNode deleteNode) {
        TreeNode successorParent = deleteNode;
        TreeNode successor = deleteNode;
        TreeNode currNode = deleteNode.getRightChild();
        while (currNode != null) {
            successorParent = successor;
            successor = currNode;
            currNode = currNode.getLeftChild();
        }
        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }
}
