package Portfolio.Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html

/**
 * Doubly-linked list implementation
 */
public class LinkedList implements List, Stack, Queue {

    private ListNode header;    // A pointer to header (sentinel node)
    private ListNode trailer;   // A pointer to trailer (sentinel node)
    private int size;           // The number of elements in the list

    /**
     * Creates a doubly linked list
     */
    public LinkedList() {
        // Initialize linked list in O(1)
        header = new ListNode(null,null,null);
        trailer = new ListNode(null,header,null);
        header.setNext(trailer);
        size = 0;
    }

    @Override
    public String toString() {
        // Implement in O(n)
        String contents = "Contents:{";
        ListNode currNode = header.getNext();
        while(currNode != trailer){
            contents += currNode.getElement();
            currNode = currNode.getNext();
            if (currNode != trailer) contents += ",";
        }
        contents += "}";
        return contents;
    }

    /* Collection Interface */

    @Override
    public int size() {
        // Implement in O(1)
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Implement in O(1)
        return size() == 0;
    }

    @Override
    public boolean contains(String element) {
        // Implement in O(n)
        if(!isEmpty()){
            ListNode currNode = header.getNext();
            do{
                if(currNode.getElement()==element){
                    return true;
                }
                currNode = currNode.getNext();
            } while(currNode != trailer);
        }
        return false;
    }

    /* List Interface */

    /* Add element */

    @Override
    public boolean addFirst(String element) {
        // Implement in O(1)
        return addBetween(element,header,header.getNext());
    }

    @Override
    public boolean addLast(String element) {
        // Implement in O(1)
        return addBetween(element,trailer.getPrev(),trailer);
    }

    @Override
    public boolean add(int index, String element) {
        // Implement in O(n)
        checkIndex(index);

        if(index == 0){
            return addFirst(element);
        } else {
            ListNode currNode = header.getNext();

            while (index > 0) {
                currNode = currNode.getNext();
                index--;
            }

            return addBetween(element,currNode.getPrev(),currNode);
        }
    }

    /* Get element */

    @Override
    public String first() {
        // Implement in O(1)
        if(isEmpty()){
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    @Override
    public String last() {
        // Implement in O(1)
        if(isEmpty()){
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
    }

    @Override
    public String get(int index) {
        // Implement in O(n)
        checkIndex(index);

        if(index == 0){
            return header.getNext().getElement();
        } else if (index == size()-1) {
            return trailer.getPrev().getElement();
        }

        ListNode currNode = header.getNext();
        while(index > 0){
            currNode = currNode.getNext();
            index--;
        }
        return currNode.getElement();
    }

    /* Remove element */

    @Override
    public String removeFirst() {
        // Implement in O(1)
        if(isEmpty()){
            return null;
        } else {
            return remove(header.getNext());
        }
    }

    @Override
    public String removeLast() {
        // Implement in O(1)
        if(isEmpty()){
            return null;
        } else {
            return remove(trailer.getPrev());
        }
    }

    @Override
    public boolean remove(String element) {
        // Implement in O(n)
        if(!isEmpty()){
            ListNode currNode = header.getNext();
            do{
                if(currNode.getElement()==element){
                    remove(currNode);
                    return true;
                }
                currNode = currNode.getNext();
            } while(currNode != trailer);
        }
        return false;
    }

    @Override
    public String remove(int index) {
        // Implement in O(n)
        checkIndex(index);

        if(index == 0){
            return removeFirst();
        } else if (index == size()-1) {
            return removeLast();
        } else {

            ListNode currNode = header.getNext();

            while(index > 0){
                currNode = currNode.getNext();
                index--;
            }

            return remove(currNode);
        }
    }

    /* Stack Interface */

    @Override
    public String push(String element) {
        // Implement in O(1)
        addBetween(element, header, header.getNext());
        return header.getNext().getElement();
    }

    @Override
    public String top() {
        // Implement in O(1)
        if(isEmpty()) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    @Override
    public String pop() {
        // Implement in O(1)
        if(isEmpty()){
            return null;
        } else {
            return remove(header.getNext());
        }
    }

    /* Queue Interface */

    @Override
    public boolean enqueue(String element) {
        // Implement in O(1)
        return addBetween(element,trailer.getPrev(),trailer);
    }

    @Override
    public String dequeue() {
        // Implement in O(1)
        return remove(header.getNext());
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index "+ index + " out of bound.");
        }
    }

    private boolean addBetween(String element, ListNode prevNode, ListNode nextNode){
        ListNode newNode = new ListNode(element,prevNode,nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;

        if(newNode != null){
            return true;
        } else {
            return false;
        }
    }

    private String remove(ListNode currNode){
        ListNode prevNode = currNode.getPrev();
        ListNode nextNode = currNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        return currNode.getElement();
    }



}