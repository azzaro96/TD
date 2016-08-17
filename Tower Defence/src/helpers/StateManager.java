package helpers;

import data.Game;
import data.MainMenu;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME
	}
	
	static int map[][] = {
			{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0}, 
			{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0},
			{0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
			{0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
			{0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Game game;
	
	public static void update() {
		switch (gameState) {
		case MAINMENU:
			if (mainMenu == null)
				mainMenu = new MainMenu();
			mainMenu.update();
			break;
		case GAME:
			if (game == null)
				game = new Game(map);
			game.update();
			break;

		default:
			break;
		}
	}
	
	public static void setState(GameState newState){
		gameState = newState;
	}
}
