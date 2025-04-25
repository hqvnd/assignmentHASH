
// custom class
class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Initial hashCode implementation
    @Override
    public int hashCode() {
        // Bad hash function that will cause collisions
        return id % 10;
    }

    // Improved hashCode implementation for uniform distribution
    /*
    @Override
    public int hashCode() {
        // Better hash function
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && (name == null ? that.name == null : name.equals(that.name));
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}

// Student class for values
class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
}

// test
public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add random elements
        for (int i = 0; i < 10000; i++) {
            int randomId = (int) (Math.random() * 1000000);
            String randomName = "Name" + randomId;
            MyTestingClass key = new MyTestingClass(randomId, randomName);
            Student value = new Student("Student" + i, Math.random() * 4.0);
            table.put(key, value);
        }

        // number of elements in each bucket
        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }

        System.out.println("Total elements: " + table.getSize());
    }
}