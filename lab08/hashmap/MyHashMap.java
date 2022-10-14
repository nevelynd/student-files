package hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {



    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();

    }


    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private Node node;
    private int size;
    private LinkedList Bucket;
    private double loadfactor;


    /* Constant Variables */
    private static final int Defaultintsize = 16;
    private static final double defaultloadfactor = 0.75;

    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        this(Defaultintsize, defaultloadfactor);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, defaultloadfactor);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        buckets = createTable(initialSize);
        size = 0;
        loadfactor = maxLoad;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return new Collection[tableSize];


    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!




    /** Removes all of the mappings from this map. */
    public void clear() {
        buckets = createTable(Defaultintsize);
        size = 0;

    }

    private int findbucket(K key) {
        return findbucket(key, buckets.length);
    }

    private int findbucket(K key, int numofbuckets) {
        return Math.floorMod(key.hashCode(), numofbuckets);
    }
    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        Node node = getNode(key);
        return node != null;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node getNode(K key) {
        int idx = findbucket(key);
        Collection<Node> bucketlist  = buckets[idx];
        if (bucketlist != null) {
            for (Node node : bucketlist) {
                if (node.key.equals(key)) {
                    return node;
                }
            }
        }
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        if ((double) size / buckets.length > loadfactor) {
            rebucket(buckets.length * 2);
        }
        size++;
        int idx = findbucket(key);
        Collection<Node> bucketlist = buckets[idx];
        if (bucketlist == null) {
            bucketlist = createBucket();
            buckets[idx] = bucketlist;
        }
        bucketlist.add(createNode(key, value));
    }



    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Collection<Node> c : this.buckets) {
            if (c==null) {
                continue;
            }
            for (Node n : c) {
                result.add(n.key);
            }
        }
        return result;
    }


    private void rebucket(int targetSize) {
        Collection<Node>[] newbuckets  = createTable(targetSize);
        for (Collection<Node> c : this.buckets) {
            if (c == null) {
                continue;
            }
            for (Node n : c) {
                K key = n.key;
                int idx = findbucket(key, newbuckets.length);
                if (newbuckets[idx] == null) {
                    newbuckets[idx] = createBucket();
                } else {
                    newbuckets[idx].add(getNode(key));
                }
            }
        }
        this.buckets = newbuckets;
    }
    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key) {
        return remove(key, null);
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value) {
        int idx = findbucket(key);
        Collection<Node> bucket = buckets[idx];
        if (bucket != null) {
            for (Node n : bucket) {
                if (node.key.equals(key) && (value == null || node.value.equals(null))) {
                    bucket.remove(node);
                    size --;
                    return node.value;
                }
            }

        }
        return null;
    }






}
