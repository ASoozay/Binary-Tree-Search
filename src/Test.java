public class Test implements Comparable<Test> {
    private int value;

    public Test(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }


    @Override
    public int compareTo(Test other) {
        return Integer.compare(this.value, other.value);
    }


    @Override 
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        Test test1 = new Test(10);
        Test test2 = new Test(20);

        System.out.println(test1.compareTo(test2)); 
        System.out.println(test2.compareTo(test1)); 
        System.out.println(test1.compareTo(test1)); 
    }
}
