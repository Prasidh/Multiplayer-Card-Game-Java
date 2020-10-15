package src;
public class Card {
	
	public int suit;
	public int value;
	
	//Constructors
	public Card() {
		this.suit = -1;
		this.value = -1;
	}
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
	public String getValue() {
		switch(this.value) {
			case 0:
				return "PENALTY";
			case 1:
				return "TWO";
			case 2:
				return "THREE";
			case 3:
				return "FOUR";
			case 4:
				return "FIVE";
			case 5:
				return "SIX";
			case 6:
				return "SEVEN";
			case 7:
				return "EIGHT";
			case 8:
				return "NINE";
			case 9:
				return "TEN";
			case 10:
				return "JACK";
			case 11:
				return "QUEEN";
			case 12:
				return "KING";
			case 13:
				return "ACE";
			default:
				return null;
		}
	}
	
	
}
