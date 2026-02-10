import java.util.ArrayList;
import java.util.List;
class Bag<T> {
    
    // Internal storage for the bag elements
    private List<T> items;

    /**
     * Constructor: Initializes the empty bag.
     */
    public Bag() {
        this.items = new ArrayList<>();
    }
    public void add(T item) {
        items.add(item);
        // Explanation: We simply append to the list. 
        // Bags allows duplicates, so no checking is required.
    }

    public void remove(T item) {
        // Explanation: The ArrayList remove(Object) method removes the 
        // first occurrence of the specified element it finds.
        items.remove(item); 
    }

    /**
     * Checks if the bag contains the specified item.
     * * @param item The element to check for.
     * @return true if the item exists, false otherwise.
     */
    public boolean contains(T item) {
        return items.contains(item);
    }
    public int count(T item) {
        int count = 0;
        for (T currentItem : items) {
            if (currentItem.equals(item)) {
                count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        return items.toString();
    }
}
public class CT1 {
    public static void main(String[] args) {
        System.out.println("Creating Bag of Fruits...");
        Bag<String> fruitBag = new Bag<>();
        System.out.println("Adding: Apple, Banana, Orange, Apple, Apple");
        fruitBag.add("Apple");
        fruitBag.add("Banana");
        fruitBag.add("Orange");
        fruitBag.add("Apple"); // Duplicate 1
        fruitBag.add("Apple"); // Duplicate 2
        //Print the bag contents.
        System.out.println("Current Bag Contents: " + fruitBag);
        //Test the contains method for a few elements.
        System.out.println("\nTesting Contains: ");
        System.out.println("Contains 'Banana'? " + fruitBag.contains("Banana"));
        System.out.println("Contains 'Grape'? " + fruitBag.contains("Grape"));
        // Test the count method for a few elements.
        System.out.println("\nTesting Count: ");
        System.out.println("Count of 'Apple': " + fruitBag.count("Apple"));
        System.out.println("Count of 'Orange': " + fruitBag.count("Orange"));
        System.out.println("Count of 'Grape': " + fruitBag.count("Grape"));
        // Remove an element from the bag.
        System.out.println("\n--- Removing one 'Apple' ---");
        fruitBag.remove("Apple");
        // Print the bag contents again.
        System.out.println("Bag Contents after removal: " + fruitBag);
        // Test the contains method for the removed element.
        // (It should still be true because we had duplicates)
        System.out.println("Contains 'Apple'? " + fruitBag.contains("Apple"));
        // Test the count method for the removed element.
        // (The count should decrease by 1)
        System.out.println("Count of 'Apple': " + fruitBag.count("Apple"));
        // Removing the remaining Apples to test full removal
        System.out.println("\n--- Removing remaining 'Apple' instances ---");
        fruitBag.remove("Apple");
        fruitBag.remove("Apple");
        System.out.println("Bag Contents: " + fruitBag);
        System.out.println("Contains 'Apple'? " + fruitBag.contains("Apple"));
    }
}