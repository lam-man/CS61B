/* LockDList.java */

package list;

/**
 *  LockDList extends the DList
 */

public class LockDList extends DList{

  protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

  // Change the node to locked.
  public void lockNode(DListNode node) {
    ((LockDListNode)node).locked = true;
  }

  // Remove the node if it is not locked. 
  public void remove(DListNode node) {
    if (((LockDListNode)node).locked) {
      System.out.println("Locked node cannot be removed!");
      return;
    }
    else
        super.remove(node);
  }

  // Test function in main
  public static void main(String args[]) {
    LockDList testList = new LockDList();
    testList.insertFront(6);
    testList.insertBack(8);
    testList.lockNode(testList.front());
    System.out.println(testList.toString());
    testList.remove(testList.front());
    testList.remove(testList.head.prev);
    System.out.println(testList.toString());
  }
}
