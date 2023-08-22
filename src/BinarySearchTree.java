public class BinarySearchTree {
    private BinaryTreeNode root;

    static void inOrderTraversalImp(BinaryTreeNode root){
        if (root!=null){
            inOrderTraversalImp(root.left);
            System.out.print(root.data);
            System.out.print(" ");
            inOrderTraversalImp(root.right);
        }
    }
    public void inOrderTraversal(){
        System.out.print("[");
        inOrderTraversalImp(root);
        System.out.print("]\n");
}
    static void preOrderTraversalImp(BinaryTreeNode root){
        if (root!=null){
            System.out.print(root.data);
            System.out.print(" ");
            preOrderTraversalImp(root.left);
            preOrderTraversalImp(root.right);
        }
    }
    public void preOrderTraversal(){
        System.out.print("[");
        preOrderTraversalImp(root);
        System.out.print("]\n");
    }
    static void postOrderTraversalImp(BinaryTreeNode root){
        if (root!=null){
            postOrderTraversalImp(root.left);
            postOrderTraversalImp(root.right);
            System.out.print(root.data);
            System.out.print(" ");
        }
    }
    public void postOrderTraversal(){
        System.out.print("[");
        postOrderTraversalImp(root);
        System.out.print("]\n");
    }
    static void levelOrderTraversal(BinaryTreeNode root){
        if (root!=null){
            java.util.Queue<BinaryTreeNode> queue = new java.util.LinkedList<BinaryTreeNode>();
            queue.add(root);
            while (!queue.isEmpty()){
                BinaryTreeNode node=queue.remove();
                System.out.println(node.data);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }
    private void insertImp(BinaryTreeNode root, BinaryTreeNode newNode){
        if (newNode.data<=root.data){
            if (root.left==null){
                root.left=newNode;
            }else {
                insertImp(root.left,newNode);
            }
        }else{
            if (root.right==null){
                root.right=newNode;

            }else {
                insertImp(root.right,newNode);
            }
        }
    }
    public void insert(int data){
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root==null){
            root = newNode;
        }else{
            insertImp(root, newNode);
        }
    }
    public int max(){
        if (root==null){
            return -1;
        }else {
            BinaryTreeNode current=root;
            while (current.right!=null){
                current=current.right;
            }
            return current.data;
        }
    }
    public int min(){
        if (root==null){
            return -1;
        }else {
            BinaryTreeNode current=root;
            while (current.left!=null){
                current=current.left;
            }
            return current.data;
        }
    }
    public BinaryTreeNode deleteByCopyImp(BinaryTreeNode root,int data){
        if (root == null){
            return null;
        } else if (data< root.data) {
            root.left=deleteByCopyImp(root.left,data);
            return root;

        } else if (data> root.data) {
            root.right=deleteByCopyImp(root.right,data);
            return  root;
        }else {
            if (root.left==null && root.right==null){
                return null;
            } else if (root.left==null) {
                return root.right;

            } else if (root.right==null) {
                return root.left;
            }else{
                BinaryTreeNode current = root.right;
                while (current.left!=null){
                    current=current.left;
                }
                root.data= current.data;
                root.right=deleteByCopyImp(root.right,current.data);
                return root;
            }
        }
    }
    public void deleteByCopy(int data){
        root = deleteByCopyImp(root,data);
    }

    public BinaryTreeNode deleteByMergeImp(BinaryTreeNode root,int data){
        if (root == null){
            return null;
        } else if (data< root.data) {
            root.left=deleteByMergeImp(root.left,data);
            return root;

        } else if (data> root.data) {
            root.right=deleteByMergeImp(root.right,data);
            return  root;
        }else {
            if (root.left==null && root.right==null){
                return null;
            } else if (root.left==null) {
                return root.right;

            } else if (root.right==null) {
                return root.left;
            }else{
                BinaryTreeNode current = root.left;
                while (current.right!=null){
                    current=current.right;
                }
                current.right = root.right;
                return root.left;
            }
        }
    }
    public void deleteByMerge(int data){
        root = deleteByMergeImp(root,data);
    }



}
class BinarySearchTreeRunner{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(32);
        bst.insert(54);
        bst.insert(12);
        bst.insert(16);
        bst.insert(17);
        bst.insert(392);
        bst.insert(100);
        bst.insert(55);
        bst.insert(48);
        bst.inOrderTraversal();
        bst.deleteByMerge(54);
        bst.inOrderTraversal();

    }
}

