import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        
        Dog d = new Dog("dog");
        Cat c = new Cat("cat");
        Dog dd = new Dog("dog");
        Cat cc = new Cat("cat");
        Dog ddd = new Dog("dog");
        Cat ccc = new Cat("cat");
        
        animalQueue aq = new animalQueue();
        
        aq.enqueue(d);
        aq.enqueue(c);
        aq.enqueue(dd);
        aq.enqueue(cc);
        aq.enqueue(ddd);
        aq.enqueue(ccc);
        
        System.out.println(aq.dequeueAny().getName());
        System.out.println(aq.dequeueDog().getName());
        System.out.println(aq.dequeueAny().getName());
        System.out.println(aq.dequeueAny().getName());
        System.out.println(aq.dequeueAny().getName());
        System.out.println(aq.dequeueAny().getName());
        
    }
    
    public static class Animal {
        private String name;
        private int order;
        public Animal(String n){
            name = n;
        }
        public void setOrder(int ord){
            order = ord;
        }
        public int getOrder() {
            return order;
        }
        public String getName(){
            return name;
        }
        public boolean isOlder(Animal a) {
            return this.order < a.getOrder();
        }
    }
    
    public static class Dog extends Animal{
        public Dog(String n){
            super(n);
        }
    }
    
    public static class Cat extends Animal{
        public Cat(String n){
            super(n);
        }
    }
    
    public static class animalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;
        public void enqueue(Animal a) {
            a.setOrder(++order);
            if(a instanceof Dog){
                dogs.add((Dog)a);
            }
            else if(a instanceof Cat) {
                cats.add((Cat)a);
            }
        }
        
        public Animal dequeueAny(){
            
            if(dogs.size() == 0){
                return cats.pollFirst();
            }
            if(cats.size() == 0) {
                return dogs.pollFirst();
            }
            if(dogs.size() == 0 && cats.size() == 0){
                return null;
            }
            
            Dog d = dogs.peekFirst();
            Cat c = cats.peekFirst();
            if(d.isOlder(c)){
                return dogs.pollFirst();
            }
            else {
                return cats.pollFirst();
            }
        }
        
        public Dog dequeueDog() {
            return dogs.pollFirst();
        }
        
        public Cat dequeueCat() {
            return cats.pollFirst();
        }
    }
}
