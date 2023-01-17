package Portfolio.Portfolio_Challenge;

import Portfolio.Portfolio_Challenge.Trees.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    public void init(){
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.add("N");
        binarySearchTree.add("F");
        binarySearchTree.add("Z");
        binarySearchTree.add("A");
        binarySearchTree.add("R");
        binarySearchTree.add("C");
        binarySearchTree.add("H");
        binarySearchTree.add("L");
        binarySearchTree.add("M");
        //                      N
        //                    /    \
        //                  F       z
        //                /  \      /
        //              A     H    R
        //              \      \
        //               C      L
        //                       \
        //                        M
    }

    @Test
    public void testToString(){
        assertEquals("A C F H L M N R Z ",binarySearchTree.toString());
    }

    @Test
    public void testSize(){
        assertEquals(9,binarySearchTree.size());
    }

    @Test
    public void testIsEmpty(){
        assertFalse(binarySearchTree.isEmpty());
    }

    @Test
    public void testContains(){
        assertTrue(binarySearchTree.contains("A"));
        assertTrue(binarySearchTree.contains("H"));
        assertFalse(binarySearchTree.contains("I"));
    }

    @Test
    public void testRoot(){
        assertEquals("N",binarySearchTree.root().getElement());
    }

    @Test
    public void testParent(){
        assertEquals(null,binarySearchTree.root().getParent());
        assertEquals("N",binarySearchTree.get("F").getParent().getElement());
    }

    @Test
    public void testLeft(){
        assertEquals("F",binarySearchTree.root().getLeftChild().getElement());
    }

    @Test
    public void testRight(){
        assertEquals("Z",binarySearchTree.root().getRightChild().getElement());
    }

    @Test
    public void testSibling(){
        assertEquals("H",binarySearchTree.sibling(binarySearchTree.get("A")).getElement());
    }

    @Test
    public void testNumChildren(){
        assertEquals(2,binarySearchTree.numChildren(binarySearchTree.get("F")));
        assertEquals(1,binarySearchTree.numChildren(binarySearchTree.get("Z")));
        assertEquals(0,binarySearchTree.numChildren(binarySearchTree.get("M")));
    }

    @Test
    public void testIsInternal(){
        assertTrue(binarySearchTree.isInternal(binarySearchTree.get("F")));
        assertTrue(binarySearchTree.isInternal(binarySearchTree.get("H")));
        assertFalse(binarySearchTree.isInternal(binarySearchTree.get("M")));
    }

    @Test
    public void testIsExternal(){
        assertTrue(binarySearchTree.isExternal(binarySearchTree.get("M")));
        assertTrue(binarySearchTree.isExternal(binarySearchTree.get("R")));
        assertFalse(binarySearchTree.isExternal(binarySearchTree.get("F")));
    }

    @Test
    public void testIsRoot(){
        assertTrue(binarySearchTree.isRoot(binarySearchTree.get("N")));
        assertFalse(binarySearchTree.isRoot(binarySearchTree.get("F")));
    }

    @Test
    public void testAdd(){
        assertEquals("C",binarySearchTree.add("B").getParent().getElement());
        assertEquals(null,binarySearchTree.sibling(binarySearchTree.get("B")));
        assertEquals("A B C F H L M N R Z ",binarySearchTree.toString());
    }

    @Test
    public void testGet(){
        assertEquals("C",binarySearchTree.add("B").getParent().getElement());
        assertEquals("B",binarySearchTree.get("B").getElement());
        assertEquals(null,binarySearchTree.get("I"));
    }

    @Test
    public void testRemove(){
        assertEquals("F",binarySearchTree.remove("F"));
        assertEquals("H",binarySearchTree.root().getLeftChild().getElement());
        assertEquals("A",binarySearchTree.left(binarySearchTree.get("H")).getElement());
        assertEquals("L",binarySearchTree.right(binarySearchTree.get("H")).getElement());
        assertEquals("A C H L M N R Z ",binarySearchTree.toString());
    }
}
