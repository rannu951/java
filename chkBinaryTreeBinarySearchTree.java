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

    
        n4.leftChild    =   (n2);
        n4.rightChild   =   (n6);
        
        n2.leftChild    =   (n1);
        n2.rightChild   =   (n3);
        
        n6.leftChild    =   (n5);
        n6.rightChild   =   (n7);
        
        Queue<Integer> qu = new LinkedList<Integer>();
        
        inOrder(qu, n4);

        
        System.out.println(checkQueueAscending(qu));    
        
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
        public Node leftChild = null;
        public Node rightChild = null;
    }

    
    
    public static class MyPair
    {
        private final int       heigth;
        private final boolean   balance;
        
        MyPair(int h , boolean b)
        {
            heigth   = h;
            balance  = b;
        }
        
        public int key()
        {
            return heigth;
        }
        
        public boolean value()
        {
            return balance;
        }
    }
    
    static  void inOrder(Queue<Integer> qu, Node n)
    {
        if(n.leftChild != null)
        {
            inOrder(qu, n.leftChild);
        }
        
        qu.add(Integer.parseInt(n.name));
        
        if(n.rightChild != null)
        {
            inOrder(qu, n.rightChild);
        }
    }
    
    static boolean checkQueueAscending(Queue<Integer> qu)
    {
        while(qu.size()>1)
        {
            int tmp = qu.remove();
            if(tmp > qu.peek())
            {
                return false;
            }
        }
        return true;
    }
    
}
