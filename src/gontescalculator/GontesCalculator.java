/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gontescalculator;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JFrame;

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
        CalcGui gui = new CalcGui();
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(450,300);
    }
    
}
