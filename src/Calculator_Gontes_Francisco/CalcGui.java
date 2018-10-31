/**
 * @author Francisco
 * Calculator Lab3
 * CS480
 */
package Calculator_Gontes_Francisco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalcGui extends JFrame {
    private JButton num1 = new JButton("1");
    private JButton num2 = new JButton("2");
    private JButton num3 = new JButton("3");
    private JButton num4 = new JButton("4");
    private JButton num5 = new JButton("5");
    private JButton num6 = new JButton("6");
    private JButton num7 = new JButton("7");
    private JButton num8 = new JButton("8");
    private JButton num9 = new JButton("9");
    private JButton num0 = new JButton("0");
    private JButton neg = new JButton("neg");
    private JButton equal = new JButton("1");
    private JButton add = new JButton("+");
    private JButton subtract = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton div = new JButton("/");
    private JButton leftPare = new JButton("(");
    private JButton rightPare = new JButton(")");
    private JButton backSpace = new JButton("<-");
    private JButton equals = new JButton("=");
    private JButton clear = new JButton("C");
    private JButton power = new JButton("^");
    private JTextField display;
    
    private boolean canAddOperand = false;
    
    String value = "";
    
    
    //this whole constructor just formats the frame
    public CalcGui() {
        JPanel buttonGrid = new JPanel();
        buttonGrid.setLayout(new GridLayout(4, 3));
        buttonGrid.add(num1);
        buttonGrid.add(num2);
        buttonGrid.add(num3);
        buttonGrid.add(num4);
        buttonGrid.add(num5);
        buttonGrid.add(num6);
        buttonGrid.add(num7);
        buttonGrid.add(num8);
        buttonGrid.add(num9);
        buttonGrid.add(num0);
        buttonGrid.add(clear);
        buttonGrid.add(neg);


        JPanel textBox = new JPanel();
        textBox.setLayout(new FlowLayout());
        textBox.add(display = new JTextField(20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        
        JPanel functionsGrid = new JPanel();
        functionsGrid.setLayout(new GridLayout(3, 3));
        functionsGrid.add(add);
        functionsGrid.add(subtract);
        functionsGrid.add(multiply);
        functionsGrid.add(div);
        functionsGrid.add(leftPare);
        functionsGrid.add(rightPare);
        functionsGrid.add(backSpace);
        functionsGrid.add(power);
        functionsGrid.add(equals);

        JPanel bodyFrame = new JPanel();
        bodyFrame.setLayout(new BorderLayout());
        bodyFrame.add(textBox, BorderLayout.NORTH);
        bodyFrame.add(buttonGrid, BorderLayout.WEST);
        bodyFrame.add(functionsGrid, BorderLayout.EAST);
        
        Font font = new Font("Arial", Font.BOLD, 24);
        for(Component comp : functionsGrid.getComponents())
        {
            if(comp instanceof JButton)
            {
                ((JButton)comp).setFont(font);
            }
        }
        for(Component comp : buttonGrid.getComponents())
        {
            if(comp instanceof JButton)
            {
                ((JButton)comp).setFont(font);
            }
        }
        display.setFont(new Font("Arial", Font.BOLD, 16));
        add(bodyFrame);

        num1.addActionListener(new ListenToOne());
        num2.addActionListener(new ListenToTwo());
        num3.addActionListener(new ListenToThree());
        num4.addActionListener(new ListenToFour());
        num5.addActionListener(new ListenToFive());
        num6.addActionListener(new ListenToSix());
        num7.addActionListener(new ListenToSeven());
        num8.addActionListener(new ListenToEight());
        num9.addActionListener(new ListenToNine());
        num0.addActionListener(new ListenToZero());
        neg.addActionListener(new listenToNeg());
        
        add.addActionListener(new ListenToAdd());
        subtract.addActionListener(new ListenToSubtract());
        multiply.addActionListener(new ListenToMultiply());
        div.addActionListener(new ListenToDivide());
        equals.addActionListener(new ListenToSolve());
        leftPare.addActionListener(new listenToLeft());
        rightPare.addActionListener(new listenToRight());
        backSpace.addActionListener(new listenToBackSpace());
        power.addActionListener(new listenToPower());
        clear.addActionListener(new listenToClear());

    } //JavaCaluclator()

    //the listens for the values just add the numbers to the text string
    class ListenToOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"1";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"2";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"3";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToFour implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"4";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToFive implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"5";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"6";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"7";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"8";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToNine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"9";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = value+"0";
            display.setText(value);
            canAddOperand = true;
        }
    }

    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(canAddOperand)
            {
                value = value + " + ";
                display.setText(value);
                canAddOperand = false;
            }
        }
    }
    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(canAddOperand)
            {
                value = value + " - ";
                display.setText(value);
                canAddOperand = false;
            }
            
        }
    }
    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(canAddOperand)
            {
                value = value + " * ";
                display.setText(value);
                canAddOperand = false;
            }
        }
    }
    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(canAddOperand)
            {
                value = value + " / ";
                display.setText(value);
                canAddOperand = false;
            }
        }
    }
    class listenToLeft implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            if(value.length()==0)
            {
                value = value + " (";
            display.setText(value);
            canAddOperand = false;
            }
            else if(!Calculator.isNumber(value.charAt(value.length()-1)))
            {
            value = value + " (";
            display.setText(value);
            canAddOperand = false;
            }
        }
    }
    class listenToRight implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            value = value + ") ";
            display.setText(value);
            canAddOperand = true;
        }
    }
    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String solution = Calculator.calculate(value);
            display.setText(solution);
            value = solution;
        }
    }
    class listenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            value = "";
            display.setText("");
            canAddOperand = false;
        }
    }
    
    class listenToPower implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(canAddOperand)
            {
                value = value + " ^ ";
                display.setText(value);
            }
        }
    }
    
    class listenToBackSpace implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(value.length() > 0)
            {
                if(value.charAt(value.length()-1) == ' ')
                {
                    value = value.substring(0, value.length() - 2);
                }
                else
                {
                    value = value.substring(0, value.length() - 1);
                }
            }
            display.setText(value);
        }
    }
    
    //this button does some hard work in order to ensure that the last statement
    //is correctly being negated
    class listenToNeg implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(value.length() == 0)
            {
                value = "-";
            }
            else if(value.length() == 1)
            {
                value = "-" + value;
            }
            else
            {
                
                for(int i = value.length() - 1; i >= 1; i--)
                {
                    if(i == 1)
                        {
                            value = '-'+value;
                        }
                    char c = value.charAt(i-1);
                        if(!Calculator.isNumber(value.charAt(i-1)) &&
                                Calculator.isNumber(value.charAt(i)))
                        {
                            if(c == ' ')
                            {
                                value = value.substring(0,i) + '-' +
                            value.substring(i, value.length());
                                break;
                            }
                            else if(c == '(')
                            {
                                value = value.substring(0,i) + '-'+
                                value.substring(i, value.length());
                                break;
                            }
                        }
                        
                }
                
            }
            
            display.setText(value);
        }
    }

} 

