/* LockDListNode.java */

package list;

/**
 *  LockDListNode extends the DListNode class,and adds a locked
 *  or not flag. 
 */

class LockDListNode extends DListNode {

  protected boolean locked;

  // constructor
  public LockDListNode(Object item, DListNode prev, DListNode next) {
    super(item, prev, next);
    locked = false;
  }
}
