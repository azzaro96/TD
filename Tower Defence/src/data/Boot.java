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
		
		TileGrid grid = new TileGrid(map);
		Enemy e = new Enemy(enemy, grid.getTile(6, 10), 32, 32, 4);
		while(!Display.isCloseRequested()){
			Clock.update();
			e.Update();
			
			grid.Draw();
			e.Draw();
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		
	}
	
}
