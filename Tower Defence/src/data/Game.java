package data;

import static helpers.Artist.*;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	
	public static final int TILE_SIZE = 32;
	
	//Temp variables
	
	
	public Game(int[][] map){
		grid = new TileGrid(map);
		
		waveManager = new WaveManager(
				new Enemy(QuickLoad("creep"), grid.getTile(3, 0), grid, 32, 32, 240), 
				0.5f,
				10);
		
		player = new Player(grid, waveManager);
		
	}
	
	public void update(){
		grid.Draw();
		waveManager.update();
		player.Update();
		
		
	}
}
