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
		int numPlayers = -1;
		do {
			
			try {
				System.out.print("Enter number of players (2-4): " );
				numPlayers = intReader.nextInt();
			}catch(Exception e) {
				intReader.next();
				continue;
			}
		}while(numPlayers <2 || numPlayers >4);
		
		//Create unique identifiers for each player
		String [] playerNames = new String[numPlayers];
		for(int i = 0; i< numPlayers; i++) {
			
			try {
				System.out.print("Enter Player "+ (i+1) +"'s name: ");
				playerNames[i] = strReader.nextLine();
			} catch (Exception e) {
				strReader.next();
				i--;
				continue;
			}
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
		int roundCounter = 1;
		
		gameRunning: {
			while(true) {	
			
				System.out.println("-----------------------\n"
						+          "\tROUND " + roundCounter + "\t\n"
								+  "-----------------------");
				
				
				//Each player draws a card randomly
				Random randNum = new Random();
				
				//Hashset is used so that duplicate cards cannot be picked
				Set<Integer> pickedCardsIndex = new LinkedHashSet<Integer>();
				
				//Store indexes of "randomly" drawn cards
				for(int i = 0; i< numPlayers; i++) {
					int currentCard;
					do {
						currentCard = randNum.nextInt(56);
						pickedCardsIndex.add(currentCard);
					} while(pickedCardsIndex.size() != i+1); //ensures no duplicates
					
					if(cardDeck.get(currentCard).value != 0) {
						System.out.println(playerNames[i] + " drew the " + cardDeck.get(currentCard).getValue() +
							" of " + cardDeck.get(currentCard).getSuit());
					}else {
						System.out.println(playerNames[i] + " drew the " + cardDeck.get(currentCard).getValue());
					}
				}
				
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
							maxIndex = pickedIndexes[i];
							winnerIndex = i;
						}
					}
				}
				
				System.out.println("The winner of round " + roundCounter+ " is " + playerNames[winnerIndex] + "!");
				
				//Round is over, now we compute scores
				playerScores[winnerIndex]+=2; //winner gets 2
				
				//see if anyone got penalty
				for(int i = 0; i< numPlayers; i++) {
					if(cardDeck.get(pickedIndexes[i]).value == 0) {
						playerScores[i]-=1; //penalty loses a point
					}
				}
				
				System.out.println("Current Standings:");
				//Display updated scores
				for(int i = 0; i<numPlayers; i++) {
					System.out.print(playerNames[i] + ": " + playerScores[i] + ", ");
				}
				System.out.println();
				
				//WIN CHECKING (Fixed)
				int topScoreIndex = -1;
				for(int i = 0; i<numPlayers; i++) {
					if(i == 0) {
						topScoreIndex = 0;
					}
					if(playerScores[i] > playerScores[topScoreIndex]) {
						topScoreIndex = i;
					}
				}
				if(playerScores[topScoreIndex] >= 21) {
					for(int i = 0; i<numPlayers; i++) {
						if(playerScores[i] == playerScores[topScoreIndex] - 1 ||
								(playerScores[i] == playerScores[topScoreIndex] && i != topScoreIndex)) {
							break;
						}
						if( i == numPlayers - 1) { //winner has been found
							System.out.println(playerNames[topScoreIndex] + " HAS WON THE GAME!!!");
							break gameRunning;
						}
					}
				}
				
				roundCounter++;
				System.out.println("Press enter to continue to next round...");
				strReader.nextLine();
			} //while loop
		} //label
			
		intReader.close();
		strReader.close();
	}
}
