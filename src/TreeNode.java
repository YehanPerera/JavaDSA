public class TreeNode {
    String data;
    TreeNode child;
    TreeNode sibling;

     TreeNode(String data){
        this.data=data;
        this.child=null;
        this.sibling=null;
     }
}
class TreeRunner{
    public static void main(String[] args) {
        TreeNode root=new TreeNode("DEAN FOS");
        root.child=new TreeNode("DH BIO");
        root.child.sibling=new TreeNode("DH MATHS");
        root.child.sibling.sibling=new TreeNode("DH CHEM");
        root.child.sibling.sibling.sibling=new TreeNode("DH PHY");

        root.child.child=new TreeNode("A");
        root.child.child.sibling=new TreeNode("B");
        root.child.sibling.child=new TreeNode("C");
        root.child.sibling.sibling.child=new TreeNode("D");
        root.child.sibling.sibling.child.sibling=new TreeNode("E");
        root.child.sibling.sibling.child.sibling.sibling=new TreeNode("F");
    }
}
