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
		
		//
	}
}
