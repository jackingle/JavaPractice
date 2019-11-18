


class Node {
	int data;
	Node left, right;
	public Node(int item) {
		data = item;
		left = right = null;
	}
}
public class BinaryTree {
	Node root;
	int minimumDepth() {
		return minimumDepth(root);
	}
	int minimumDepth(Node root) 
    { 
        if (root == null) 
            return 0; 
        
        if (root.left == null && root.right == null) 
            return 1; 
  
        if (root.left == null) 
            return minimumDepth(root.right) + 1; 
  
         if (root.right == null) 
            return minimumDepth(root.left) + 1; 
  
        return Math.min(minimumDepth(root.left), 
                        minimumDepth(root.right)) + 1; 
    } 
  
    
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        System.out.println("The minimum depth of "+ 
          "binary tree is : " + tree.minimumDepth()); 
    } 
} 

