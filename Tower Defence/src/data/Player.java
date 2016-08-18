package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;


public class Player {
	private TileGrid grid;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButton = false;
	private boolean rightMouseButton = false;
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
	}
	
	

	public void SetTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / TILE_SIZE), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / TILE_SIZE),
				TileType.Road);
	}

	public void Update() {

		for (Tower t : towerList) {
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}

		// Mouse input
		if (Mouse.isButtonDown(0) && !leftMouseButton) {
			towerList.add(new TowerCannonBlue(TowerType.orangeTower, grid.getTile( (int) Mouse.getX() / TILE_SIZE, (int) (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), 
					waveManager.getCurrentWave().getEnemyList()));
		}
		if (Mouse.isButtonDown(1) && !rightMouseButton) {
			towerList.add(new TowerCannonBlue(TowerType.greenTower, grid.getTile( (int) Mouse.getX() / TILE_SIZE, (int) (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), 
					waveManager.getCurrentWave().getEnemyList()));
		}
		
		leftMouseButton = Mouse.isButtonDown(0);
		rightMouseButton = Mouse.isButtonDown(1);
		// KeyBoard input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.2f);
			}
		}
	}
}
