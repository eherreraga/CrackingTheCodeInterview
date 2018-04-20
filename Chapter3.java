import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Chapter3{

    Queue shelterQueue;
    
    public void main(String[]args){

        shelterQueue = new PriorityQueue<Animal>();
        
        shelterQueue.add("dog");
        shelterQueue.add("cat");
        shelterQueue.add("cat");

        System.out.println(dequeueCat().animalType);

    }

    /**Problem 3.4
     * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
     */
    public MyStack queueUsingStack(MyStack stack){
        MyStack newStack = new MyStack<>();
        newStack.push(stack.pop());
        return newStack;
    }

    /**Problem 3.6
     * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly" rst in,  rst out" basis.
     *  People must adopt either the"oldest" (based on arrival time) of all animals at the shelter,
     *  or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
     *  They cannot select which speci c animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
     *  You may use the built-in Linked list data structure.
     */
    public Animal dequeueDog(){
        Queue sQueue = new PriorityQueue<>();
        Animal dogAdopted;
        while(!(shelterQueue.isEmpty())){
            if(dogAdopted == null && dogAdopted.animalType == "dog")
                dogAdopted = shelterQueue.poll();
            sQueue.add(shelterQueue.poll());
            shelterQueue = sQueue;
        }
        return dogAdopted;
    }

    public Animal dequeueCat(){
        Queue sQueue = new PriorityQueue<>();
        Animal catAdopted;
        while(!(shelterQueue.isEmpty())){
            if(catAdopted == null && catAdopted.animalType == "cat")
                catAdopted = shelterQueue.poll();
            sQueue.add(shelterQueue.poll());
            shelterQueue = sQueue;
        }
        return catAdopted;
    }
    public class Animal{
        String animalType;
        public Animal(String type){
            animalType = type;
        }
    }

    private class MyStack<T>{
        private class StackNode<T>{

            private T data;
            private StackNode<T> next;

            public StackNode(T data){
                this.data = data;
            }
        }

        private StackNode<T> top;

        public T pop(){
            if(top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item){
            StackNode<T> t = new StackNode(item);
            t.next = top;
            top = t;
        }

        public T peek(){
            if(top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty(){
            return top == null;
        }
    }

}
