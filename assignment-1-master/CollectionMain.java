package ah224uq_assign1.Ex4;

public class CollectionMain {
	public static void main(String[] args){


		ArrayIntList cyber = new ArrayIntList(); //creating new list
		cyber.add(15);//adding values
		cyber.add(16);
		cyber.add(17);
		cyber.add(18);
		cyber.add(19);
		cyber.add(10);
		cyber.add(11);
		cyber.add(12);
		cyber.add(13);
		System.out.println(cyber.isEmpty());
		System.out.println(cyber.get(8));
		cyber.addAt(1, 7);
		System.out.println(cyber.get(9));
		System.out.println(cyber.size());// geying the size
		System.out.println(cyber.toString());
		cyber.remove(5);// removing at position 5
		System.out.println(cyber.size());
		System.out.println(cyber.get(5));


		ArrayIntStack cyboc = new ArrayIntStack();//creating new list
		cyboc.push(9);//adding values
		cyboc.push(7);
		cyboc.push(8);
		System.out.println(cyboc.isEmpty());
		System.out.println(cyboc.size());
		System.out.println(cyboc.pop());
		System.out.println(cyboc.size());
		System.out.println(cyboc.peek());
		System.out.println(cyboc.toString());
	}
}
