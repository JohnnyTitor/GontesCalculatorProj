/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gontescalculator;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class GontesCalculator 
{

    /**
     * @param args the command line arguments
     */
    
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) 
    {
        String test = (keyboard.nextLine());
        String[] formatted = (Calculator.formatInput(test));
        System.out.println(Arrays.toString(formatted));
        Queue q = Calculator.convertInfixToRPN(formatted);
        System.out.println(q.toString());
        Double solution = Calculator.solve(q);
        System.out.println(solution.toString());
        keyboard.nextLine();
        System.exit(0);
    }
    
}
