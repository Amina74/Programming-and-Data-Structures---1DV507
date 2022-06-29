package ah224uq_assign1.Ex5;
import java.util.Iterator;
public class QueueMain {

	public static void main(String[] args) {

		LinkedQueue queue = new LinkedQueue();

		try {
			for (int i = 1; i <= 5; i++) { // adding elements from 1 to 5
				queue.enqueue(i);
			}

			System.out.println("String : " + queue.toString());
			System.out.println("The size of the Queue is: " + queue.size());
			System.out.println("Return and remove first element in Queue: " + queue.dequeue());
			System.out.println("After removing: " + queue.toString());
			System.out.println("The size of the Queue is: " + queue.size());
			System.out.println("First element in Queue: " + queue.first());
			System.out.println("Last element in Queue: " + queue.last());
			System.out.println("isEmpty() : " + queue.isEmpty());


			System.out.println("Return and remove first element in Queue: " + queue.dequeue());

			Iterator<Integer> iterator = queue.iterator();
			System.out.print("Queue elements: ");
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			System.out.println();

			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
		} catch (NullPointerException  e) {
			System.out.println("\nQueue is empty so please enqueue or add  elements!!");
		}

	}




}


