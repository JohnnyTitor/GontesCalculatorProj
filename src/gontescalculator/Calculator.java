package gontescalculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Calculator 
{
    
    //simple check to see if a string is a number
    static boolean isNumber(String str) 
    {
        try
        {
            Double.valueOf(str);
            return true;
        } 
        catch(Exception e)
        {
            return false;
        }
    }
    static boolean isNumber(char c) 
    {
        try
        {
            Double.valueOf(Character.toString(c));
            return true;
        } 
        catch(Exception e)
        {
            return false;
        }
    }

    //first take the user's string and clean it up so it can be effectively used.
    //after being formatted, it is split into a string[]
    public static String[] formatInput(String input)
    {
        String output = input;
        
        //removes all letters from the input
        output = output.replaceAll("[a-z]", "");
        
        //separates numbers and formats them
        //output = output.replaceAll("(?<number>\\d+(\\.\\d+)?)", "${number} ");
        
        //fixes cases where the uses puts too many - when they mean subtract a negative
        output = output.replaceAll("\\-{2,}", "\\- \\-");
        
        //isolate all the operators except for - due to negative numbers
        output = output.replaceAll("(?<ops>[+*/^()])", " ${ops} ");        
        
        // Removes all multi white spaces and replaces with a single space
        output = output.replaceAll(" {2,}", " ");
        
        //clean up any extra whitespaces
        output = output.replaceAll("\\s+", " ").trim();
        
        //splits the string into a string[] base on spaces
        return output.split(" ");
    }
    
    //Takes the String[] that is clean and separated and convert it into a
    // reverse polish notation queue, so it can be solved
    public static Queue<String> reversePolishNotation(String[] infixNotation) 
    {
        //this is necessary in order to ensure that the queue follows
        //order of operations
        Map<String, Integer> operatorImportance = new HashMap<>();
        operatorImportance.put("^", 3);
        operatorImportance.put("*", 2);
        operatorImportance.put("/", 2);
        operatorImportance.put("-", 1);
        operatorImportance.put("+", 1);
        operatorImportance.put("(", 0);
 
        //this is where the ops are held during the operation.
        Stack<String> opStack = new Stack<>();
        //the solution queue or solQueue is the final rpn notation algorithm
        Queue<String> solQueue = new LinkedList<>();
        
        for (String token : infixNotation) 
        {
            //the left paranthesis gets pushed onto the stack 
            if (token.equals("(")) 
            {
                opStack.push(token);
                continue;
            }
            //if right parenthesis, continually pop off the ops until the 
            //left parenthesis is found again.
            if (token.equals(")")) {
                while (!"(".equals(opStack.peek())) 
                {
                    solQueue.add(opStack.pop());
                }
                //pop off the left parenthesis. Continue the operation
                opStack.pop();
                continue;
            }
            // an operator
            if (operatorImportance.containsKey(token)) 
            {
                //if the op is less important than the one on the stack, add all
                //the more important ones to the Queue, then push the current op
                while (!opStack.empty() && operatorImportance.get(token) <= operatorImportance.get(opStack.peek())) 
                {
                    solQueue.add(opStack.pop());
                }
                opStack.push(token);
                continue;
            }
 
            //push the numbers onto the solution queue
            if (isNumber(token)) 
            {
                solQueue.add(token);
                continue;
            }
 
            //if some junk data that doesn't fit the formatting options is found,
            //throw an effor
            throw new IllegalArgumentException("Error!");
        }
        // at the end, pop all the elements in the opstack to the solution queue
        while (!opStack.isEmpty()) 
        {
            solQueue.add(opStack.pop());
        }
 
        // the solution queue returned is now a queue that is the RPN of the
        //original expression
        return solQueue;
    }
    
    //Takes the RPN Queue and performs the correct oparations on them to create
    //a queue where the solution is found as the first item in the queue
    public static double solve(Queue<String> input)
    {
        //this stack is where the arithmatic will be done
        Stack<Double> sol = new Stack<>();
        
        //variable1 is the number 2 inputs away from the op, while variable2
        // is the number next to the operation
        double var1 = 0.0;
        double var2 = 0.0;
        
        
        
        while(!input.isEmpty())
        {
            String token = input.remove();
            
            //if the value on the queue is a number, toss it onto the solutionstack
            if(isNumber(token))
            {
                sol.push(Double.valueOf(token));
            }
            else
            {
                //otherwise, if it's an operator, check which kind it is and
                //perform it's specific action
                switch (token)
                {
                    case "+":
                        //check to make sure there are enough objects on the
                        //stack to actually perform the operation
                        if(sol.size() >=2)
                        {
                           var2 = sol.pop();
                           var1 = sol.pop();
                           sol.push(var1 + var2);
                        }
                        else
                        {
                            throw new IllegalArgumentException("Error!");
                        }
                        break;
                    case "-":
                        if(sol.size() >=2)
                        {
                           var2 = sol.pop();
                           var1 = sol.pop();
                           sol.push(var1 - var2);
                        }
                        else
                        {
                            throw new IllegalArgumentException("Error!");
                        }
                        break;
                    case "*":
                        if(sol.size() >=2)
                        {
                            var2 = sol.pop();
                            var1 = sol.pop();
                            sol.push(var1 * var2);
                        }
                        else
                        {
                            throw new IllegalArgumentException("Error!");
                        }
                        break;
                    case "/":
                        if(sol.size() >= 2)
                        {
                            var2 = sol.pop();
                            var1 = sol.pop();
                            sol.push(var1 / var2);
                        }
                        else
                        {
                            throw new IllegalArgumentException("Error!");
                        }
                        break;
                    case "^":
                        if(sol.size() >= 2)
                        {
                            var2 = sol.pop();
                            var1 = sol.pop();
                            sol.push(Math.pow(var1, var2));
                        }
                        else
                        {
                            throw new IllegalArgumentException("Error!");
                        }
                }
            }
            
        }
        
        //there should only be one thing left in the stack, otherwise something
        //went wrong with the input
        if(sol.size() == 1)
        {
            return sol.pop();
        }
        
        return -1;
    }
    
    public static Double calculate(String str)
    {
        return solve(reversePolishNotation(formatInput(str)));
    }
}