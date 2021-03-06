package domain;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
	private Stack<Card> cardDeck = new Stack<>();

	public CardDeck() {
		cardDeck.addAll(CardFactory.create());
	}

	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

	public Card pop() {
		return cardDeck.pop();
	}
}
