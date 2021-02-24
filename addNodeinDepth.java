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
        

        n1.leftChild = n2;
        n1.rightChild = n3;
        n2.leftChild = n4;
        n2.rightChild = n5;
        n3.leftChild = n6;
        n3.rightChild = n7;
        
        ArrayList<LinkedList<Node>> allln = new ArrayList<LinkedList<Node>>();

        
        addNodeinDepth(allln, n1, 0);
        
        System.out.println(allln.get(2).get(3).name);
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
        public Node leftChild = null;
        public Node rightChild = null;
    }
    
    public static void addNodeinDepth(ArrayList<LinkedList<Node>> allln, Node n, int depth){
      
        if( n == null ){
            return;
        }

        if(allln.size()>depth){
            LinkedList<Node> lln = allln.get(depth);
            lln.add(n);
        } 
        else{
            LinkedList<Node> lln = new LinkedList<Node>();
            lln.add(n);
            allln.add(lln);
        }
        
        ++depth;
        addDepth(allln, n.leftChild, depth);            
        addDepth(allln, n.rightChild, depth);            
    }
    
}
