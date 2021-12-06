/*
 *  File: Steque.java
 *  Author: 
 *  Date: 18th Nov, 2021
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author 
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {
    private Item[] stack;
    private int size;
    private int rear;
    private int last;
    private static int capacity = 10;


    /**
     * constructs a steque object.
     */
    public Steque() {
        stack = (Item[]) new Object[capacity];
        size = 0;
        rear = 0;


    }
    private void resize() {
		int newCapacity = 2*stack.length;
		Item[] newstack = (Item[]) new Object[newCapacity];
		for(int i=0; i<stack.length; i++) {
			newstack[i] = stack[i];
		}
		stack = newstack;
    }
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */


 // time complexity: O(n) space complexity: O(n)
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if(size >= stack.length) resize();
        for(int i=stack.length-1; i > 0;i--) stack[i] = stack[i-1];
        stack[0] = item;
        size++;



    }
    
    
    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */
    public void push(Item item) {
        if(item==null) throw new IllegalArgumentException();
        if(size >= stack.length) resize();
        stack[size] = item;
        size++;

    }
    
    /**
     * pops a least recent item in steque.
     * @return Item object from steque.
     */
      //time complexity: O(1), space complexity: O(1
    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException();
        Item item = stack[size-1];
        stack[size-1] = null;
        size--;
        return item;

    }
    
    /**
     * checks to see if steque is empty.
     * @return true if steque is empty, false otherwise.
     */
     //time complexity: O(1), space complexity: 0
    public boolean isEmpty() {
        return size==0;


    }
    
    /**
     * return the number of elements currently in the steque.
     * @return size as integer.
     */
     //time complexity: O(1), space complexity: 0
    public int size() {
        return size;


    }
    
    /**
     * returns an iterator over the elements 
     * stored in steque.
     * 
     */
     //time complexity: O(1), space complexity: 0
     public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    public class ArrayIterator implements Iterator<Item> {
        public int i = size-1;

     
        public boolean hasNext() {
            return i >= 0;
        }

      
        public void remove() {
            throw new UnsupportedOperationException();
        }

        
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = stack[i];
            i--;
            return item;
    }
}
    public static void main(String[] args){
        Steque<Integer> x = new Steque<Integer>();
        x.enqueue(14);
        x.enqueue(17);
        x.enqueue(20);
        x.push(5);
        x.push(10);
        x.push(15);
        x.enqueue(25);
        System.out.println("empty:"+x.isEmpty());
        System.out.println("size:"+x.size());
        Iterator<Integer> y = x.iterator();
        System.out.println("steque elements");
        while(y.hasNext())
        System.out.println(y.next());
        System.out.println("popped elements");
       while(!x.isEmpty()){
           System.out.println(x.pop());
       }
    }}