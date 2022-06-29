package ah224uq_assign4.PriorityQueue;
import java.util.Iterator;
public interface   PriorityQueue {
	void insert(Task t);

	Task pullHighest();

	boolean contains(Task t);

	int size();

	boolean isEmpty();

	Task peekHighest();

	String toString();

	void clear();

	String[] toArray();

	Iterator<Task> iterator();

	void remove(Task t);

}
