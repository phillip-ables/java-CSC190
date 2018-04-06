
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
            //add the charachter atget key value of charachter + the encoded key value
            encoded += alphebet.charAt((alphebet.indexOf(p.charAt(i)) + alphebet.indexOf(key.charAt(i%key.length())))%27);
        }
        System.out.println(encoded);
    }
    static void decode(String p, String key){
        String alphebet = " abcdefghijklmnopqrstuvwxyz";
        String decoded = "";
        int t;
        for(int i = 0; i < p.length() ; i++){
            //get charecter 
            t = alphebet.indexOf(p.charAt(i)) - alphebet.indexOf(key.charAt(i%key.length()));
            if(t<0)
                t += 27;
            decoded += alphebet.charAt(t);
        }
        System.out.println(decoded);
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
