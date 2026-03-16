import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

class CustomLinkedList {
    private Node head;

    // Node inner class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Iterator inner class
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next; // Move to the next node
            return data;
        }
    }

    /**
     * Inserts a new node with the given data at the end of the list.
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }
        
        // Otherwise, traverse to the end of the list and append
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Deletes the first occurrence of a node with the given data.
     */
    public void delete(int data) {
        // If the list is empty, there is nothing to delete
        if (head == null) {
            return;
        }
        
        // If the head node itself holds the data to be deleted
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        // Traverse the list to find the node, keeping track of the previous node
        Node current = head;
        Node previous = null;
        
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }
        
        // If the data was not found in the list
        if (current == null) {
            return;
        }
        
        // Unlink the node from the linked list
        previous.next = current.next;
    }

    /**
     * Returns an iterator for traversing the linked list.
     */
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }
}

public class CT5 {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        System.out.println("--- Hardcoded Insertion Test ---");
        // Insert elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        // Delete an element
        linkedList.delete(2);
        // Iterate and display elements using the custom iterator
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");

        System.out.println("--- Text File Reading Test ---");
        CustomLinkedList fileList = new CustomLinkedList();
        
        // Read integer data from a text file
        try {
            //File file = new File("C:\\Users\\HDD\\OneDrive\\Documents\\Code Repository\\CSC-400\\Chapter6\\data.txt");
            File file = new File("data.txt"); //note: create a file named "data.txt" in the working directory with some integer values for testing
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                fileList.insert(value);
            }
            scanner.close();
            
            System.out.println("Elements read from file:");
            Iterator<Integer> fileIterator = fileList.iterator();
            while (fileIterator.hasNext()) {
                System.out.print(fileIterator.next() + " ");
            }
            System.out.println();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please create 'data.txt' in the working directory to test file reading.");
        }
    }
}