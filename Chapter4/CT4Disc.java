public class CT4Disc {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public CT4Disc(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Pushes an element onto the top of the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value; // Increment top, then insert
        System.out.println("Pushed: " + value);
    }

    // Removes and returns the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! The stack is empty.");
            return -1;
        }
        return stackArray[top--]; // Return element, then decrement top
    }

    // Looks at the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stackArray[top];
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Checks if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        CT4Disc myStack = new CT4Disc(5);

        // Demonstrating LIFO behavior
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println("Top element is: " + myStack.peek());

        System.out.println("Popped: " + myStack.pop());
        System.out.println("Popped: " + myStack.pop());
        
        System.out.println("Is stack empty? " + myStack.isEmpty());
    }
}