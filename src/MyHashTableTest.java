import java.util.Objects;

// Custom class for testing
class MyTestingClass {
    private final int id;
    private final String name;

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
        return id == that.id && (Objects.equals(name, that.name));
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}

// Student class for values
class Student {
    private final String name;
    private final double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
}

// Testing class
public class MyHashTableTest {
    public static void main(String[] args) {
        // Create hash table
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add 10000 random elements
        for (int i = 0; i < 10000; i++) {
            int randomId = (int) (Math.random() * 1000000); //
            String randomName = "Name" + randomId;
            MyTestingClass key = new MyTestingClass(randomId, randomName);
            Student value = new Student("Student" + i, Math.random() * 4.0);
            table.put(key, value);
        }

        // the poor distribution for the compatibility of test class, uncomment the code below
        // and run again to see the improvement.
    }
}
