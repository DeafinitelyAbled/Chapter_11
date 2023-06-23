public class ArrayStack {
    private int allocationSize;
    private int[] list;
    int maxLength;
    int length;

    public ArrayStack() {
        this(-1);
    }

    public ArrayStack(int maximumLength) {
        allocationSize = 1;
        list = new int[allocationSize];
        maxLength = maximumLength;
        length = 0;
    }
    public int getLength() {
        return length;
    }
    public int getMaxLength() {
        return maxLength;
    }
    public boolean push(int newItem) {
        if (length == maxLength) {
            return false;
        }
        if (length == allocationSize) {
            resize();
        }
        list[length] = newItem;
        ++length;
        return true;
    }
    public int pop() {
        --length;
        return list[length];
    }
    public void resize() {
        int newSize = allocationSize * 2;
        int[] newList = new int[newSize];

        for (int i = 0; i < length; ++i) {
            newList[i] = list[i];
        }

        list = newList;
        allocationSize = newSize;
    }

}