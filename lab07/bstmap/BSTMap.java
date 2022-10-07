package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTNode node;
    private int size;

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();

    }

    private class BSTNode {
        private V val;
        private K key;
        private BSTNode left;  // left node
        private BSTNode right; // right node
        public BSTNode(V v, K k, BSTNode l, BSTNode r) {
            val = v;
            key = k;
            left = l;
            right = r;
        }
    }

    public BSTMap() {
        clear();
    }

    public void clear() {
        size = 0;
        node = new BSTNode(null, null, null, null);

    }

    public boolean containsKey(K key) {
        if (node == null) {
            return false;
        } else {
            BSTNode n = node;
            while (n != null && n.key != null) {
                if (key.compareTo(n.key) == 0) {
                    return true;
                } else if (key.compareTo(n.key) < 0)   {
                    n = n.left;
                    // containsKey()
                } else if (key.compareTo(n.key) > 0) {
                    n = n.right;
                }
            }

        }
        return false;
    }

    //private boolean containsKey(K key, BSTNode n) {

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        if (node.key == null || node == null || !containsKey(key)) {
            return null;
        } else {
            BSTNode n = node;
            while (n != null) {
                if (key.compareTo(n.key) == 0) {
                    return n.val;
                } else if (key.compareTo(n.key) < 0) {
                    n = n.left;
                } else if (key.compareTo(n.key) > 0) {
                    n = n.right;
                }
            }
            return null;
        }
    }

    //private V rget(K key, BSTNode n) {

    //}

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */


    public void put(K key, V value) {
        if (containsKey(key)) {
            size -= 1;
        }
        if (node.key == null) {
            node = new BSTNode(value, key, null, null);

        } else if (node.key == key) {
            node.val = value;
        } else if (key.compareTo(node.key) < 0) {
            BSTNode newleft;
            //if (node.left == null) {
            newleft = rput(key, value, node.left);
            //} else {
            //   newleft = new BSTNode(node.left.val, node.left.key, rput(key, value, node.left), node.left.right);
            // }
            node =  new BSTNode(node.val, node.key, newleft, node.right);
        } else if (key.compareTo(node.key) > 0) {
            BSTNode newright;
            //if (node.right == null) {
            newright = rput(key, value, node.right);
            //} else {
            //newright = new BSTNode(node.right.val, node.right.key, node.right.left,  rput(key, value, node.right));

            // }


            node =  new BSTNode(node.val, node.key, node.left, newright);
        }
        size += 1;
    }
    private BSTNode rput(K key, V value, BSTNode n) {
        // BSTNode copy = n;
        if (n == null || n != null && n.key == null) {
            n = new BSTNode(value, key, null, null);
        } else if (key.compareTo(n.key) == 0) {
            n.val = value;
        } else if (key.compareTo(n.key) < 0) {
            n.left = rput(key, value, n.left);
        } else if (key.compareTo(n.key) > 0) {
            n.right = rput(key, value, n.right);
        }
        return n;
    }
    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }


    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }



    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        throw new UnsupportedOperationException();
    }
    // private void print(V value, BSTNode n) {
    //   while (n.key != null) {
    //    }
    //  }

}


