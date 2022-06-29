package ah224uq_assign1.Exercise2;
import java.util.NoSuchElementException;
public class StackMain {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		try {
			System.out.println("The size of Stack is : " + stack.size());

			stack.push("Who"); // pushing elements
			stack.push("are");
			stack.push("you ?");

			System.out.println("The size of Stack after pushing : " + stack.size());
			System.out.println("Pick and remove last element : " + stack.pop());
			System.out.println("Cheking size after poping : " + stack.size());
			System.out.println("Return (without removing) top element: " + stack.peek());

			stack.pop();  //poping "are"
			stack.pop();  //poping "Who"
			stack.pop();  //can not pop more elements!!
		} catch (NoSuchElementException e) {
			System.out.println("\nStack is empty so please add Strings before invoking pop() or peek()!!");
		}

	}
	}


