/* HashTableChained.java */

import /Volumes/Study/2015winter/cs61b/hw_p/hw5/list.*;
package dict;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
  protected int size;
  protected SList[] buckets;
  protected  int PRIME = 109345121;
  protected int capacity;
  protected long scale, shift;

  /**
   *  Check whether a number is a prime or not.
   *  @param num input integer to be checked.
   *  @return true if input number is a prime, otherwise false.
   */
  public static boolean isPrime(int num) {
    if (num < 2)
      return false;
    else{
      for (int i=0; i<num; i++){
        if (num % i == 0)
          return false;
      }  
    }
    return true;
  }

  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.

    int lower = sizeEstimate;
    int upper = lower * 2;

    // choose the capacity for the hash table
    for (int i=upper; i > lower; i--){
      if (isPrime(i)) {
        capacity = i;
       }
    }
    
    buckets = new SList[capacity];
    for (int i=0; i < capacity; i++)
      buckets[i] = new SList();

    java.util.Random rand = new java.util.Random();
    scale = rand.nextInt(PRIME);
    shift = rand.nextInt(PRIME);
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
    defaultSize = 103;
    capacity = defaultSize;

    for (int i=0; i < capacity; i++)
      buckets[i] = new SList();

    java.util.Random rand = new java.util.Random();
    scale = rand.nextInt(PRIME);
    shift = rand.nextInt(PRIME);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    return (((scale*code + shift) % PRIME) % capacity);
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size==0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
    Entry insertEntry = new Entry(key, value);
    code = key.hashCode();
    int bucketInd = compFunction(code);
    bucktes[bucketInd].insertBack(insertEntry);
    return insertEntry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
    code = key.hashCode();
    bucketInd = compFunction(code);
    ListNode node = buckets[bucketInd].front();

    if (node == null) {
      return null;
    } else {
      try {
        while(node.isValidNode()){
          if (((Entry) node.item()).key == key) {
            Entry newEntry = new Entry(key, node.item());
            return newEntry;
          } else {
            node = node.next();
          }
        }
      } catch (InvalidNodeException ine) {
        System.out.println(ine);
      }
    }
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
    code = key.hashCode();
    bucketInd = compFunction(code);
    ListNode node = buckets[bucketInd].front();

    if (node == null) {
      return null;
    } else {
      try {
        while(node.isValidNode()) {
          if (((Entry) node.item()).key == key) {
            Entry newEntry = new Entry(key, node.item());
            node.remove();
            return newEntry;
          }
        }
      } catch (InvalidNodeException ine) {
        System.out.println(ine);
      }
    }
    return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
    for (int i=0; i < capacity; i++) {
      buckets[i] = new SList();
    }
  }

}
