import java.util.LinkedList;

class SimpleQueue {
    // We use a LinkedList internally to easily manage the front and rear
    private LinkedList<String> items;

    public SimpleQueue() {
        items = new LinkedList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void enqueue(String item) {
        // Add items to the end (rear) of the queue
        items.addLast(item);
        System.out.println("Enqueued: '" + item + "'");
    }

    public String dequeue() {
        // Remove and return the first item from the front of the queue
        if (isEmpty()) {
            return "Error: The queue is empty!";
        }
        return items.removeFirst();
    }

    public void display() {
        // Display the current state of the queue
        System.out.println("Current Queue status: " + items);
        System.out.println("-------------------------");
    }
}

public class CT8Disc {
    public static void main(String[] args) {
        System.out.println("--- Starting Queue Program ---\n");

        // 1. Create the Queue
        SimpleQueue myQueue = new SimpleQueue();

        // 2. Enqueue (add) some items
        myQueue.enqueue("Customer A");
        myQueue.enqueue("Customer B");
        myQueue.enqueue("Customer C");
        myQueue.display();

        // 3. Dequeue (remove) an item (Should be Customer A - FIFO)
        String served = myQueue.dequeue();
        System.out.println("Served and dequeued: '" + served + "'");
        myQueue.display();

        // 4. Enqueue another item
        myQueue.enqueue("Customer D");
        myQueue.display();
    }
}