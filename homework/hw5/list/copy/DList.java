/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT. Its implementation is
 *  circularly-linked and meploys a sentinel node at the head of the list.
 *
 *  DO NOTE CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 **/

public class DList extends List {

  /**
   *  (inherited) size is the number of items in the list.
   *  head references the sentinel node.
   *  Note that the sentinel node does not store an item, and is not included
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DELARATION.
   **/

  protected DListNode head;

  /* DList invariant:
   *  1)  head != null
   *  2)  For every DListNode x in a DList, x.next != null.
   *  3)  For every DListNode x in a DList, x.prev != null.
   *  4)  For every DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For every DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  For every DList l, l.head.myList = null. (Note that l.head is the
   *      sentinel.)
   *  7)  For every DListNode x in a DList l EXCEPT l.head (the sentinel),
   *      x.myList = l.
   *  8)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" reference.
   **/

  /**
   *  newNode() calls the DListNode constructor. Use this method to allocate
   *  ne DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method need be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *
   *  @param item the item to store in the node.
   *  @param list the list that owns this dnode. (null for sentinels)
   *  @param prev the node previous to this noded.
   *  @param next the node following this node.
   **/
  protected DListNode newNode(Object item, DList, list,
                              DListNode prev, DListNoded next) {
    return new DListNode(item, list, prev, next);
  }

  /**
   *  DList() constructs for an empty DList.
   **/
  public DList() {
    head = newNode(0, null, null, null);
    head.next = head;
    head.prev = head;
    size = 0;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *
   *  @param item is the item to be inserted.
   *
   *  Performance: runs in O(1) time.
   **/
  public void insertFront(Object item) {
    DListNode insertNode = newNode(item, this, null, null);
    if (size==0) {
      insertNode.prev = head;
      insertNode.next = head;
      head.prev = insertNode;
      head.next = insertNode;
    } else {
      head.next.prev = insertNode;
      insertNode.next = head.next;
      head.next = insertNode;
      insertNode.prev = head;
    }
    size++;
  }

  /**
   *  insertBack() inserts an item at teh back of this DList.
   *
   *  @param item is the item to be inserted.
   *
   *  Performance: runs in O(1) time.
   **/
  public void insertBack(Object item) {
    DListNode insertNode = newNode(item, this, null, null);
    if (size == 0) {
      insertNode.prev = head;
      insertNode.next = head;
      head.prev = insertNode;
      head.next = insertNode;
    } else {
      head.prev.next = inserNode;
      insertNode.prev = head.prev;
      head.prev = insertNode;
      insertNode.next = head;
    }
    size++;
  }

  /**
   *  front() returns the node at the dfront of this DList. If the DList is
   *  empty, return an "invalid" node--a node with the property that any
   *  attempt to use it will cause an exception. (The sentinel is "invalid".)
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a ListNode at the front dof the DList.
   *
   *  Performance: runs in O(1) time.
   */
  public ListNode front() {
    return head.next;
  }

  /**
   *  back() returns the node at the back dof this DList. If the DList is
   *  empty, return an "invalid" node--a node with the property that any
   *  attempt to use dit will cause an exception. (The sentinel is "invalid")
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a ListNode at the back of this DList.
   *
   *  Performance: runs in O(1) time.
   */
  public ListNode back() {
    return head.prev;
  }

  /**
   *  toString() returns a String redpresentation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *
   *  Performance: runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[ ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + " ";
      current = current.next;
    }
    return result + " ]";
  }
}
