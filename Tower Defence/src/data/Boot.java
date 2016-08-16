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
		Enemy e = new Enemy(enemy, grid.getTile(3, 0), grid, 32, 32, 10);
		Wave wave = new Wave(6, e);
		Player player = new Player(grid);		
		TowerCannon t = new TowerCannon(QuickLoad("TowerBase"), grid.getTile(4, 2), 10);
		TowerCannon t1 = new TowerCannon(QuickLoad("TowerGun"), grid.getTile(4, 2), 10);
		TowerCannon t2 = new TowerCannon(QuickLoad("towerBaseGreen"), grid.getTile(5, 12), 10);
		TowerCannon t3 = new TowerCannon(QuickLoad("towerGunGreen"), grid.getTile(5, 12), 10);
		
		while(!Display.isCloseRequested()){
			Clock.update();
			
			grid.Draw();			
			t.draw();
			t1.draw();
			t2.draw();
			t3.draw();
			
			wave.Update();
			player.Update();
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}
	
}
