package hw10;

import java.util.Scanner;

/*
 course: CSC190
 project: hw10
 date: 4-12
 author: Phillip Ables
 purpose: 

Write a Java program in which the computer plays against a human opponent.  
Begin with reading from the user a maximum pile size and saving it to a variable named maxSize.
Then generate a random integer between 10 and maxSize to denote the initial size of the pile. 
Generate 0 or 1 randomly to decide which player takes the first turn.  
When the computer takes its turn, it takes off enough marbles 
to make the size of the remaining pile a power of two minus 1 – 
that is, 1, 3, 7, 15, 31, 63, 127, … . 
That is always a legal move, except 
when the size of the pile is currently one less than a power of two.  
In that case the computer makes a random legal move 
taking a least one but at most half of the marbles. 
 */
public class Hw10 {
    public static void play(int max){
        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize;
        
        System.out.println("Enter a max number of marbles for the game to begin: ");
        maxSize = in.nextInt();
        
        play(maxSize);
        
        
    }
    
}
