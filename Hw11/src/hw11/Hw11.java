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
    //check if any type of bracket present then send it to the innerPair function
    static void possiblePairs(String s){
        char ch;
        for(int i =0; i < s.length(); i++){
            ch = s.charAt(i);
            //if we have reason to believe there are brackets involved
            //send to inner pairs
            if(ch == '{' || ch == '{' || ch == '['){
                innerPair(s);
                return;
            }
        }
        //paran took care of
        System.out.println(EvalE(s));
    }
    //removes inner most bracket
    static void innerPair(String s){
        char ch;
        int open, close;
        open = close = 0;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            //check for bracket
            //set open index and find closing bracket index
            //if no matching pair end code let user know invalid
            if(ch == '('){
                open = i;
                if(close == s.lastIndexOf(')'))
                    close = s.lastIndexOf(')', close);
                else if (s.lastIndexOf(')') < 0){
                    System.out.println("Invalid");
                }                
                else
                    close = s.lastIndexOf(')');
            }
            else if(ch == '{'){
                open = i;
                if(close == s.lastIndexOf('}'))
                    close = s.lastIndexOf('}', close);
                else if (s.lastIndexOf('}') < 0){
                    System.out.println("Invalid");
                }                
                else
                    close = s.lastIndexOf('}');
            }
            else if(ch == '['){
                open = i;
                if(close == s.lastIndexOf(']'))
                    close = s.lastIndexOf(']', close);
                else if (s.lastIndexOf(']') < 0){
                    System.out.println("Invalid");
                }                
                else
                    close = s.lastIndexOf(']');
            }
        }
        //if pair was found evaluate inner pair and return a substring with that value instaead of paranthesis
        if(close > 0){
            possiblePairs(s.substring(0,open)+EvalE(s.substring(open+1,close))+s.substring(close+1));
        }
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
            
            possiblePairs(e);
            
            res = "yes";
            System.out.print("Try again?: ");
            res = in.next();
        }while(res.toLowerCase().charAt(0) == 'y');
    }
    
}
