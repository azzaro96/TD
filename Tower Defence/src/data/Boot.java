package data;

import helpers.*;
import static helpers.Artist.BeginSession;
import static helpers.Artist.DrawQuad;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.Quadric;
import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public class Boot {

	public static void main(String[] args) {
		
		BeginSession();
		//Test
		int map[][] = {
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
		
		Game game = new Game(map);
		while(!Display.isCloseRequested()){
			Clock.update();

			game.update();
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}
	
}
