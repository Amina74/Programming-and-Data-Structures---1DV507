package ah224uq_assign2.Queue;
/**
 * This is an interface representing a Queue which extands Iterable, It provides
 * diffirent kind of methods, which they are : size() which gets the size of a Queue.
 * isEmpty() return true if the Queue is empty , 
 * enqueue(int x) Getting an integer,then add it to the end of the Queue.
 *  dequeue(); present (return) and remove
 * the last() and first() methods is to return last and first
 * element in Queue 
 * the toString(); method present nice looking String of Queue elements
 * ex: [x y z]
 * 
 * @author Amina Hamza
 * @since 2020 - 2 - 6
 */

public interface IntQueue extends Iterable<Integer> {
	
	

	/**
	 * current queue size
	 * 
	 * @return Integer
	 */
	public int size(); // current queue size

	/**
	 * true if queue is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * add element at end of queue
	 * 
	 * @param element Integer to be added
	 */
	public void enqueue(int element);

	/**
	 * return and remove first element.
	 * 
	 * @return Integer
	 */
	public int dequeue();

	/**
	 * returns a queue without removing first element
	 * 
	 * @return Integer
	 */
	public int first();

	/**
	 * returns a queue without removing the last element
	 * 
	 * @return Integer
	 */
	public int last();

	/**
	 * this returns a string representation of 
	 * the queue content
	 * 
	 * @return String
	 */
	public String toString();

}
