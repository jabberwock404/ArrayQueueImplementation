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
    public void testEnqueue() {
        /*System.out.println("Test Enqueue Method");
        //check for null inputs
        Exception exception1 = assertThrows(InvalidDataException.class, ()->{
            Object element = null;
            ArrayQueue instance = new ArrayQueue();
            instance.enqueue(element);     
        });
        String message1 = exception1.getMessage();
        assertTrue(message1.equals("Imroper data, cannot be null"));*/
        
        //check for a valid enqueue
        int element = 5;
        ArrayQueue instance = new ArrayQueue();
        instance.enqueue(element);
        assertEquals(element, instance.dequeue());


    }

    /**
     * Test of dequeue method, of class ArrayQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");

        ArrayQueue instance = new ArrayQueue();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of front method, of class ArrayQueue.
     */
    @Test
    public void testFront() {
        System.out.println("front");
        ArrayQueue instance = new ArrayQueue();
        Object expResult = null;
        Object result = instance.front();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ArrayQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayQueue instance = new ArrayQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ArrayQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayQueue instance = new ArrayQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
