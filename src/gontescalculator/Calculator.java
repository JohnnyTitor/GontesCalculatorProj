package gontescalculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;


public class Calculator {
    

    public static String[] formatInput(String input)
    {
        String output = input.toLowerCase();
        
        //removes all letters from the input
        output = output.replaceAll("[a-z]", "");
        
        output = output.replaceAll("(?<number>\\d+(\\.\\d+)?)", " ${number} ");
        
        output = output.replaceAll("(?<ops>[+*/^()])", " ${ops} ");        
        
        // Removes all multi white spaces and replaces with a single space
        output = output.replaceAll(" {2,}", " ");
        
        output = output.replaceAll("\\s+", " ").trim();
        
        return output.split(" ");
    }
    
    static boolean isNumber(String str) {
        try{
            Double.valueOf(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
 
    public static Queue<String> convertInfixToRPN(String[] infixNotation) {
        Map<String, Integer> prededence = new HashMap<>();
        prededence.put("^", 2);
        prededence.put("/", 2);
        prededence.put("*", 2);
        prededence.put("+", 1);
        prededence.put("-", 1);
        prededence.put("(", 0);
 
        Queue<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();
 
        for (String token : infixNotation) {
            if ("(".equals(token)) {
                S.push(token);
                continue;
            }
 
            if (")".equals(token)) {
                while (!"(".equals(S.peek())) {
                    Q.add(S.pop());
                }
                S.pop();
                continue;
            }
            // an operator
            if (prededence.containsKey(token)) {
                while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
                    Q.add(S.pop());
                }
                S.push(token);
                continue;
            }
 
            if (isNumber(token)) {
                Q.add(token);
                continue;
            }
 
            throw new IllegalArgumentException("Invalid input");
        }
        // at the end, pop all the elements in S to Q
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }
 
        return Q;
    }
    
    public static double solve(Queue<String> input)
    {
        Stack<Double> sol = new Stack<>();
        double var1 = 0.0;
        double var2 = 0.0;
        
        
        
        while(!input.isEmpty())
        {
            String token = input.remove();
            
            if(isNumber(token))
            {
                sol.push(Double.valueOf(token));
            }
            else
            {
                switch (token)
                {
                    case "+":
                        if(sol.size() >=2)
                        {
                           var2 = sol.pop();
                           var1 = sol.pop();
                           sol.push(var1 + var2);
                        }
                        else
                        {
                            //throw new Exception("Error");
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
                            //throw new Exception("Error");
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
                            
                        }
                }
            }
            
        }
        
        if(sol.size() == 1)
        {
            return sol.pop();
        }
        
        return -1;
    }
}