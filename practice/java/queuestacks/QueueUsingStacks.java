package practice.java.queuestacks;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void shiftStacks(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public void enqueue(int num){
        stack1.push(num);
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalArgumentException();
        shiftStacks();
        return stack2.pop();
    }

    public int peek(){
        if(isEmpty()) throw new IllegalArgumentException();
        shiftStacks();
        return stack2.peek();
    }

    public static void main(String[] args){
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek()); //10
        System.out.println(queue.dequeue()); //10
        System.out.println(queue.peek()); //20

    }
}
