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
        System.out.println(Calculator.calculate(test).toString());
        System.exit(0);
    }
    
}
