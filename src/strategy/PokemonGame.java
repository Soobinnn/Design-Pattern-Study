package strategy;

import java.util.Random;

public class PokemonGame {

	public static void main(String[] args) {
		
		Player1 player1 = new Player1();
		
		System.out.println("야생의 잠만보가 출현했습니다.");
		Random random = new Random();
		
		int ran = random.nextInt(10);
		int prob = player1.getPokemon(new Strategy1());
		
		if(ran <= prob) {
			System.out.println("잠만보를 잡았습니다!");
		} else {
			System.out.println("아쉽게 놓쳤다, 잠만보가 도망쳤다.");
		}

	}
}
