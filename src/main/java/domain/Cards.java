package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
	private static final int BLACKJACK_SIZE = 2;
	private static final int BLACKJACK_SCORE = 21;

	private List<Card> cards;

	public Cards() {
		this.cards = new ArrayList<>();
	}

	public int getSize() {
		return cards.size();
	}

	public int getScore() {
		Score score = Score.ZERO;
		for (Card card : cards) {
			score = score.add(card.getPoint());
		}
		if (hasAce()) {
			score = score.addAceBonusIfNotBust();
		}
		return score.getValue();
	}

	public List<Card> getValue() {
		return Collections.unmodifiableList(cards);
	}

	public boolean hasAce() {
		return cards.stream().anyMatch(Card::isAce);
	}

	public boolean isBlackJack() {
		return (cards.size() == BLACKJACK_SIZE) && (getScore() == BLACKJACK_SCORE);
	}

	public boolean isBust() {
		return getScore() > BLACKJACK_SCORE;
	}

	public boolean isLessThan(int criteria) {
		return getScore() <= criteria;
	}

	public void addCard(Card card) {
		cards.add(card);
	}
}