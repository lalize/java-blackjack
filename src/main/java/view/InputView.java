package view;

import java.util.Scanner;

import domain.Player;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static String inputNames() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
		return SCANNER.nextLine();
	}

	public static String inputMoreCard(Player player) {
		System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
		return SCANNER.nextLine();
	}
}
