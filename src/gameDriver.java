import java.util.Scanner;
public class gameDriver {
	
	
	public static void main(String[] args) {
		
		//Initialize scanners
		Scanner intReader = new Scanner(System.in);
		Scanner strReader = new Scanner(System.in);
		
		//Take number of players as input
		System.out.print("Enter number of players (2-4): " );
		int numPlayers = intReader.nextInt();
		
		//Create unique identifiers for each player
		String [] playerNames = new String[numPlayers];
		for(int i = 0; i< numPlayers; i++) {
			
			System.out.print("Enter Player "+ (i+1) "'s name: ");
			playerNames[i] = strReader.nextLine();
		}
		
		//Initialize deck as 2D Matrix
		Card [][] cardDeck = new Card[4][13];
		for (int i = 0; i<4; i++) {
			for (int j = 0; j < 14; j++) {
				
				cardDeck[i][j] = new Card(i,j);
				
			}
		}
		
		//BEGIN GAME
		//First, generate array to store scores
		int [] playerScores = new int[numPlayers];
		while(true) {
			
			//Each player draws a card
			Card [] currentRound = new Card[numPlayers];
			for(int i = 0; i< numPlayers; i++) {
				
				//generate random values ("shuffling")
				int randSuit = (int)(Math.random()*4);
				int randVal = (int)(Math.random()*14);
				
				
				currentRound[i] = cardDeck[randSuit, randVal];
			}
			
			int winnerIndex = getWinner(currentRound);
		}
	}
}
