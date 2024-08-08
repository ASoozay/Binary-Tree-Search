public class Test implements Comparable<Test> {
    private int value;

    // Constructor
    public Test(int value) {
        this.value = value;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Override compareTo method
    @Override
    public int compareTo(Test other) {
        return Integer.compare(this.value, other.value);
    }

    // Override toString method
    @Override 
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        Test test1 = new Test(10);
        Test test2 = new Test(20);

        // Example of comparing two Test objects
        System.out.println(test1.compareTo(test2)); // Output will be negative since 10 < 20
        System.out.println(test2.compareTo(test1)); // Output will be positive since 20 > 10
        System.out.println(test1.compareTo(test1)); // Output will be 0 since 10 == 10
    }
}
