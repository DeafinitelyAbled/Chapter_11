public class ArrayBasedQueue {
    public static void main(String[] args) {
        // Make two queues, one bounded to 4 items and the other unbounded
        ArrayQueue boundedQueue = new ArrayQueue(4);
        ArrayQueue unboundedQueue = new ArrayQueue();

        // Enqueue 8 items in each
        System.out.println("Enqueueing values 1 through 8 to each queue");
        for (int i = 1; i <= 8; i++) {
            boundedQueue.enqueue(i);
            unboundedQueue.enqueue(i);
        }

        // Dequeue two items from each queue
        System.out.println("Dequeuing twice");
        for (int i = 0; i < 2; i++) {
            System.out.print("  Dequeued " + boundedQueue.dequeue());
            System.out.println(" from bounded queue");
            System.out.print("  Dequeued " + unboundedQueue.dequeue());
            System.out.println(" from unbounded queue");
        }

        // Enqueue 4 more items
        System.out.println("Enqueueing values: 10, 20, 30 and 40");
        for (int i = 10; i <= 40; i+=10) {
            boundedQueue.enqueue(i);
            unboundedQueue.enqueue(i);
        }

        // print contents of each queue
        System.out.print("Bounded queue (maxLength=");
        System.out.print(boundedQueue.getMaxLength());
        System.out.print(") contents:");
        while (boundedQueue.getLength() > 0) {
            System.out.print("  " + boundedQueue.dequeue());
        }
        System.out.print("\nUnbounded queue contents:");
        while (unboundedQueue.getLength() > 0) {
            System.out.print("  " + unboundedQueue.dequeue());
        }
    }

}