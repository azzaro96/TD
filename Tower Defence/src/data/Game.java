package data;

import static helpers.Artist.*;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private Wave wave;
	
	//Temp variables
	TowerCannon tower;
	
	public Game(int[][] map){
		grid = new TileGrid(map);
		player = new Player(grid);
		wave = new Wave(20, new Enemy(enemy, grid.getTile(3, 0), grid, 32, 32, 10));
		
		tower = new TowerCannon(QuickLoad("TowerBase"), QuickLoad("TowerGun"), grid.getTile(1, 1), 10);
	}
	
	public void update(){
		grid.Draw();
		wave.Update();
		player.Update();
		tower.update();
		
	}
}
