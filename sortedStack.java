import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        sortStack<Integer> ss = new sortStack<Integer>();
        ss.push(1);
        ss.push(2);

        
        System.out.println(ss.peek());
        System.out.println(ss.pop());
        
        ss.push(3);
        ss.push(4);
        
        System.out.println(ss.peek());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
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
    
    public static class sortStack<T> {
        myStack<T> tStack, sStack;
        public sortStack() {
            tStack = new myStack<T>();
            sStack = new myStack<T>();
        }
        
        public void push(T item){
            if(!(sStack.isEmpty())){
                while(!(sStack.isEmpty()) && (Integer)sStack.peek() < (Integer)item){
                    tStack.push(sStack.pop());
                }                
            }
            sStack.push(item);
            while(!tStack.isEmpty()){
                sStack.push(tStack.pop());
            }
        }
        
        public T pop() {
            return sStack.pop();
        }
        
        public T peek() {
            return sStack.peek();
        }
    }
    
}
