package data;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import helpers.StateManager;
import helpers.StateManager.GameState;

import static helpers.Artist.*;

public class MainMenu {
	
	private Texture background;
	private UI menuUI;
	public MainMenu(){
		background = QuickLoad("mainmenu");
		menuUI = new UI();
		menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.45f));
	}
	
	private void updateButtons(){
		if (Mouse.isButtonDown(0)){
			if(menuUI.isButtonClicked("Play")){
				System.out.println("play clicked");
				StateManager.setState(GameState.GAME);
			}
		}
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, WIDTH, HEIGHT);
		menuUI.draw();
		updateButtons();
	}
}
