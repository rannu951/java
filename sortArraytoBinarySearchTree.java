import java.util.*;
import java.lang.Math;
public class MyClass {
    public static void main(String args[]) {
        
        int[] ai = {1,2,3,4,5,6};
        
        
        Node n = makeBinarySearchTree(ai,0,ai.length-1);
        System.out.println(((n.name)));
        System.out.println(((n.lln.get(0).name)));
        System.out.println(((n.lln.get(1).name)));
        
    }
    
    public static class Node {
        public String name;
        public LinkedList<Node> lln = new LinkedList<Node>();
        public boolean visit = false;
    }
    
    static Node makeBinarySearchTree(int[] ai, int f, int l){
        
        if(l<f){
            return null;
        }
        
        Node n = new Node();
        if(l==f){
            n.name = String.valueOf(ai[l]);
            return n;
        }
        
        int middle = (int) (Math.ceil(((l+f)/2.0)));
        
        n.name = String.valueOf(ai[middle]);
        n.lln.add(makeBinarySearchTree(ai,f,middle-1));
        if(l-f>1){
            n.lln.add(makeBinarySearchTree(ai,middle+1,l)); 
        }
        return n;
    }
    
}
