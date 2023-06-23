public class ArrayQueue {
    private int[] list;
    private int allocatedSize;
    private int frontIndex;
    private int maxLength;
    private int length;

    public ArrayQueue() {
        this(-1);
    }

    public ArrayQueue(int maxLength) {
        this.allocatedSize = (0 == maxLength) ? 0 : 1;
        this.list = new int[allocatedSize];
        this.frontIndex = 0;
        this.maxLength = maxLength;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public boolean enqueue(int newItem) {
        if (length == maxLength) {
            return false;
        }
        if (length == allocatedSize) {
            resize();
        }
        int itemIndex = (frontIndex + length) % allocatedSize;
        list[itemIndex] = newItem;
        ++length;
        return true;
    }
    public int dequeue() {
        int removedItem = list[frontIndex];
        --length;
        frontIndex = (frontIndex + 1) % list.length;

        return removedItem;
    }
    public void resize() {
        int newSize = allocatedSize * 2;
        if (maxLength >= 0 && newSize > maxLength) {
            newSize = maxLength;
        }
        int[] newList = new int[newSize];
        for (int i = 0; i < list.length; ++i) {
            int itemIndex = (frontIndex + i) % list.length;
            newList[i] = list[itemIndex];
        }
        list = newList;
        allocatedSize = newSize;
        frontIndex = 0;
    }
}