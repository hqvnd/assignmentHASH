public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        // the elements
        tree.put(50, "Root");
        tree.put(30, "Left");
        tree.put(70, "Right");
        tree.put(20, "Left.Left");
        tree.put(40, "Left.Right");
        tree.put(60, "Right.Left");
        tree.put(80, "Right.Right");

        System.out.println("size: " + tree.size());
        //...
        System.out.println("val(40): " + tree.get(40));
        System.out.println("val(90): " + tree.get(90));

        // Test in-order traversal
        System.out.println("in-order traversal:");
        for (var elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

//        // delete
//        System.out.println("\nafter deleting key 30:");
//        tree.delete(30);
//        System.out.println("size: " + tree.size());
//
//        // Test in-order traversal after deletion
//        System.out.println("in-order traversal after deletion:");
//        for (var elem : tree.iterator()) {
//            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
//        }
    }
}