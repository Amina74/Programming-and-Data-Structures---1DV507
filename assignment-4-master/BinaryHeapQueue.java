package ah224uq_assign4.PriorityQueue;
import java.util.Iterator;
public class BinaryHeapQueue implements PriorityQueue{

	private Task[] task = new Task[10];;
	private int size = 1;

	public void BinaryQueueHeap() {
	}

	@Override
	public void insert(Task t) {
		if (size == 1) {
			task[size] = t;
			size++;
		} else if (size > 1) {
			if (size == task.length)
				resize();
			task[size++] = t;
		}
		int i = size - 1;
		checkInt(i);
	}

	private void checkInt(int a) {
		if (a == 1) {
			return;
		} else if (task[a].getTaskPriority() <= task[a / 2].getTaskPriority())
			return;
		else {
			int position = a;
			Task temp = task[a / 2];
			int i = a / 2;
			task[i] = task[a];
			task[position] = temp;
			checkInt(i);
		}
	}

	private void resize() {
		Task[] temp = new Task[task.length * 2];
		for (int i = 1; i < size; i++) {
			temp[i] = task[i];
		}
		task = temp;
	}

	@Override
	public Task pullHighest() {
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		Task h = task[1];
		task[1] = task[size - 1];

		remove();

		int i = 1;
		swap(i);
		return h;
	}

	private void remove() {
		Task[] temp = new Task[task.length];
		for (int i = 0; i < size - 1; i++) {
			temp[i] = task[i];
		}
		task = temp;
		size--;
	}

	

	@Override
	public boolean contains(Task a) {
		for (int i = 1; i < size; i++) {
			if (task[i] == a) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size - 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 1;
	}

	@Override
	public Task peekHighest() {
		if (size == 1) {
			throw new IllegalArgumentException("Queue is Empty");
		}
		return task[1];
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i < size; i++) {
			if (i == size - 1) {
				str.append(task[i]);
			} else
				str.append(task[i] + " ");
		}
		return "[" + str.toString() + "]";
	}
	
	private void swap(int n) {
		if (n == size - 1 || n * 2 > size - 1 || n * 2 + 1 > size - 1) {
			return;
		}
		Task first = task[n * 2];
		Task second = task[n * 2 + 1];
		if (task[n].getTaskPriority() >= first.getTaskPriority()
				&& task[n].getTaskPriority() >= second.getTaskPriority()) {
			return;
		} else {
			if (first.getTaskPriority() >= second.getTaskPriority()) {
				Task temp = task[n];
				task[n] = first;
				task[n * 2] = temp;
				swap(n * 2);
			} else {
				Task temp = task[n];
				task[n] = second;
				task[n * 2 + 1] = temp;
				swap(n * 2 + 1);
			}
		}
	}

	@Override
	public void clear() {
		size = 1;
		task = new Task[10];
	}

	@Override
	public String[] toArray() {
		String[] arr = new String[size - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = task[i + 1].toString();
		}
		return arr;
	}

	@Override
	public void remove(Task t) {
		if (contains(t) == true) {
			Task[] temp;
			int indexOf = getIndex(t);
			temp = new Task[size() - indexOf];
			int count = 0;
			for (int i = indexOf; i < size(); i++) {
				temp[count++] = task[i + 1];
			}
			size = size() - temp.length;
			for (int i = 0; i < temp.length; i++) {
				insert(temp[i]);
			}
		} else
			throw new IllegalArgumentException();
	}

	private int getIndex(Task t) {
		int index = 0;
		for (int i = 1; i < size; i++) {
			if (task[i] == t) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public Iterator<Task> iterator() {
		return new TaskIterator();
	}

	private class TaskIterator implements Iterator<Task> {

		private int count = 1;

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public Task next() {
			if (!hasNext()) {
				throw new IllegalArgumentException("Queue is empty");
			}
			return task[count++];
		}

	}
}
