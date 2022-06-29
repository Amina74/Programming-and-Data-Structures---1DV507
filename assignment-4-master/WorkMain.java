package ah224uq_assign4.PriorityQueue;
import java.util.Arrays;
import java.util.Iterator;
public class WorkMain {

	public static void main(String[] args) {
		
		PriorityQueue pq = new BinaryHeapQueue();
		System.out.println("Size: " + pq.size());
		System.out.println("Empty: " + pq.isEmpty());
		String[] tasks = new String[] { "eat", "Play games", "sleep", "repeat", "Eat",
				"Code ", "Sleep" , "Repeat" };

		for (int i = 1; i < tasks.length; i++) {
			Task task = new WorkTask(i, tasks[i ]);
			pq.insert(task);
		}
		Task newTask_1 = new WorkTask(1, "Study");
		pq.insert(newTask_1);
		
		Task newTask_last = new WorkTask(6, "Gym");
		pq.insert(newTask_last);

		System.out.println("Size: " + pq.size());
		System.out.println("Empty: " + pq.isEmpty());
		System.out.println("Peek : " + pq.peekHighest());
		System.out.println("String: " + pq.toString() );
		System.out.println("Pull: " + pq.pullHighest());
		System.out.println("Peek : " + pq.peekHighest());
		System.out.println("Size: " + pq.size());
		String[] arr = pq.toArray();
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Contains: " + pq.contains(newTask_1));
		System.out.println("String: " + pq.toString());
		pq.remove(newTask_last);

		Task task_new = new WorkTask(1, "Lsn to Music");
		

		System.out.println(newTask_1.equals(task_new));
		System.out.println();
		System.out.println("Iterator");
		Iterator<Task> it = pq.iterator();
		while (it.hasNext())
			System.out.println(it.next());

}
}
