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
        

        n1.leftChild    =   (n2);
        n1.rightChild   =   (n3);
        
        n2.leftChild    =   (n4);
        n2.rightChild   =   (n5);
        
        n4.leftChild    =   (n6);
        n4.rightChild   =   (n7);
        
        
        System.out.println(isBalance(n1).value());
        
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
    
    static MyPair isBalance(Node root)
    {
        int         heigth  = 0;
        boolean     balance = true;
        MyPair      lT      = new MyPair(-1,true);
        MyPair      rT      = new MyPair(-1,true);
        
        if(root.leftChild != null)
        {
            lT = isBalance(root.leftChild);
        }
        if(root.rightChild != null && lT.value())
        {
            rT = isBalance(root.rightChild);
        }       
        
        if(!lT.value() || !rT.value() || Math.abs(lT.key()-rT.key())>1 )
        {
            balance = false;
        }
        
        if(lT.key()!=-1 || rT.key()!=-1)
        {
            heigth = ((lT.key() > rT.key()) ? lT.key()+1 : rT.key()+1);
        }
                
        MyPair r = new MyPair(heigth, balance);
        
        return r;
    }

    
}
