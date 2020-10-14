
public class Card {
	
	public int suit;
	public int value;
	
	//Constructor
	public Card(int suit, int value) {
		
		this.suit = suit;
		this.value = value;
	}
	
	//Getter method for a card's suit
	public String getSuit(Card card) {
		switch(card.suit) {
			case 0:
				return "CLUBS";
			case 1:
				return "DIAMONDS";
			case 2:
				return "HEARTS";
			case 3:
				return "SPADES";
			default:
				return null;
			
		}
		
		
	}
	
	//Getter method for a card's value
	public String getValue(Card card) {
		switch(card.value) {
			case 0:
				return "TWO";
			case 1:
				return "THREE";
			case 2:
				return "FOUR";
			case 3:
				return "FIVE";
			case 4:
				return "SIX";
			case 5:
				return "SEVEN";
			case 6:
				return "EIGHT";
			case 7:
				return "NINE";
			case 8:
				return "TEN";
			case 9:
				return "JACK";
			case 10:
				return "QUEEN";
			case 11:
				return "KING";
			case 12:
				return "ACE";
			case 13:
				return "PENALTY";
			default:
				return null;
		}
	}
	
	
}
