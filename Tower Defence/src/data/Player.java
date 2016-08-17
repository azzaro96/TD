package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private TileGrid grid;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private boolean leftMouseButton = false;
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();
	}
	
	

	public void SetTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / 32), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 32),
				TileType.Road);
	}

	public void Update() {

		for (TowerCannon t : towerList) {
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}

		// Mouse input
		if (Mouse.isButtonDown(0) && !leftMouseButton) {
			towerList.add(new TowerCannon(QuickLoad("TowerBase"), QuickLoad("TowerGun"), grid.getTile( (int) Mouse.getX() / 32, (int) (HEIGHT - Mouse.getY() - 1) / 32), 70, 1000,
					waveManager.getCurrentWave().getEnemyList()));
			
			//SetTile();
		}
		
		leftMouseButton = Mouse.isButtonDown(0);
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
