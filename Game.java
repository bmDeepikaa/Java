import java.util.Scanner; //packages

class Guesser
{
	int guessNum()
	{
		System.out.println("Guesser guess a number");
		Scanner sc = new Scanner(System.in);
		int gnum = sc.nextInt();
		return gnum;
	}
}
class Player
{
	int guessNum()
	{
		System.out.println("Player guess a number");
		Scanner sc = new Scanner(System.in);
		int pnum = sc.nextInt();
		return pnum;
	}
}

class Referee
{
    int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;

	void askGuesser()
	{
		Guesser akhil = new Guesser();
		numFromGuesser = akhil.guessNum();
	}

	void askPlayers()
	{
		Player ryan = new Player();
		Player deeps = new Player();
		Player dee = new Player();

		numFromPlayer1 = ryan.guessNum();
		numFromPlayer2 = deeps.guessNum();
		numFromPlayer3 = dee.guessNum();
	}
	void CheckNum()	
	{
		if(numFromPlayer1 == numFromGuesser && numFromPlayer2 == numFromGuesser && numFromPlayer3 == numFromGuesser)
		{
			System.out.println("All players win");
		}
		else if(numFromPlayer1 == numFromGuesser && numFromPlayer2 == numFromGuesser)
		{
			System.out.println("Player 1 and 2 is the winner");
		}

		else if(numFromPlayer1 == numFromGuesser &&  numFromPlayer3 == numFromGuesser)
		{
			System.out.println("Player 1 and 3 is the winner");

		}
        else if(numFromPlayer2 == numFromGuesser && numFromPlayer3 == numFromGuesser)
		{
			System.out.println("Player 2 and 3 win");
		}
		else if(numFromPlayer1 == numFromGuesser )
		{
			System.out.println("Player 1 wins");
		}
		else if(numFromPlayer2 == numFromGuesser  )
		{
			System.out.println("Player 2 wins");
		}
		else if(numFromPlayer3 == numFromGuesser)
		{
			System.out.println("Player 3 win");
		}
		
		else
		{
			System.out.println("Game Ended");
		}	
	}
}


class Game
{
	public static void main(String[] args)
	{
		Referee xavier = new Referee();
		xavier.askGuesser();
		xavier.askPlayers();
		xavier.CheckNum();
	}
}
