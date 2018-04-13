package lab12;

import java.util.Scanner;

/*

 */
public class Lab12 {
    static double getSeed(double n){
        double count = 0.0;
        if(n > 99){
            while(n > 100) {
                n = n/100;
                count += 2;
            }
        }
        else if(n < 0){
            while(n < 0){
                n *= 100;
                count -= 2;
            }
        }
        else{
            count++;
        }
        return n * count * 10;
    }
    static double mySqrt(double n){
        double seed  = getSeed(n);
        double lastG = 0.0;
        
        while(seed != lastG){
            lastG = seed;
            seed = (seed+(n/seed))/2;
        }
        return seed;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n(-1 to stop: ");
        double n = in .nextDouble();
        
        while ( n > 0){
            System.out.println("my sqrt of "+n+" = "+ mySqrt(n));
            System.out.println("Math.'s sqrt of "+n+" = "+Math.sqrt(n));
            System.out.print("Enter n(-1 to stop): ");
            n = in.nextDouble();       
        }
        System.out.println("bye");
    }
    
}
