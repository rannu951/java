import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        animalShelter as = new animalShelter();
        as.enqueue("dog");
        as.enqueue("cat");
        as.enqueue("dog");
        as.enqueue("cat");
        as.enqueue("dog");
        as.enqueue("cat");
        
        
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueDog());
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueAny());
        
        System.out.println(as.dequeueAny());
        System.out.println(as.dequeueAny());
        
        
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
        
        public boolean isEmpty(){
            if(!wms){
                reverseStack();
            }
            return ms2.isEmpty();
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
    
    
    public static class animalShelter {
        myQueue<Integer> mqd,mqc,aldc;
        Integer counter;
        
        public animalShelter() {
            mqd = new myQueue<Integer>();
            mqc = new myQueue<Integer>();
            counter = 0;
        }
        
        public void enqueue(String item){
            if(item == "dog"){
                mqd.add(++counter);
                mqd.add(-1);
                
            }
            else if(item == "cat"){
                mqc.add(++counter);
                mqc.add(-2);
            }
        }
        
        public String dequeueAny(){
            if(mqc.isEmpty() && mqd.isEmpty()){
                return null;
            }
            if(mqc.isEmpty()){
                mqd.remove();
                mqd.remove();
                return "dog";
            }
            if(mqd.isEmpty()){
                mqc.remove();
                mqc.remove();
                return "cat";
            }
            if(mqc.peek() < mqd.peek()){
                mqc.remove();
                mqc.remove();
                return "cat";
            }
            mqd.remove();
            mqd.remove();
            return "dog";
        }
        
        public String dequeueDog() {
            mqd.remove();
            mqd.remove();
            return "dog";
        }
        
        public String dequeueCat() {
            mqc.remove();
            mqc.remove();
            return "cat";
        }
    }
    
    
}
