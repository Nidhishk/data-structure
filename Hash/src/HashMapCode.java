import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("India", 712);
        hashMap.put("US", 13);
        hashMap.put("Canada", 321);

        ArrayList<String> keys = hashMap.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " -> " + hashMap.get(keys.get(i)));
        }

        hashMap.remove("Canada");
        System.out.println(hashMap.get("Canada"));
    }

    static class HashMap<K, V> {
        public class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;  // Number of Nodes
        private int N;  // Number of bucketss
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bucketsIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketsIndex);   // dataIndex gives location in LinkedList under a buckets

            if (dataIndex == -1) {   // Key doesn't exist
                buckets[bucketsIndex].add(new Node(key, value));
                n++;        // number of node will be added
            } else {    // Key exists
                Node node = buckets[bucketsIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // Re-Hashing
                reHash();
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {
                return null;
            } else {
                return buckets[bucketIndex].get(dataIndex).value;
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {   // Key doesn't exists
                return false;
            } else {    // Key exists
                return true;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if (dataIndex == -1) {   // Key doesn't exists
                return null;
            } else {    // Key exists
                n--;
                return buckets[bucketIndex].remove(dataIndex).value;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> list = buckets[i];
                for (int j = 0; j < list.size(); j++) {
                    Node node = list.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        private void reHash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> list = oldBuckets[i];
                for (int j = 0; j < list.size(); j++) {
                    Node node = list.get(j);
                    put(node.key, node.value);
                }
            }
        }

        private int searchInLinkedList(K key, int bucketsIndex) {
            LinkedList<Node> linkedList = buckets[bucketsIndex];
            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).key == key) {
                    return i;       // dataIndex
                }
            }
            return -1;
        }

        // Bucket Index should be between 0 to N-1
        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N;
        }
    }
}