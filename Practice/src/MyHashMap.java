import java.util.Arrays;

public class MyHashMap<K, V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    //static final variable are global constants
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        this.array = (Node<K, V>[])(new Node[capacity]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        this.size = 0;
    }

    private boolean equalsValue(V v1, V v2) {
//        if (v1 == null && v2 == null) {
//            return true;
//        }
//        if (v1 == null || v2 == null) {
//            return false;
//        }
//        return v1.equals(v2);
        return v1 == v2 || v1 != null && v1.equals(v2);
    }

    //O(n), traverse the whole array, and traverse each of the linked list in the array.
    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        //guarantee non-negative
        return key.hashCode() & 0x7FFFFFFF;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsKey(K k1, K k2) {
//        if (k1 == null && k2 == null) {
//            return true;
//        }
//        if (k1 == null || k2 == null) {
//            return false;
//        }
//        return k1.equals(k2);
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        //new double size array
        Node<K, V>[] newarray = (Node<K, V>[])(new Node[size * 2]);
        int newsize = 0;
        //for each node in the old array, do the put() operation to the new larger array.
        for (Node<K, V> node : array) {
            while (node != null) {
                K insetKey = node.key;
                V insetValue = node.value;
                //calculate new index
                int index = node.key.hashCode() % newarray.length;
                Node<K, V> head = newarray[index];
                Node<K, V> next = node.next;
                node.next = head;
                newarray[index] = node;
                node = next;
                newsize++;
            }
        }
        array = newarray;
        size = newsize;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> dummyHead = new Node(0, 0);
        dummyHead.next = head;
        Node<K, V> prev = dummyHead;
        while (head != null) {
            if (equalsKey(head.key, key)) {
                V result = head.value;
                prev.next = head.next;
                size--;
                return result;
            }
            head = head.next;
        }
        return null;
    }
}
