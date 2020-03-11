package factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Player;

public class PlayerFactory {
	private static final String NAME_DELIMITER = ",";

	public static List<Player> create(String userInput) {
		return Arrays.stream(userInput.split(NAME_DELIMITER))
				.map(Player::new)
				.collect(Collectors.toList());
	}
}
