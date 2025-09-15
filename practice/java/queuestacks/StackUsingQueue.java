package practice.java.queuestacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue1 = new LinkedList<>();

    public void push(int num){
        queue1.add(num);
        int size = queue1.size();
        for(int i =0; i<size-1; i++){
            queue1.add(queue1.remove());
        }
    }

    public int pop(){
        if(queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.remove();
    }

    public int peek(){
        if(queue1.isEmpty()) throw new RuntimeException("Stack is empty");
        return queue1.peek();
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }

    public static void main(String[] args){
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); //30  LIFO
        System.out.println(stack.pop()); //30
        System.out.println(stack.peek()); //20
    }
}
