package binheap;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.Test;
public class BinaryIntHeapTest {
	@Test
	final void testInsert() {
		BinaryIntHeap binaryHeap = new BinaryIntHeap();

		binaryHeap.insert(4);
		binaryHeap.insert(3);

		assertEquals(binaryHeap.pullHighest(),4);

	}

	@Test
	final void testPullHighest() {
		BinaryIntHeap binaryHeap = new BinaryIntHeap();
		binaryHeap.insert(4);
		binaryHeap.insert(3);
		assertEquals(binaryHeap.pullHighest(),4);
		assertEquals(binaryHeap.pullHighest(),3);

	}

	@Test
	final void testSize() {
		BinaryIntHeap binaryHeap = new BinaryIntHeap();
		for(int i=0; i<10; i++) {
			binaryHeap.insert(i);
		}
		assertEquals(binaryHeap.size(),10);
		for(int i=0; i<10; i++) {
			binaryHeap.pullHighest();
		}
		assertEquals(binaryHeap.isEmpty(),true);

	}


}
