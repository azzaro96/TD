package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
public class MainMenu {
	
	private Texture background;
	
	public MainMenu(){
		background = QuickLoad("mainmenu");
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1024);
	}
}
