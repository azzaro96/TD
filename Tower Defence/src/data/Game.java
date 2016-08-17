package data;

import static helpers.Artist.*;


public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	
	
	
	//Temp variables
	
	
	public Game(int[][] map){
		grid = new TileGrid(map);
		
		waveManager = new WaveManager(
				new Enemy(quickLoad("creep"), grid.getTile(3, 0), grid, TILE_SIZE, TILE_SIZE, 60, 45), 
				0.5f,
				20);
		
		player = new Player(grid, waveManager);
		
	}
	
	public void update(){
		grid.draw();
		waveManager.update();
		player.Update();	
		
	}
}
