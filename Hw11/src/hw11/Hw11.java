package hw11;

import java.util.Scanner;

/**
 * cource: CSC 190
 * project: hw11
 * date: 4-26
 * author: phillip ables
 * purpose:
 *  Write and implement a Java method that takes arithmetic expressions 
 * and determine whether parentheses are used properly.  
 * Assume that there are 3 types of parentheses
 * – (), {}, [], and numbers/operators are typed correctly.  
 */
public class Hw11 {
    static void possiblePairs(String s){
        char ch;
        int open, close;
        String target = s;
        String check = "";
        String returnString = "";
        System.out.println("Take string "+s);
        //first lets seperat paranthesis
        while(target != check){
            check = target;
            open = close = 0;
            for(int i = 0; i < target.length(); i++){
                ch = target.charAt(i);
                if(ch == '('){
                    open = i;
                    close = target.lastIndexOf(')');
                    if(close < 0){
                        System.out.println("Invalid");
                        return 0;
                    }                
                }
                else if(ch == '{'){
                    open = i;
                    close = target.lastIndexOf('}');
                    if(close < 0){
                        System.out.println("Invalid");
                        return 0;
                    }                
                }
                else if(ch == '['){
                    open = i;
                    close = target.lastIndexOf(']');
                    if(close < 0){
                        System.out.println("Invalid");
                        return 0;
                    }                
                }
                if(close > 0){
                    returnString += target.substring(0,i-1);
                    target = target.substring(open, close-1);
                    returnString += ""EvalE(target)+
                }
            }
            //inner most bracket should be found
            
        }
        return EvalE(returnString);
    }
    
    static int evalMD(String s) {
        int product = 1;
        char previousOP = '*';
        int tmp = 0;
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
 
            if (ch != '*' && ch != '/' )
                tmp = tmp*10+ch-'0';
            else
            {
                if (previousOP == '*')
                    product *= tmp;
                else{
                    product /= tmp;
                }
                tmp = 0;
                previousOP = ch;
            }
        }
        
        if (previousOP == '*')
            product *= tmp;
        else
                product /= tmp; 
        return product;
    }


    
    static int EvalE(String s) {
        int result = 0;
        char previousOP = '+';
        char firstOP = '?';
        String tmp = "";
        
        for (int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);            
            if (ch != '+' && ch != '-')
            {
                //set up the string to be converted into an integer
                tmp += ch;
                if(ch == '/' || ch == '*')
                {
                    //if / or * its fine because it can be converted in our MD
                    //we just need to check if the second number is negative or positive
                    if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
                        //if two variables
                        //save the first operand and skip to the next
                        firstOP = s.charAt(i);
                        i++;
                        if(ch == '-' && previousOP == '+'){
                            //("result should be negatie");
                            result -= evalMD(tmp);
                            previousOP = '-';
                        }
                        if(ch == '-' && previousOP =='-'){
                            //("result should be positive");
                            result += evalMD(tmp);
                            previousOP = '+';
                        }
                    } 
                    
                }
            }else{
                //("doing some adding or subtraction");
                if (previousOP == '+'){
                    result += evalMD(tmp);
                }else
                    result -= evalMD(tmp);
                if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
                    //("two operands");
                    //remember the first for a reference at the end
                    firstOP = ch;
                    i++;
                }
                tmp = "";
                previousOP = s.charAt(i);
            }
        }
        
        // add or substrct the result of last expression
        
        if (previousOP == '+' && firstOP == '+' 
                || previousOP == '-' && firstOP == '-'
                || previousOP =='+' && firstOP == '?')
        {
            
            System.out.println("add");
           result += evalMD(tmp);
        }
        else
           result -= evalMD(tmp);
        
        return result;
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        
        do{
            System.out.print("Enter expression: ");
            String e = in.next();
            
            System.out.println(possiblePairs(e));
            
            res = "yes";
            System.out.print("Try again?: ");
            res = in.next();
        }while(res.toLowerCase().charAt(0) == 'y');
    }
    
}
