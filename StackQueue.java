import java.util.Random;

public class StackQueue {

    public static class Node {
        Object data;
        Node next;

        public Node(Object newNode) {
            data = newNode;
            next = null;
        }
    }

    public static class LinkedList {
        Node first;
        Node last;
        int length;

        public LinkedList() {
            this.first = null;
            this.last = null;
            length = 0;
        }

        // appending an item at the back of the list
        public void append(Node newNode) {
            if (first == null) {
                first = newNode;
                last = newNode;
            }
            else {
                last.next = newNode;
                last = newNode;
            }
            ++ length;
        }

        // prepending an item at the front of the list
        public void prepend(Node newNode) {
            if (first == null) {
                first = newNode;
                last = newNode;
            }
            else {
                newNode.next = first;
                first = newNode;
            }
            ++length;
        }

        // inserting a new node after the specified node in the list
        public void insertAfter(Node curNode, Node newNode) {
            if (first == null) {
                first = newNode;
                last = newNode;
            }
            else if (curNode == last){
                last.next = newNode;
                last = newNode;
            }
            else {
                newNode.next = curNode.next;
                curNode.next = newNode;
            }
            ++length;
        }

        // removing an item from the list and returning the item
        public Object removeAfter(Node curNode) {
            Object data = getHeadData();

            // special-case to remove a the front
            if (curNode == null && first != null) {
                Node sucNode = first.next;
                first = sucNode;

                if (sucNode == null) {
                    last = null;
                }
            }
            else if (curNode.next != null) {
                Node sucNode = curNode.next.next;
                curNode.next = sucNode;

                if (sucNode == null) {
                    last = curNode;
                }
            }
            --length;
            return data;
        }

        // checking whether the list is empty or not
        public boolean isEmpty() {
            if (length == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        // getting a front data for a peek or before removing it
        public Object getHeadData() {
            return first.data;
        }

        // get a number of items in the list
        public int getLength() {
            return length;
        }

        // printing information
        public void printInfo() {
            Node node = first;

            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }

    public static class Stack {
        LinkedList list;

        public Stack() {
            list = new LinkedList();
        }

        // pushing a new item at the top of the stack
        public void push(Object newItem) {
            Node newNode = new Node(newItem);
            list.prepend(newNode);
        }

        // popping the last item at the top of the stack
        public Object pop() {
            Object data = list.getHeadData();
            list.removeAfter(null);

            return data;
        }

        // checking the top item of the stack
        public Object peek() {
            return list.getHeadData();
        }

        // checking whether the list is empty or not
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // get a number of items in the stack
        public int getLength() {
            return list.getLength();
        }

        // printing information
        public void print() {
            list.printInfo();
        }
    }

    public static class Queue {
        LinkedList list;

        public Queue() {
            list = new LinkedList();
        }

        // pushing a new item at the end of the queue
        public void enqueue(Object newItem) {
            Node newNode = new Node(newItem);
            list.append(newNode);
        }

        // dequeueing the item at the front of the queue
        public Object dequeue() {
            Object data = list.getHeadData();
            list.removeAfter(null);

            return data;
        }

        // checking the front item of the queue
        public Object peek() {
            return list.getHeadData();
        }

        // checking whether the list is empty or not
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // get a number of items in the queue
        public int getLength() {
            return list.getLength();
        }

        // printing information
        public void print() {
            list.printInfo();
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Queue queue = new Queue();
        Stack stack = new Stack();

        System.out.println("This is both stack and queue project.\n");

        // Stack
        stack.push(rand.nextInt(100));	stack.push(rand.nextInt(100));
        stack.push(rand.nextInt(100));	stack.push(rand.nextInt(100));
        stack.push(rand.nextInt(100));
        System.out.print("Pushing " + stack.getLength() + " random numbers: ");
        stack.print();

        System.out.println("\nLet's see what a surprise number is: " + stack.pop());
        System.out.println("Allow me to take two numbers out: " + stack.pop() + " " + stack.pop());
        System.out.println("Let's see what's left on the top: " + stack.peek());
        stack.pop(); stack.pop();
        System.out.println("I can't feel a thing in the bucket. Is it empty? " + stack.isEmpty());


        // Queue
        queue.enqueue(rand.nextInt(100));  queue.enqueue(rand.nextInt(100));
        queue.enqueue(rand.nextInt(100));  queue.enqueue(rand.nextInt(100));
        queue.enqueue(rand.nextInt(100));
        System.out.print("\nEnqueueing " + queue.getLength() + " random numbers: ");
        queue.print();

        System.out.println("\nDequeueing the frong item of the queue: " + queue.dequeue());
        System.out.println("Now what next item? Let's peek: " + queue.peek());
        System.out.println("How many items are in the line? Let's count: " + queue.getLength());
        queue.dequeue(); queue.dequeue(); queue.dequeue();

        System.out.println("Ugh, it was a lot of work to serve clients. Empty line now? " + queue.isEmpty());
        System.out.println("Oh my god! I gotta resign from this job and stick with coding!");




    }

}
