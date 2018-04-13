package hw10;

import java.util.Random;
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
        Boolean keepPlaying = true;
        String play = "";
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int upper, lower, size, turn, two, take;
        String power2 = "";
        upper = max;
        lower = 10;
        //if odd then computers turn
        turn = 0;
        take = 0;
        //random value from upper bounds or guess to lower bounds of 10
        size = rnd.nextInt(upper-lower)+lower;
        size = 100;
        //choosing randomly who goes first
        if(rnd.nextBoolean()){
            turn++;
        }
        do{
            if(size > 0){
                System.out.println("size is : "+size);
                //computers turn
                if(turn%2 == 0){
                    two = 2;
                    while(two*2 <= size){
                        two *= 2;
                    }
                    if(size == 1){
                        size = 0;
                    }
                    else if(size == (two-1)){//if size is one less then power of two
                        take = rnd.nextInt((two-1)-1)+1;  //random number of one less then power of two and one
                    }else{
                        size = two -1;
                        take = 0;
                    }
                    System.out.println("Computers turn, marbles minus "+size);
                }else{//players turn
                    System.out.println("Players turn : ");
                    take = in.nextInt();
                }
                size -= take;
                turn++;
            }else{
                //turn now equals whos turn it would be meaning whos turn it was last is who lost
                if(turn%2 != 0){
                    System.out.println("COMPUTER TOOK LAST MARBLE");
                }else{
                    System.out.println("PLAYER TOOK THE LAST MARBLE");
                }
                
                
                
                //could not get this last line working 
                //origianlly just had do while charAt 0 equal y
                //in no exploration has it not ended before allowing me to give an input

                System.out.println("Do you wish to play again?");
                play = in.nextLine().toLowerCase();
                if(play.indexOf("y") != 0){
                    keepPlaying = false;
                }
            }

        }while(keepPlaying);
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize;
        
        System.out.println("Enter a max number of marbles for the game to begin: ");
        maxSize = in.nextInt();
        
        play(maxSize);
        
        
    }
    
}
