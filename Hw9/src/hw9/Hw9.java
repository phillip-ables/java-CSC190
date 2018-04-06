
package hw9;

import java.util.Scanner;

/*
class: CSC190
project: Hw9
date: 4-5
author: Phillip Ables
description:
    encode(String p, String key) 
    that takes a plain text p and 
    encodes it to a cipher text by adding the key values to each alphabet character of p
*/
public class Hw9 {
    static void encode(String p, String key){
        String alphebet = " abcdefghijklmnopqrstuvwxyz";
        String encoded = "";
        for(int i = 0; i < p.length() ; i++){
            //for each letter we add a new letter using the key value which we get from the index of the alphebet string
            //index consist of original string character at iterations key value
            //plus index value of our key string which is smaller than our main string
            //to fix this just modules it by the length of itself so that it just cycles over and over itself
            //finally make sure this value is in range of the key values with modules alphebet length
            encoded += alphebet.charAt((alphebet.indexOf(p.charAt(i)) + alphebet.indexOf(key.charAt(i%key.length())))%27);
        }
        System.out.println(encoded);
    }
    static void decode(String p, String key){
        String keyValue = " abcdefghijklmnopqrstuvwxyz";
        String encoded = "";
        int t;
        int code;
        for(int i = 0; i < p.length() ; i++){
            t = keyValue.indexOf(p.charAt(i));
            code = i%key.length();
            //add to encode minus to decode
            t += keyValue.indexOf(key.charAt(code));
            //greater than 27 to encode less then 0 then plus 27 to decode
            if(t>=keyValue.length())
                t -= keyValue.length();

            encoded += keyValue.charAt(t);
        }
        System.out.println(encoded);
    }
    public static void main(String[] args) {
        String message, codeKey;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Message: ");
        message = in.nextLine();
        
        System.out.println("Enter encoding key: ");
        codeKey = in.nextLine();
        
        System.out.print("Encoded: ");
        encode(message, codeKey);
        
        System.out.print("Decoded: ");
        decode(message, codeKey);
    }
    
}
