import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        myQueue<Integer> mq = new myQueue<Integer>();
        mq.add(1);
        mq.add(2);

        
        System.out.println(mq.peek());
        System.out.println(mq.remove());
        
        mq.add(3);
        mq.add(4);
        
        System.out.println(mq.peek());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        
        System.out.println(mq.peek());
        System.out.println(mq.remove());
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
    
    public static class myQueue<T> {
        myStack<T> ms1,ms2;
        boolean wms;
        
        public myQueue() {
            ms1 = new myStack<T>();
            ms2 = new myStack<T>();
            wms = false;
        }
        
        public void add(T item){
            if(wms){
                reverseStack();
            }
            ms1.push(item);
        }
        
        public T remove(){
            if(!wms){
                reverseStack();
            }
            return ms2.pop();
        }
        
        public T peek(){
            if(!wms){
                reverseStack();
            }
            return ms2.peek();
        }
        
        private void reverseStack(){
            if(!wms){
                while(!ms1.isEmpty()){
                    ms2.push(ms1.pop());
                    wms = true;
                }
            }
            else{
                while(!ms2.isEmpty()){
                    ms1.push(ms2.pop());
                    wms = false;
                }
            }
        }
    }   
}
