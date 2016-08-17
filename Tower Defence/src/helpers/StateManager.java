package helpers;

import data.Game;
import data.MainMenu;

public class StateManager {
	public static enum GameState {
		MAINMENU, GAME
	}
	
	public static GameState gameState;
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
			
			break;

		default:
			break;
		}
	}
}
