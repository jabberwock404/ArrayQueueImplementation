/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JW
 */
public class ArrayQueueTest {
    
    public ArrayQueueTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class ArrayQueue.
     */
    @Test
    public void testEnqueueDequeue() {
        System.out.println("enqueue method check");
        //check if we can load null input
        Exception exception1 = assertThrows(InvalidDataException.class, ()->{
            Object element = null;
            ArrayQueue instance = new ArrayQueue();
            instance.enqueue(element);     
        });
        String message1 = exception1.getMessage();
        assertTrue(message1.equals("Improper data, cannot be null"));
        
        //check if basic queue loading works
        int element = 5;
        ArrayQueue instance = new ArrayQueue();
        instance.enqueue(element);
        assertEquals(element, instance.front());
        
        //check if multiple enqueue/dequeue works
        ArrayQueue queue1 = new ArrayQueue();
        for(int i = 1; i <= 15; i++){
            queue1.enqueue(i);
        }
        assertTrue(queue1.size() == 15);
        queue1.dequeue();
        queue1.dequeue();
        assertEquals(3, queue1.dequeue());
        
        //check for resize
        ArrayQueue queue2 = new ArrayQueue();
        for(int i = 1; i <= 100; i++){
            queue2.enqueue(i);
        }
        assertTrue(queue2.size() == 100);
        
        //check dequeue method
        System.out.println("dequeue method check");
        
        //check if you can't dequeue with no elements
        Exception exception2 = assertThrows(QueueEmptyException.class, ()->{
            ArrayQueue instance1 = new ArrayQueue();
            for(int i = 0; i < 5; i++){
                instance1.enqueue(i);
            }
            for(int i = 0; i < 6; i++){
                instance.dequeue();
            }
        });
        String message2 = exception2.getMessage();
        assertTrue(message2.equals("Cannot dequeue, no items on the queue."));
        
        //check for standard dequeue
        ArrayQueue queue = new ArrayQueue();
        for(int i = 0 ; i < 5; i++){
            queue.enqueue(i);
        }
        for(int i = 0;i < 3; i++){
            queue.dequeue();
        }
        assertTrue(queue.size() == 2);

        System.out.println("Check for multiple enqueue/dequeue operations");
        //check for multiple enqueue and dequeue (reusability)
        ArrayQueue queue3 = new ArrayQueue();
        for(int i = 0; i < 5; i++){
            queue3.enqueue(i);
        }
        for(int i = 0; i < 5; i++){
            queue3.dequeue();
        }
        assertTrue(queue3.size() == 0);
        for(int i = 0; i < 15; i++){
            queue3.enqueue(i);
        }
        queue3.enqueue(15);
        assertTrue(queue3.size() == 16);
        for(int i = 0; i < 16; i++){
            assertEquals(queue3.dequeue(), i);
        }
        
    }

    /**
     * Test of front method, of class ArrayQueue.
     */
    @Test
    public void testFront() {
        System.out.println("front() method check");
        //check throw if it throws exception for an empty queue
        Exception exception1 = assertThrows(QueueEmptyException.class, ()->{
            ArrayQueue queue = new ArrayQueue();
            queue.enqueue(1);
            queue.dequeue();
            queue.front();
        });
        String message1 = exception1.getMessage();
        assertTrue(message1.equals("Cannot return front, queue is empty"));
        
        //check for standard front based of an enqueue/dequeue
        ArrayQueue instance = new ArrayQueue();
        for(int i = 0; i < 5; i++){
            instance.enqueue(i);
        }
        for(int i = 0;i < 2; i++){
            instance.dequeue();
        }
        assertEquals(instance.front(), 2); 
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of size method, of class ArrayQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size test");
        //check for standard enqueue sizing
        ArrayQueue instance = new ArrayQueue();
        for(int i = 0; i < 5; i++){
            instance.enqueue(i);
        }
        assertEquals(5, instance.size());
        
        //check for resize
        ArrayQueue instance2 = new ArrayQueue();
        for(int i = 1; i <= 100; i++){
            instance2.enqueue(i);
        }
        assertTrue(instance2.size() == 100);
        
        //check for mutliple enqueue and dequeue sizing
        ArrayQueue instance3 = new ArrayQueue();
        for(int i = 0; i < 5; i++){
            instance3.enqueue(i);
        }
        for(int i = 0;i < 5; i++){
            instance3.dequeue();
        }
        assertTrue(instance3.size() == 0);
        
        for(int i = 0; i < 25; i++){
            instance3.enqueue(i);
        }
        instance3.enqueue(25);
        assertTrue(instance3.size() == 26);
    }

    /**
     * Test of isEmpty method, of class ArrayQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        //check for standard empty queue
        ArrayQueue instance = new ArrayQueue();
        assertTrue(instance.isEmpty() == true);
        
        //check for standard loaded queue
        ArrayQueue instance1 = new ArrayQueue();
        for(int i = 0; i < 25; i++){
            instance1.enqueue(i);
        }
        assertTrue(instance1.isEmpty() == false);
        
        //check for enqueue and dequeue sizing works
        for(int i = 0; i < 22; i++){
            instance1.dequeue();
        }
        assertTrue(instance1.isEmpty() == false);
        
        //check for expanded enqueue/dequeue operation
        ArrayQueue instance2  = new ArrayQueue();
        for(int i = 0; i < 50; i++){
            instance2.enqueue("random string");
        }
        assertTrue(instance2.isEmpty() == false);
        for(int i = 0; i < 50; i++){
            instance2.dequeue();
        }
        assertTrue(instance2.isEmpty() == true);
        

    }
    
}
