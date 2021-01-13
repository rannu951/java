import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        myStack<Integer> ms = new myStack<Integer>();
        ms.push(2);
        ms.push(3);
        ms.push(5);
        ms.push(1);
        ms.push(4);
        
        sortStack(ms,5);
        
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        
        
    }
    
    public static void sortStack(myStack<Integer> ms, double stackSize) {
        
        if(stackSize == 1){
            return;
        }
        
        myStack<Integer> s1 = new myStack<Integer>();
        myStack<Integer> s2 = new myStack<Integer>();
        
        for(int i=0 ; i<Math.ceil(stackSize/2) ; i++){
            s1.push(ms.pop());
        }
        for(double i=Math.ceil(stackSize/2) ; i<stackSize ; i++){
            s2.push(ms.pop());
        }
        
        sortStack(s1,Math.ceil(stackSize/2));
        sortStack(s2,Math.floor(stackSize/2));
        
        myStack<Integer> ts = new myStack<Integer>();
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            ts.push(s1.peek() < s2.peek() ? s1.pop() : s2.pop());    
        }
        
        while(!s1.isEmpty()){
            ts.push(s1.pop());   
        }
        
        while(!s2.isEmpty()){
            ts.push(s2.pop());
        }
        
        while(!ts.isEmpty()){
            ms.push(ts.pop());
        }
        
    }
    
    
    public static class myStack<T> {
        
        private class stackNode<T> {
            private T data;
            private stackNode<T> next;
            public stackNode(T data){
                this.data = data;
            }
        }
        
        private stackNode<T> top;
        public T pop() {
            if (top == null) return null;
            T item = top.data;
            top = top.next;
            return item;
            
        }
        public void push(T item){
            stackNode<T> t = new stackNode<T>(item);
            t.next = top;
            top = t;
        }
        public T peek() {
            if (top == null)    return null;        
            return top.data;
        }
        public boolean isEmpty() {
            return top == null;
        }
    }
}
