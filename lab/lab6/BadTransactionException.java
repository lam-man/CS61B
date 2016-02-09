/* BadTransactionException.java */

/**
 *  Implements an exception that should be thrown for bad transactions.
 **/
public class BadTransactionException extends Exception {

    public int amount; // amount to deposit or withdraw

    /**
     *  Creates an exception object for bad amount in trasation.
     **/
    public BadTransactionException(int badAmount) {
      super("Invalid amount: " + badAmount);

      amount = badAmount;
    }
}
