/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.hgbu.example.rpnprjt3;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author JW
 */
public class RPNCalc {
    public static String[] getInput(){
        String expression;
        Scanner myScan = new Scanner(System.in);
        System.out.println("Enter a Reverse Polish Notation Expression: ");
        //Take Input
        expression = myScan.nextLine();
        //Check if equation contains only numbers
        if(expression.matches("[a-zA-Z]+")){
            throw new InvalidRPNString("Cannot process words, only numbers");
        }
        //Place string in a string array for calculation
        String [] input = {};
        try{
            input = expression.split(" ");
        }
        catch (InvalidRPNString e){
            System.out.println("Input cannot be spliced, check for valid input");
        }
        if(input.length < 3){
            throw new InvalidRPNString("Invalid Number of Arguements, check for three arguements. Ex. '3 3 +'");
        }

        return input;

    }
    public static double calculateRPN(String[] expression) {
        
        Stack<String> stck = new Stack<String>();
 
        double returnValue = 0;
        double num1 = 0;
        double num2 = 0;
 
        String operators = "+-*/";
 
        for(String i : expression){
            //push number to stack
            if(!operators.contains(i)){
                stck.push(i);
            }
            //preform calculation if operator is found
            else{
                try{
                    num1 = Double.valueOf(stck.pop());
                    num2 = Double.valueOf(stck.pop());
                }
                catch(InvalidRPNString e){
                    System.out.println("Can't pop values, stack is empty or values are not doubles");
                    return 0;                   
                }
                switch(i){
                    case "+":
                        stck.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stck.push(String.valueOf(num2 - num1));
                        break;
                    case "*":
                        stck.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        if(num1 == 0){
                            throw new InvalidRPNString("Improper Arithmetic, Divide by zero");
                        }
                        stck.push(String.valueOf(num2 / num1));
                        break;
                }
            }
        }
 
        returnValue = Double.parseDouble(stck.pop());
 
        return returnValue;

    }
}