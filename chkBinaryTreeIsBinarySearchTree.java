import java.util.*;
import java.lang.Math;
public class MyClass {
    public static void main(String args[]) {
        
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        
        n1.name = "1";
        n2.name = "2";
        n3.name = "3";
        n4.name = "4";
        n5.name = "5";
        n6.name = "6";
        n7.name = "7";

        
    
        n3.leftChild    =   (n2);
        n3.rightChild   =   (n6);
        
        n2.leftChild    =   (n1);
        n2.rightChild   =   (n4);
        
        n6.leftChild    =   (n5);
        n6.rightChild   =   (n7);

        
        System.out.println(chkBinaryTreeIsBinarySearchTree(n3));  
        
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
        public Node leftChild = null;
        public Node rightChild = null;
    }
    
    public static boolean chkBinaryTreeIsBinarySearchTree(Node root)
    {
        if(root.leftChild == null && root.rightChild == null)
        {
            return true;
        }


        boolean leftIsBST = ((root.leftChild == null) ? true : chkBinaryTreeIsBinarySearchTree(root.leftChild));
        boolean rightIsBST = ((root.rightChild == null) ? true : chkBinaryTreeIsBinarySearchTree(root.rightChild));

        if(!leftIsBST || !rightIsBST)
        {
            return false;
        }

        if(root.leftChild != null)
        {
            if(largestLeft(root.leftChild) > Integer.parseInt(root.name))
            {
                return false;
            }
        }
        
        if(root.rightChild != null)
        {
            if(shortestRight(root.rightChild) < Integer.parseInt(root.name))
            {
                return false;
            }
        }

        return true;
    }
    
    public static int largestLeft(Node root)
    {
        if(root.rightChild == null)
        {
            return Integer.parseInt(root.name);
        }
        return largestLeft(root.rightChild);
    }
    
    public static int shortestRight(Node root)
    {
        if(root.leftChild == null)
        {
            return Integer.parseInt(root.name);
        }
        return shortestRight(root.leftChild);
    }
    
}
