package dataStructures.hashing_java;

// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Objects;


// A node of chains
class HashNode1<K, V> {
    K key;
    V value;
    final int hashCode;

    // Reference to next node
    HashNode1<K, V> next;

    // Constructor
    public HashNode1(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

// Class to represent entire hash table
class Map<K, V> {
    // bucketArray is used to store array of chains
    private ArrayList<HashNode1<K, V> > bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public Map()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    private final int hashCode (K key) {
        return Objects.hashCode(key);
    }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() coule be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        // Get head of chain
        HashNode1<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode1<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    // Returns value for a key
    public V get(K key)
    {

        if (key instanceof java.lang.String){

            ((java.lang.String) key).trim() ;
        }
        // Find head of chain for given key

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode1<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            System.out.print("( "+head.value+") ");
            head= head.next ;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode1<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.next==null ){
                HashNode1<K, V> newNode = new HashNode1<K, V>(key, value, hashCode);
                head.next = newNode;

                return;
            }
            head=head.next ;


        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode1<K, V> newNode
                = new HashNode1<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode1<K, V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode1<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

     ArrayList[] adjacents ;
     public void any(){
        adjacents = new ArrayList[2] ;
        for (int i=0 ; i<10;i++){


            adjacents[i] = new ArrayList() ;
        }
     }
    // Driver method to JustTry.JustTry.test Map class
    public static void main(String[] args)
    {
         Map<java.lang.String,Integer>map =new Map<>();
         map.add("this",22);
        map.add("rt",12);
        map.add("this",22);
        map.add("fg",43);

        map.get("fg ");
    }
}
