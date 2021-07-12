import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();    
    static ArrayList<Integer> comPositions = new ArrayList<Integer>();
     
    public static void main (String [] args) {
        // Create a Scanner object attached to the keyboard
        // grid print
        char[][] Board = {
                    {' ', '|', ' ', '|', ' '}, 
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '},
                    {'-', '+', '-', '+', '-'},
                    {' ', '|', ' ', '|', ' '}};
         
        printBoard(Board);
         
        //User input requests
        while(true) {
            System.out.println("Enter your placement (1-9):");
            Scanner scan = new Scanner (System.in);
            int UserPos = scan.nextInt();
            
            while(playerPositions.contains(UserPos) || comPositions.contains(playerPositions) || comPositions.contains(UserPos)){
                System.out.println("Position taken! Enter another position:");
                UserPos = scan.nextInt();

                //Prevent replacement
                while(playerPositions.contains(UserPos) || comPositions.contains(UserPos)){
                    System.out.println("Position taken! Enter another position:");
                    UserPos= scan.nextInt();
                }
            }
         
            placePiece(Board, UserPos, "player");
             
            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;            
            }
            //Comp random positions
            Random rand = new Random();
            int comPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(comPos) || comPositions.contains(comPos)){
                comPos = rand.nextInt(9) + 1;
            }
             
            placePiece(Board, comPos, "cpu");
         
            printBoard(Board);
             
            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
 
          }
    public static void placePiece(char[][] Board, int pos, String user){
         
        char letter = ' ';
         
        if(user.equals("player")){
            letter = 'X';
            playerPositions.add(pos);
        } else if(user.equals("cpu")){
            letter = 'O';
            comPositions.add(pos);
        }
 
        switch(pos){
            case 1:
                Board[0][0] = letter;
                break;
            case 2:
                Board[0][2] = letter;
                break;
            case 3:
                Board[0][4] = letter;
                break;
            case 4:
                Board[2][0] = letter;
                break;
            case 5:
                Board[2][2] = letter;
                break;
            case 6:
                Board[2][4] = letter;
                break;
            case 7:
                Board[4][0] = letter;
                break;
            case 8:
                Board[4][2] = letter;
                break;
            case 9:
                Board[4][4] = letter;
                break;                          
            default:
                break;
        }
    }
    public static String checkWinner(){        
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
         
        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(cross1);
        win.add(cross2);
         
        for(List l : win){
            if(playerPositions.containsAll(l)){
                return "Congraduations you won!";
            } else if(comPositions.containsAll(l)){
                return "Computer wins! Sorry!";
            } else if(playerPositions.size() + comPositions.size() == 9){
                return "We are tied!";
            }
        }
         
        return "";       
    }
    public static void printBoard (char [][] Board){ 
        for(char[] row : Board) {
            for(char c : row) {
                System.out.print(c);              
            }
            System.out.println();
        }
    }
}
