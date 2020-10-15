package src;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
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
			
			System.out.print("Enter Player "+ (i+1) +"'s name: ");
			playerNames[i] = strReader.nextLine();
		}
		
		//Initialize deck as ArrayList
		ArrayList<Card> cardDeck = new ArrayList<Card>();
		for(int i = 0; i<14; i++) {
			for (int j = 0; j < 4; j++) {
				
				Card newCard = new Card(j,i);
				cardDeck.add(newCard);
			}
		}
		
		//BEGIN GAME
		//First, generate array to store scores
		
		int [] playerScores = new int[numPlayers];
		
		//while(true) {
			
			//Each player draws a card randomly
			Random randNum = new Random();
			
			//Hashset is used so that duplicate cards cannot be picked
			Set<Integer> pickedCardsIndex = new LinkedHashSet<Integer>();
			
			//Store indexes of "randomly" drawn cards
			for(int i = 0; i< numPlayers; i++) {
				pickedCardsIndex.add(randNum.nextInt(56));
			}
			System.out.println(pickedCardsIndex);
			
			//Now, iterate over the indexes of cards picked
			Iterator<Integer> itr = pickedCardsIndex.iterator();
			
			//First, store picked cards in array
			int [] pickedIndexes = new int[numPlayers];
			for(int i = 0; i< numPlayers; i++) {
				pickedIndexes[i] = itr.next();
			}
			
			//Now, we compute the max card and who has it
			int maxIndex = -1; //stores index of winning card in cardDeck
			int winnerIndex = -1; //stores index of winning player in playerNames
			for(int i = 0; i<numPlayers; i++) {
				
				if(i == 0) {
					maxIndex = pickedIndexes[i];
					winnerIndex = 0;
				}
				else {
					if(pickedIndexes[i] > maxIndex) {
						
					}
				}
			}
			
			//System.out.println("THE WINNER IS " + playerNames[]);
			
		//}
			
		intReader.close();
		strReader.close();
	}
}
