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
     * @param item The element to check for.
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

    // ---------------------------------------------------------
    // NEW METHODS FOR ASSIGNMENT 2
    // ---------------------------------------------------------

    /**
     * Returns the total number of elements in the bag.
     * @return The size of the bag.
     */
    public int size() {
        return items.size();
    }

    /**
     * Merges the elements of another bag into this bag.
     * @param otherBag The bag whose elements are to be added.
     */
    public void merge(Bag<T> otherBag) {
        if (otherBag != null && otherBag.items != null) {
            this.items.addAll(otherBag.items);
        }
    }

    /**
     * Creates a new bag containing only unique elements from the current bag.
     * @return A new Bag instance with no duplicates.
     */
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();
        for (T item : items) {
            // Only add the item if the new bag doesn't already have it
            if (!distinctBag.contains(item)) {
                distinctBag.add(item);
            }
        }
        return distinctBag;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

public class CT2 {
    public static void main(String[] args) {
        System.out.println("--- Bag Assignment 2 ---");

        // 1. Create two instances of the Bag class.
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        // 2. Add elements to each bag, including duplicates.
        System.out.println("\n1. Populating Bags...");
        
        // Bag 1: [A, B, A]
        bag1.add("A");
        bag1.add("B");
        bag1.add("A");
        System.out.println("Bag 1: " + bag1);

        // Bag 2: [B, C, C]
        bag2.add("B");
        bag2.add("C");
        bag2.add("C");
        System.out.println("Bag 2: " + bag2);

        // 3. Print the size of each bag using the size method.
        System.out.println("\n2. Checking Sizes:");
        System.out.println("Size of Bag 1: " + bag1.size());
        System.out.println("Size of Bag 2: " + bag2.size());

        // 4. Merge the two bags together using the merge method.
        System.out.println("\n3. Merging Bag 2 into Bag 1...");
        bag1.merge(bag2);

        // 5. Print the merged bag contents.
        // Expected: [A, B, A, B, C, C]
        System.out.println("Merged Bag 1 Contents: " + bag1);
        System.out.println("New Size of Bag 1: " + bag1.size());

        // 6. Create a new bag containing only the distinct elements.
        System.out.println("\n4. Creating Distinct Bag from Merged Bag 1...");
        Bag<String> distinctBag = bag1.distinct();

        // 7. Print the distinct bag contents.
        // Expected: [A, B, C] (Order depends on first occurrence)
        System.out.println("Distinct Bag Contents: " + distinctBag);
        System.out.println("Size of Distinct Bag: " + distinctBag.size());
    }
}