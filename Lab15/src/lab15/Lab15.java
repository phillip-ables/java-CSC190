package lab15;
/*
course: CSC190
project: Lab15
date: 5/4, 2018
author: Phillip Ables
purpose: 
    method encode(String w) that takes a word and returns the corresponding Morse code string. 
    Any invalid character other than alphabets in the input should be ignored. 
    Note that the character '!' is ignored and a ' ' is used between two Morse codes as a delimiter.
    method decode(String m) that takes a Morse code string and 
    returns the corresponding word ignoring all invalid codes. For input ".--- .- ...- ---. .-", 
    it should return "JAVA", where invalid code "---." is ignored.
*/

import java.util.Scanner;
class MorseCode {
    String m[] = {".-", "-...", "-.-.", "-..", ".", "..-.",
                  "--.", "....", "..", ".---", "-.-", ".-..",
                  "--", "-.", "---", ".--.", "--.-", ".-.",
                  "...", "-", "..-", "...-", ".--", "-..-",
                  "-.--", "--.."};
    
    String indexA = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String encode(String w) {
        String encodedString = "";
        char ch;
        
        //iterate over the length of the code
        for(int i = 0; i < w.length(); i++){
            ch = w.charAt(i);
            if(indexA.indexOf(ch) > 0)
            //print alphebet index of moriscode at that same index value
            encodedString += m[indexA.indexOf(ch)]+" ";
            
        }
        return encodedString;
        
    }
    
    String decode(String m) {
        String lastM = "";
        int nextSpace = m.length() -1;
        String encodedString = "";
        //for every space in string
        do{
            if(m.indexOf(" ") != -1)
            {
                nextSpace = m.indexOf(" ");
                System.out.println(m.substring(0,nextSpace));
                System.out.println("NextSpace " + nextSpace);
                //find that morse code!!
                for(int i = 0; i < this.m.length; i++)
                {
                    if(this.m[i].equals(m.substring(0, nextSpace)))
                    {
                        System.out.println(indexA.charAt(i));

                        encodedString += indexA.charAt(i);
                        System.out.println("New m = "+ m);
                        break;
                    }
                }
                lastM = m;
                m = m.substring(nextSpace+1);
            }
            else
            {
                System.out.println("Last Run "+m);
                for(int i = 0; i < this.m.length; i++)
                {
                    if(this.m[i].equals(m))
                    {
                        encodedString += indexA.charAt(i);
                        break;
                    }
                }
                lastM = m;
            }
               
        }while(m != lastM);
        
        System.out.print("Encoded String = ");
        return encodedString;
    }
}

public class Lab15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MorseCode myCode = new MorseCode();
        String res;
   
        do { //menu setup
            System.out.println("1. encode: ");           
            System.out.println("2. decode: ");             
            
            System.out.println("q. quit: ");
            
            System.out.print("select: "); 
            res = in.next();
            in.nextLine();
            
            switch (res.charAt(0)) {
                case '1': 
                    System.out.print("Enter a plain text: ");
                    String text = in.nextLine().toUpperCase();
                    System.out.println(myCode.encode(text));
                    break;
                case '2':                 
                    System.out.print("Enter a morse code text: ");
                    String code = in.nextLine();
                    System.out.println(myCode.decode(code));
                    break;                
                    
                case 'q': case 'Q':
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("invalid! Try it again");
            }           
        } while (res.toUpperCase().charAt(0) !=  'Q');  
    }  
}