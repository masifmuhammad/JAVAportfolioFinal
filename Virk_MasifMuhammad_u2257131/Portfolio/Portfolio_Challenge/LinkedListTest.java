package Portfolio.Portfolio_Challenge;

import Portfolio.Portfolio_Challenge.Lists.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    public void init(){
        linkedList = new LinkedList();
        linkedList.addFirst("One");
        linkedList.addLast("Two");
        linkedList.addLast("Three");
    }

    @Test
    public void testToString(){
        assertEquals("Contents:{One,Two,Three}",linkedList.toString());
    }

    @Test
    public void testIsEmpty(){
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testSize(){
        assertEquals(3,linkedList.size());
    }

    @Test
    public void testContains(){
        assertFalse(linkedList.contains("Hello"));
        assertTrue(linkedList.contains("Two"));
    }

    @Test
    public void testAddFirst(){
        assertTrue(linkedList.addFirst("BeforeOne"));
        assertEquals(4,linkedList.size());
        assertEquals("Contents:{BeforeOne,One,Two,Three}",linkedList.toString());
    }

    @Test
    public void testAddLast(){
        assertTrue(linkedList.addLast("AfterThree"));
        assertEquals(4,linkedList.size());
        assertEquals("Contents:{One,Two,Three,AfterThree}",linkedList.toString());
    }

    @Test
    public void testAdd(){
        assertTrue(linkedList.add(0,"BeforeOne"));
        assertTrue(linkedList.add(3,"BeforeThree"));
        assertEquals("Contents:{BeforeOne,One,Two,BeforeThree,Three}",linkedList.toString());
    }

    @Test
    public void testFirst(){
        assertEquals("One",linkedList.first());
    }

    @Test
    public void testLast(){
        assertEquals("Three",linkedList.last());
    }

    @Test
    public void testGet(){
        assertEquals("One",linkedList.get(0));
        assertEquals("Three",linkedList.get(2));
    }

    @Test
    public void testRemoveFirst(){
        assertEquals("One",linkedList.removeFirst());
        assertEquals("Two",linkedList.first());
    }

    @Test
    public void testRemoveLast(){
        assertEquals("Three",linkedList.removeLast());
        assertEquals("Two",linkedList.last());
    }

    @Test
    public void testRemoveElement(){
        assertTrue(linkedList.remove("Two"));
        assertEquals("Contents:{One,Three}",linkedList.toString());
    }

    @Test
    public void testRemoveIndex(){
        assertEquals("Three",linkedList.remove(2));
        assertEquals("Contents:{One,Two}",linkedList.toString());
    }

    @Test
    public void testPush(){
        assertEquals("BeforeOne",linkedList.push("BeforeOne"));
        assertEquals("Contents:{BeforeOne,One,Two,Three}",linkedList.toString());
    }

    @Test
    public void testTop(){
        assertEquals("One",linkedList.top());
    }

    @Test
    public void testPop(){
        assertEquals("One",linkedList.pop());
        assertEquals("Contents:{Two,Three}",linkedList.toString());
    }

    @Test
    public void testEnQueue(){
        assertTrue(linkedList.enqueue("AfterThree"));
    }

    @Test
    public void testDeQueue(){
        assertEquals("One",linkedList.dequeue());
    }
}


