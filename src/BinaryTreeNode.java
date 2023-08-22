public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}
class BinaryTreeRunner{
    static void inOrderTraversal(BinaryTreeNode root){
        if (root!=null){
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }
    static void preOrderTraversal(BinaryTreeNode root){
        if (root!=null){
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    static void postOrderTraversal(BinaryTreeNode root){
        if (root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
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
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.left.left.right=new BinaryTreeNode(3);
        root.left.right=new BinaryTreeNode(5);
        root.right.left.left=new BinaryTreeNode(9);
        root.right.left.right=new BinaryTreeNode(5);
        root.right.left=new BinaryTreeNode(6);
        root.right.right=new BinaryTreeNode(7);
        inOrderTraversal(root);
        //preOrderTraversal(root);
       // postOrderTraversal(root);
        //levelOrderTraversal(root);
    }
}
