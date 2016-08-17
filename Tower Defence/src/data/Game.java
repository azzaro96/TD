package data;

import static helpers.Artist.*;


public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private TowerCannonBlue blue;
	
	
	
	//Temp variables
	
	
	public Game(int[][] map){
		grid = new TileGrid(map);
		
		waveManager = new WaveManager(
				new Enemy(quickLoad("creep"), grid.getTile(3, 0), grid, TILE_SIZE, TILE_SIZE, 60, 45), 
				0.5f,
				20);
		
		player = new Player(grid, waveManager);
		blue = new TowerCannonBlue(quickLoad("towerBaseGreen"), quickLoad("towerGunGreen"), 128, 128, 32, 32);
	}
	
	public void update(){
		grid.draw();
		blue.draw();
		waveManager.update();
		player.Update();	
		
	}
}
