public class StackDemo {
    // store data value in a node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // keep a track of nodes in the stack
    public static class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }
        // prepending a new item at the top of the stack
        public void prepend(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.next = head;
                head = newNode;
            }

        }
        // removing the last top item from the top of the stack
        // LIFO
        public void removeAfter(Node curNode) {
            if (curNode == null && head != null) {
                Node sucNode = head.next;
                head = sucNode;

                if (sucNode == null) {
                    tail = null;
                }
            }
        }
        // getting a head data value for peek
        public int getHeadData() {
            int node = head.data;
            return node;
        }
        // printing nodes in the stack
        public void printList() {
            Node curNode = head;
            while (curNode != null) {
                System.out.print(curNode.data + " ");
                curNode = curNode.next;
            }
        }
    }

    // stack class to manipulate items
    public static class Stack {

        private LinkedList list;
        // chaining with the class to keep a track of the items
        public Stack() {
            list = new LinkedList();
        }

        // pushing on the top of the stack
        public void push(int newData) {
            Node newNode = new Node(newData);
            list.prepend(newNode);
        }

        // popping the last top item out of the stack
        // LIFO
        public int pop() {
            int data = list.getHeadData();
            list.removeAfter(null);

            return data;
        }
        // printing the items in the stack
        public void print() {
            list.printList();
        }
    }

    public static void main(String[] args) {
        // Initialize a new Stack and add numbers
        Stack numStack = new Stack();
        //
    }

}