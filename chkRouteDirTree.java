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
        
        System.out.println(checkRoutate(n1,n6));
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
    }

    static boolean checkRoutate(Node source, Node target){
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(source);
        source.visit = true;
        while(qu.size()!=0){
            Node n = qu.remove();
            for(int i=0 ; i<n.lln.size() ; i++){
                Node t = (n.lln).get(i);
                if(t == target){
                    return true;
                }
                if(!t.visit){
                    t.visit = true;
                    qu.add(t);
                }
            }
        }
        return false;
    }
}
