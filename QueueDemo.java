public class QueueDemo {
    // store the data value in a node
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    // keep track of nodes in the queue
    public static class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        // append the node at the end of the line
        public void append(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }

        }

        // remove a head node; front queue turn has come
        public void removeAfter(Node curNode) {
            if (curNode == null && head != null) {
                Node sucNode = head.next;
                head = sucNode;

                if (sucNode == null) {
                    tail = null;
                }
            }
        }
        // get data value of the front queue
        public int getHeadData() {
            int node = head.data;
            return node;
        }
        // printList
        public void printList() {
            Node curNode = head;
            while (curNode != null) {
                System.out.print(curNode.data + " ");
                curNode = curNode.next;
            }
        }
    }
    // queue class to manipulate the lines
    public static class Queue {

        private LinkedList list;

        public Queue() {
            list = new LinkedList();
        }
        // pushing at the end of the queue line
        public void enqueue(int newData) {
            Node newNode = new Node(newData);
            list.append(newNode);
        }
        // popping out the front of the queue line
        public int dequeue() {
            int data = list.getHeadData();
            list.removeAfter(null);

            return data;
        }
        // printing the queue nodes
        public void print() {
            list.printList();
        }
    }

    public static void main(String[] args) {
        // Initialize a new Queue and add numbers
        Queue numQueue = new Queue();
        //
    }

}