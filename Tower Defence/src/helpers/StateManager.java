package helpers;

import data.Game;
import data.MainMenu;
import data.Player;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME, GAMEOVER
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
			if(Player.Lives <= 0){
				game = null;
				gameState = GameState.MAINMENU;
			}
			break;
		case GAMEOVER:
			
			break;
		default:
			break;
		}
	}
	
	public static void setState(GameState newState){
		gameState = newState;
	}
}
