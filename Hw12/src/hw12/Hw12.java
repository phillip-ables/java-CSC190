package hw12;
//course: CSC190

//project: Hw12

//date: 5-30

//author: Phillip Ables

//purpose:
/*
Option i should read a game(title, developer, genre, year, price) and 
insert the game into the array. Note that the new game should be inserted into the right spot so that the entire array may remain sorted. 
Sorting entire array again after adding the new game at the end of the array is costly 
and hence not acceptable. 
Option s asks for a game title and lists all the games matching with the title entered. 
Note that two or more games may have the same title. 
Option d asks for a game title and deletes all the games with the title. 
Option p simply lists all the games stored in the array.
*/

import java.lang.reflect.Array;
import java.util.Scanner;

class Game {

    String title, developer, genre;

    int year;

    float price;

    //constructor

    Game (String t, String d, String g, int y, float p) {

        title = t;

        developer = d;

        genre = g;

        year = y;

        price = p;
        

    }

}


class GameDB {

    final int MAXSIZE = 10;

    Game games[];

    int n;

    GameDB() {

        games = new Game[MAXSIZE];

        n = 0;

    }

    void insert() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter title: ");

        String t = in.nextLine().toLowerCase();

        System.out.print("Enter developer: ");

        String d = in.nextLine();

        System.out.print("Enter genre: ");

        String g = in.nextLine();

        System.out.print("Enter year of production: ");

        int y = in.nextInt();

        System.out.print("Enter price: ");

        float p = in.nextFloat();

        //adding a new game at the end, must be inserted into the right spot for the hw
        
        //something to help us gauge the alphbetical order
        String measuringStick = " abcdefghijklmnopqrstuvwxyz";
        
        //if we dont have string then start one, order not concerned
        if(games[0] == null){
            games[0] = new Game(t, d, g, y, p);
        }
        //else order it
        else{
            for(int i = 0; i < n; i++){
                
                //if first letter is the same
                if(measuringStick.indexOf(t.charAt(0))
                        == measuringStick.indexOf(games[i].title.charAt(0))){
                    for(int a = 1; a < t.length(); a++){
                        if(measuringStick.indexOf(t.charAt(a))
                        < measuringStick.indexOf(games[i].title.charAt(a))){
                            for(int j = n; j > i; j--){
                                games[j] = new Game("t", "d", "g", 1 ,1);
                                games[j] = games[j-1];
                            }
                            games[i] = new Game(t, d, g, y, p);
                        }
                        else{
                        games[n] = new Game(t, d, g, y, p);
                    }
                    }
                }
                
                //if it comes in ahead of another title
                else if(measuringStick.indexOf(t.charAt(0))
                        < measuringStick.indexOf(games[i].title.charAt(0)))
                {
                    //if its higher alphebetically
                    
                    for(int j = n; j > i; j--){
                        games[j] = new Game("t", "d", "g", 1 ,1);
                        games[j] = games[j-1];
                    }
                    games[i] = new Game(t, d, g, y, p);
                }
                else{
                    games[n] = new Game(t, d, g, y, p);
                }
            }
        }          
        //games[n++] = new Game(t, d, g, y, p);
        n++;

    }

    void search() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter title: ");

        String t = in.nextLine();
        System.out.println("Search "+games[0].title);

        //search and print all the games with the matching title
        
        //for loop over index
        for(int i = 0; i < n; i++){
            if(games[i].title.equals(t))
            {
                //current position title matches with search title print everything in it
                System.out.println("Game "+(i+1));

                System.out.println(games[i].title);

                System.out.println(games[i].developer);

                System.out.println(games[i].genre);

                System.out.println(games[i].year);

                System.out.println(games[i].price);

                System.out.println();
            }
        }

    }

    void delete() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter title: ");

        String t = in.nextLine();

        //delete all the games with the matching title
        for(int i = 0; i < n; i++){
            if(games[i].title.equals(t))
                //current position title matches with search title print everything in it
                for(int j = i; j < n-1; j++)
                    games[j] = games[j+1];
        }
        n--;
    }

    //printing entire list

    void print() {

        for (int i = 0; i < n; i++) {

            System.out.println("Game "+(i+1));

            System.out.println(games[i].title);

            System.out.println(games[i].developer);

            System.out.println(games[i].genre);

            System.out.println(games[i].year);

            System.out.println(games[i].price);

            System.out.println();

        }

    }
}




public class Hw12 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        GameDB myGameList = new GameDB();

        String res;

        do {

            System.out.println();

            System.out.println("i. insert game: ");

            System.out.println("s. search game: ");

            System.out.println("d. delete game: ");

            System.out.println("p. print list: ");


            System.out.println("q. quit: ");

            System.out.println();

            System.out.print("Select: ");

            res = in.next();

            in.nextLine();

            switch (res.charAt(0)) {

            case 'i': case 'I':

            myGameList.insert();

            break;

            case 's': case 'S':

            myGameList.search();

            break;

            case 'd': case 'D':

            myGameList.delete();

            break;

            case 'p': case 'P':

            myGameList.print();

            break;

            case 'q': case 'Q':

            System.out.println("bye");

            break;

            default:

            System.out.println("invalid! Try it again");

            }

        } while (res.charAt(0) != 'q' && res.charAt(0) != 'Q');

    }    
}
