package lab12;

import java.util.Scanner;

/*
course: CSC190
project: lab11
date: 4-13
author: Phillip Ables
purpose: 
    use the babylon method to find a square root,
    the method we create to solve the babylon method needs a good seed
    use the information from wiki to call a function that makes a good seed
 */
public class Lab12 {
    public static void main(String[] args) {
        int n = 5;
        for (int i=0;i<n;i++) {

        int j;

        for (j=0;j<n-i;j++)

        System.out.printf("%4s"," ");


        int k=i*2+1;

        for (j=0;j<=i;j++)

        System.out.printf("%4d",k+i*j);

        System.out.println();

}

    }
    
}
