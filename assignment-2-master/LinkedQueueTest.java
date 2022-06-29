package ah224uq_assign2;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import ah224uq_assign1.Ex5.*;

class LinkedQueueTest {

	private static int test_count = 0;

	/* Is executed before every test method (not test case). */
	@BeforeEach
	public void setUp() {
		test_count++;
		System.out.println("Test " + test_count);
	}

	/* Is executed after every test method (not test case). */
	@AfterEach
	public void tearDown() {
	}

	@Test
	void testSize() {
		IntQueue queue = new LinkedQueue();
		assertEquals(0, queue.size());
	}

	@Test
	void testIsEmpty() {
		IntQueue queue = new LinkedQueue();
		assertTrue(queue.isEmpty());

		queue.enqueue(1);
		queue.enqueue(2);
		assertFalse(queue.isEmpty());
	}

	@Test
	void testEnqueue() {
		IntQueue queue = new LinkedQueue();
		for (int i = 1; i <= 5; i++) { // [1 , 2 , 3 , 4 ,5]
			queue.enqueue(i);
		}
		assertEquals(5, queue.size());
		assertEquals(1, queue.first());
		assertEquals(5, queue.last());

	}

	@Test
	void testDequeue() {
		IntQueue queue = new LinkedQueue();
		int i = 1;
		while (i <= 5) { // [1 , 2 , 3 , 4 ,5]
			queue.enqueue(i);
			i++;
		}
		assertEquals(1, queue.dequeue()); // [2 , 3 , 4 ,5]
		assertEquals(2, queue.dequeue()); // [3 , 4 ,5]
		assertEquals(3, queue.size());

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertThrows(NullPointerException.class, () -> queue.dequeue());

	}

	@Test
	void testFirst() {
		IntQueue queue = new LinkedQueue();
		for (int i = 1; i <= 6; i++) { // [1 , 2 , 3 , 4 ,5 , 6]
			queue.enqueue(i);
		}
		assertEquals(1, queue.first());
		queue.dequeue();
		assertEquals(2, queue.first()); // [2 , 3 , 4 ,5 , 6 ]

		for (int i = 0; i < 5; i++) {
			queue.dequeue();
		}
		assertThrows(NullPointerException.class, () -> queue.first());
	}

	@Test
	void testLast() {
		IntQueue queue = new LinkedQueue();
		for (int i = 1; i <= 3; i++) { // [1 , 2 , 3]
			queue.enqueue(i);
		}
		assertEquals(3, queue.last());

		for (int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		assertThrows(NullPointerException.class, () -> queue.last());
	}

	@Test
	void testIterator() {
		IntQueue queue = new LinkedQueue();
		Iterator itr = queue.iterator();
		assertFalse(itr.hasNext());

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			while (itr.hasNext()) {
				assertEquals(i, itr.next());
			}
		}
	}

	@Test
	void testToString() {
		IntQueue queue = new LinkedQueue();
		queue.enqueue(2);
		assertFalse(queue.isEmpty());

		assertEquals("[ 2  ]", queue.toString());

		queue.dequeue();
		assertTrue(queue.isEmpty());

	}
	
	
}
