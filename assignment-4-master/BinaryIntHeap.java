package binheap;
import java.util.Arrays;
/**
 * This class shows the  Implementation of  BinaryIntHeap containing the methods provided
 * I have decided to give my variables wierd naming so as to prevent having the same name other students
 * @author Amina Hamza
 *
 */
public class BinaryIntHeap {
	private int arr[] = new int[8];
	private int size = 0;
	public BinaryIntHeap() { // the constructor 

	}

	public void insert( int n ) // adding n to the heap
	{
		if( size == arr.length - 1 ) 
		{
			resize();
		}
		int current = size++;
		while(current>1 && n<( arr[current/2] ))
		{ 
			arr[ current ] = arr[ current / 2 ];
			current = current/2;
		}
		arr[current] = n; 
	}

	private void percolatingDown() { 
		int starting = 0;
		int rooting;
		int posing = arr[ 0 ];
		while (2 * starting + 1 < size)
		{
			rooting = getChild(starting);
			if (arr[rooting] < posing) 
			{
				arr[starting] = arr[rooting];
			}
			else
				break;
			starting = rooting;
		}
		arr[starting] = posing;
	}


	public int pullHighest(){ // Pull the int with highest priority
		if (isEmpty()) 
		{
			throw new RuntimeException();
		}

		int rsult = arr[0];
		arr[0] = arr[size - 1];
		size--;
		percolatingDown();        
		return rsult;
	}

	private int getChild(int i) { 
		int child = 2 * i +1 ;
		int naping = 2;
		int paping = 2 * i + naping;
		while ((naping <= 2) && (paping < size)) 
		{
			if (arr[paping] < arr[child]) 
				child = paping;
			paping = 2 * i + (naping+=1); 
		}    
		return child;
	}


	public int size() { // Current heap size

		return this.size;
	}

	public boolean isEmpty() {// True if heap is empty

		return size == 0;
	}

	private void resize() { //resizing the array
		int doubleSize = size*2;
		arr = Arrays.copyOf(arr, doubleSize);
	}

}
