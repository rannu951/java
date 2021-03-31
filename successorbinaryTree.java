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
        Node n8 = new Node();
        Node n9 = new Node();
        Node n10 = new Node();
        Node n11 = new Node();
        Node n12 = new Node();
        Node n13 = new Node();
        Node n14 = new Node();
        Node n15 = new Node();
        
        n1.name = "1";
        n2.name = "2";
        n3.name = "3";
        n4.name = "4";
        n5.name = "5";
        n6.name = "6";
        n7.name = "7";
        n8.name = "8";
        n9.name = "9";
        n10.name = "10";        
        n11.name = "11";
        n12.name = "12";
        n13.name = "13";
        n14.name = "14";
        n15.name = "15";
        
        
        n8.leftChild    =   (n4);
        n8.rightChild   =   (n9);
    
        n4.leftChild    =   (n2);
        n4.rightChild   =   (n6);
        n4.father       =   (n8);
        
        n2.leftChild    =   (n1);
        n2.rightChild   =   (n3);
        n2.father       =   (n4);
        
        n6.leftChild    =   (n5);
        n6.rightChild   =   (n7);
        n6.father       =   (n4);
        
        n1.father       =   (n2);
        n3.father       =   (n2);
        
        n5.father       =   (n6);
        n7.father       =   (n6);
        
        n12.leftChild    =   (n10);
        n12.rightChild   =   (n14);
        n12.father       =   (n8);
        
        n10.leftChild    =   (n9);
        n10.rightChild   =   (n11);
        n10.father       =   (n12);
        
        n14.leftChild    =   (n13);
        n14.rightChild   =   (n15);
        n14.father       =   (n12);
        
        n9.father        =   (n10);
        n11.father       =   (n10);
        
        n13.father       =   (n14);
        n15.father       =   (n14);
    
        
        System.out.println(successor(n1).name);
        System.out.println(successor(n2).name);
        System.out.println(successor(n3).name);
        System.out.println(successor(n4).name);
        System.out.println(successor(n5).name);
        System.out.println(successor(n6).name);
        System.out.println(successor(n7).name);
        System.out.println(successor(n8).name);
        System.out.println(successor(n9).name);
        System.out.println(successor(n10).name);
        System.out.println(successor(n11).name);
        System.out.println(successor(n12).name);
        System.out.println(successor(n13).name);
        System.out.println(successor(n14).name);
        System.out.println(successor(n15));
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
        public Node leftChild = null;
        public Node rightChild = null;
        public Node father = null;
    }
    
    public static Node successor (Node node)
    {
        if(node.rightChild == null && node.father.leftChild == node)
        {
            return node.father;
        }
        if(node.rightChild != null)
        {
            return downLeft(node.rightChild);   
        }
        if(node.father.leftChild == node)
        {
            return node.father;
        }
        if(node.father.rightChild == node)
        {
            return upRight(node.father);
        }
        return null;
    }
    
    public static Node downLeft(Node node)
    {
        if(node.leftChild == null)
        {
            return node;
        }
        return downLeft(node.leftChild);
    }
    
    public static Node upRight(Node node)
    {
        if(node.father == null)
        {
            return null;
        }
        if(node.father.leftChild == node)
        {

            return (node.father);
        }
        else
        {
            return upRight(node.father);
        }

    }
    
}
