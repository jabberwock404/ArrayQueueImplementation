/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.hgbu.example.rpnprjt3;

import static com.oracle.hgbu.example.rpnprjt3.RPNCalc.calculateRPN;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author JW
 */
public class RPNCalcTest {
    
    public RPNCalcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInput method, of class RPNCalc.
     */
    /*@Test
    public void testGetInput() {
        System.out.println("getInput");
        String[] test1 = new String[] {"2", "2", "+"};
        String[] test2 = new String[] {"2", "2", "-"};
        String[] test3 = new String[] {"5", "3", "*"};
        String[] test4 = new String[] {"15", "3", "/"};
        String[] test5 = new String[] {"23.3", "5", "16.2", "+", "8", "*", "-"};
        assertArrayEquals(test1, getInput("2 2 +"));
        assertArrayEquals(test2, getInput("2 2 -"));
        assertArrayEquals(test3, getInput("5 3 *"));
        assertArrayEquals(test4, getInput("15 3 /"));
        assertArrayEquals(test5, getInput("23.3 5 16.2 + 8 * -"));
        // TODO review the generated test code and remove the default call to fail.
    }*/
    /*@Test
    public void testGetInputBad() {
        System.out.println("test for bad getInput");
        Exception exception1 = assertThrows(InvalidRPNString.class, ()->{
            RPNCalc.getInput();
        });
        String actualMessage1 = exception1.getMessage();
        assertTrue(actualMessage1.equals("Invalid Number of Arguements, check for three arguements. Ex. '3 3 +'"));
        Exception exception2 = assertThrows(InvalidRPNString.class, ()->{
            RPNCalc.getInput();
        });
        String actualMessage2 = exception2.getMessage();
        assertTrue(actualMessage2.equals("Cannot process words, only numbers"));
        
        Exception exception3 = assertThrows(InvalidRPNString.class, ()->{
            RPNCalc.getInput();
        });
        String actualMessage3 = exception3.getMessage();
        assertTrue(actualMessage3.equals("Input cannot be spliced, check for valid input"));
    };*/

    /**
     * Test of calculateRPN method, of class RPNCalc.
     */
    @Test
    public void testCalculateRPN() {
        System.out.println("calculateRPN");
        String[] test1 = new String[] {"2", "2", "+"};
        String[] test2 = new String[] {"2", "2", "-"};
        String[] test3 = new String[] {"5", "3", "*"};
        String[] test4 = new String[] {"15", "3", "/"};
        String[] test5 = new String[] {"23.3", "5", "16.2", "+", "8", "*", "-"};
        assertEquals(4, calculateRPN(test1), 0.0000001);
        assertEquals(0, calculateRPN(test2), 0.0000001);
        assertEquals(15, calculateRPN(test3), 0.0000001);
        assertEquals(5, calculateRPN(test4), 0.0000001);
        assertEquals(-146.29999999999, calculateRPN(test5), 0.0000001);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCalculateRPNBad() {
        System.out.println("test for bad calculateRPN");
        //check for divide by zero
        Exception exception1 = assertThrows(InvalidRPNString.class, ()->{
            String[] test1 = new String[] {"2", "0", "/"};
            RPNCalc.calculateRPN(test1);
        });
        String actualMessage1 = exception1.getMessage();
        assertTrue(actualMessage1.equals("Improper Arithmetic, Divide by zero"));
        
        //check for empty stack
        assertThrows(InvalidRPNString.class, ()->{
            String[] test1 = new String[] {"1", "+"};
            RPNCalc.calculateRPN(test1);
        });
        //check for invalid conversion
        assertThrows(InvalidRPNString.class, ()->{
            String[] test1 = new String[] {"james", "john", "*"};
            RPNCalc.calculateRPN(test1);
        });

    }

    private String[] getInput(String _2_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
