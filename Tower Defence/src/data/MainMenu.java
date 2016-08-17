package data;

import org.newdawn.slick.opengl.Texture;

import UI.UI;

import static helpers.Artist.*;

public class MainMenu {
	
	private Texture background;
	private UI menuUI;
	public MainMenu(){
		background = QuickLoad("mainmenu");
		menuUI = new UI();
		menuUI.addButton("Play", "playButton", WIDTH / 2 - 128, (int) (HEIGHT * 0.45f));
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1024);
	}
}
