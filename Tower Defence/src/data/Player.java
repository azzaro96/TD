package data;

import static helpers.Artist.HEIGHT;
import static helpers.Artist.TILE_SIZE;

import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;


public class Player {
	public static int Cash, Lives;
	private TileGrid grid;
	private WaveManager waveManager;
	private CopyOnWriteArrayList<Tower> towerList;
	private boolean leftMouseButton = false;
	private boolean rightMouseButton = false;
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.waveManager = waveManager;
		this.towerList = new CopyOnWriteArrayList<Tower>();
	}
	
	public void setup(){
		Cash = 50;
		Lives = 10;
	}
	
	public static boolean modifyCash(int amount){
		if(Cash + amount >= 0){
			Cash += amount;
			System.out.println(Cash);
			return true;
		}
		System.out.println(Cash);
		return false;
		
	}
	
	public static void modifyLives(int amount){
		Lives += amount;
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
			if (modifyCash(-25))
			towerList.add(new OrangeTower(TowerType.orangeTower, grid.getTile( (int) Mouse.getX() / TILE_SIZE, (int) (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), 
					waveManager.getCurrentWave().getEnemyList()));
		}
		if (Mouse.isButtonDown(1) && !rightMouseButton) {
			towerList.add(new GreenTower(TowerType.greenTower, grid.getTile( (int) Mouse.getX() / TILE_SIZE, (int) (HEIGHT - Mouse.getY() - 1) / TILE_SIZE), 
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
