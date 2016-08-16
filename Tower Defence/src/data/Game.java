package data;

import static helpers.Artist.*;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	
	//Temp variables
	TowerCannon tower;
	
	public Game(int[][] map){
		grid = new TileGrid(map);
		player = new Player(grid);
		waveManager = new WaveManager(
				new Enemy(QuickLoad("creep"), grid.getTile(3, 0), grid, 32, 32, 240), 
				0.5f,
				10);
		tower = new TowerCannon(QuickLoad("TowerBase"), QuickLoad("TowerGun"), grid.getTile(1, 1), 10);
	}
	
	public void update(){
		grid.Draw();
		waveManager.update();
		player.Update();
		tower.update();
		
	}
}
