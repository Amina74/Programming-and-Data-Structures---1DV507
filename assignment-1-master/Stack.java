package ah224uq_assign1.Exercise2;
import java.util.NoSuchElementException;

public class Stack implements StringStack{



	private String[] arr;

	public Stack() {
		arr = new String[0];
	}

	public int size() {
		return arr.length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(String str) { // Adding element at top of stack
		increaseSize();
		arr[size() - 1] = str;

	}

	public String pop() throws NoSuchElementException { // Return and remove top element
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		String str = arr[size() - 1];
		decreaseSize();
		return str;
	}

	public String peek() throws NoSuchElementException {  //Return (without removing) top element
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		String str = arr[size() - 1];
		return str;
	}

	private void increaseSize() {
		String[] newArray = new String[size() + 1];
		int i = 0;
		while (i < newArray.length - 1) {
			newArray[i] = arr[i];
			i++;
		}
		arr = newArray;
	}

	private void decreaseSize() {
		String[] newArray = new String[size() - 1];
		int i = 0;
		while (i < arr.length - 1) {
			newArray[i] = arr[i];
			i++;
		}
		arr = newArray;
	}





	
}
