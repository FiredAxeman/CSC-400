import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Age: " + age;
    }
}

class Queue {
    private Person[] items;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.items = new Person[capacity];
        this.size = 0;
    }

    public void enqueue(Person p) {
        if (size < capacity) {
            items[size] = p;
            size++;
        } else {
            System.out.println("Queue is full.");
        }
    }

    public Person dequeue() {
        if (size == 0) {
            return null;
        }
        Person p = items[0];
        for (int i = 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        items[size - 1] = null;
        size--;
        return p;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public void sortByLastNameDesc() {
        quickSortLastName(0, size - 1);
    }

    private void quickSortLastName(int low, int high) {
        if (low < high) {
            int pi = partitionLastName(low, high);
            quickSortLastName(low, pi - 1);
            quickSortLastName(pi + 1, high);
        }
    }

    private int partitionLastName(int low, int high) {
        Person pivot = items[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items[j].getLastName().compareToIgnoreCase(pivot.getLastName()) > 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    public void sortByAgeDesc() {
        quickSortAge(0, size - 1);
    }

    private void quickSortAge(int low, int high) {
        if (low < high) {
            int pi = partitionAge(low, high);
            quickSortAge(low, pi - 1);
            quickSortAge(pi + 1, high);
        }
    }

    private int partitionAge(int low, int high) {
        Person pivot = items[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items[j].getAge() > pivot.getAge()) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Person temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue myQueue = new Queue(5);

        System.out.println("--- Queue Entry System ---");
        System.out.println("Please enter information for 5 people.");

        for (int i = 0; i < 5; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter first name: ");
            String fname = scanner.nextLine();
            
            System.out.print("Enter last name: ");
            String lname = scanner.nextLine();
            
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            myQueue.enqueue(new Person(fname, lname, age));
        }

        System.out.println("\n==================================");
        System.out.println("Original Queue Contents:");
        System.out.println("==================================");
        myQueue.display();

        System.out.println("\n==================================");
        System.out.println("Queue sorted by Last Name (Descending):");
        System.out.println("==================================");
        myQueue.sortByLastNameDesc();
        myQueue.display();

        System.out.println("\n==================================");
        System.out.println("Queue sorted by Age (Descending):");
        System.out.println("==================================");
        myQueue.sortByAgeDesc();
        myQueue.display();

        scanner.close();
    }
}