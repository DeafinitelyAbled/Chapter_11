public class ArrayBasedStack {

    public static void main(String[] args) {
        // Make two stacks, one bounded to 4 items and the other unbounded
        ArrayStack boundedStack = new ArrayStack(4);
        ArrayStack unboundedStack = new ArrayStack();

        // Push 8 items to each
        System.out.println("Pushing values 1 through 8 to each stack");
        for (int i = 1; i <= 8; i++) {
            boundedStack.push(i);
            unboundedStack.push(i);
        }

        // Pop two items off each stack
        System.out.println("Popping twice");
        for (int i = 0; i < 2; i++) {
            boundedStack.pop();
            unboundedStack.pop();
        }

        // Push 4 more items onto each stack
        System.out.println("Pushing values to each stack: 10, 20, 30 and 40");
        for (int i = 10; i <= 40; i+=10) {
            boundedStack.push(i);
            unboundedStack.push(i);
        }

        // Display contents of each stack
        System.out.print("Bounded stack (maxLength=");
        System.out.print(boundedStack.getMaxLength());
        System.out.print(") contents:");
        while (boundedStack.getLength() > 0) {
            System.out.print("  " + boundedStack.pop());
        }
        System.out.print("\nUnbounded stack contents:");
        while (unboundedStack.getLength() > 0) {
            System.out.print("  " + unboundedStack.pop());
        }
    }

}