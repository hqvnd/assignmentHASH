public class MyHashTable<K, V> {
    private static class HashNode<K, V> {
        private final K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private final HashNode<K, V>[] chainArray; // or Object[]
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    //...
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    //...
    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        // bucket = null
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
            size++;
            return;
        }

        // key already exist
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                // if exists --> update value
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        // no key = + size at the chain end
        prev.next = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // returns null if not found
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        // Empty bucket
        if (current == null) {
            return null;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
}