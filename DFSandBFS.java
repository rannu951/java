import java.util.*;
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
        

        n2.lln.add(n4);
        n2.lln.add(n5);
        n3.lln.add(n6);
        n3.lln.add(n7);
        n1.lln.add(n2);
        n1.lln.add(n3);
        
        DFS(n1);
        
        BFS(n1);
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
    }

    
    static void DFS(Node n){
        System.out.println(n.name);
        for(int i=0 ; i<n.lln.size() ; i++){
            DFS((n.lln).get(i));
        }
    }
    
    static void BFS(Node n){
        n.visit = true;
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(n);
        while(qu.size()!=0){
            n = qu.remove();
            System.out.println(n.name);
            for(int i=0 ; i<n.lln.size() ; i++){
                Node t = (n.lln).get(i);
                if(!t.visit){
                    t.visit = true;
                    qu.add(t);
                }
            }
        }
    }
    
}
