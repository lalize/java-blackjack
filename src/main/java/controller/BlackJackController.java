package controller;

import domain.BettingMoney;
import domain.BettingMoneys;
import domain.CardDeck;
import domain.Dealer;
import domain.Player;
import domain.Players;
import domain.PlayersFactory;
import domain.Profits;
import domain.WhetherAddCard;
import view.InputView;
import view.OutputView;

public class BlackJackController {
	private static final int DISTRIBUTE_CARD_SIZE = 2;

	private CardDeck cardDeck;
	private Dealer dealer;
	private Players players;
	private BettingMoneys bettingMoneys;

	public BlackJackController(String inputNames) {
		this.cardDeck = new CardDeck();
		this.dealer = new Dealer();
		this.players = PlayersFactory.create(inputNames);
		this.bettingMoneys = new BettingMoneys();
	}

	public void run() {
		cardDeck.shuffle();
		betting();
		distributeTwoCard();
		if (dealer.isNotBlackJack()) {
			askMoreCard();
			addCardIfNeed();
		}
		OutputView.printCardsResults(dealer, players);
		OutputView.printProfits(Profits.calculate(dealer, players, bettingMoneys));
	}

	private void betting() {
		players.forEach(player -> bettingMoneys.betting(player,
				BettingMoney.from(InputView.inputBettingMoney(player.getName()))));
	}

	private void distributeTwoCard() {
		for (int i = 0; i < DISTRIBUTE_CARD_SIZE; i++) {
			dealer.giveCard(cardDeck, dealer);
			dealer.giveCard(cardDeck, players);
		}
		OutputView.printFirstDistribute(dealer, players);
	}

	private void askMoreCard() {
		players.forEach(this::addCardIfWant);
	}

	private void addCardIfWant(Player player) {
		while (player.isNotBust() && WhetherAddCard.of(InputView.inputMoreCard(player)).isYes()) {
			dealer.giveCard(cardDeck, player);
			OutputView.printCards(player.getName(), player.getCards());
		}
	}

	private void addCardIfNeed() {
		while (dealer.shouldAddCard()) {
			dealer.addCard(cardDeck.pop());
			OutputView.printDealerAddCard();
		}
	}
}