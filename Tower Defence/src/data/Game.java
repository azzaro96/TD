package data;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;

import UI.UI;
import helpers.TextureBank;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI towerPickerUI;

	// Temp variables

	public Game(int[][] map) {
		grid = new TileGrid(map);

		waveManager = new WaveManager(

				new Enemy(TextureBank.basicCreep, grid.getTile(3, 0), grid, TILE_SIZE, TILE_SIZE, 60, 300), 
				0.5f,
				20);
		

		player = new Player(grid, waveManager);
		player.setup();
		setupUI();
	}

	private void updateUI() {
		towerPickerUI.draw();
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (towerPickerUI.isButtonClicked("Orange Tower")) {
					player.pickTower(new OrangeTower(TowerType.orangeTower, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if (towerPickerUI.isButtonClicked("Green Tower")) {
					player.pickTower(new GreenTower(TowerType.greenTower, grid.getTile(2, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	private void setupUI() {
		towerPickerUI = new UI();
		towerPickerUI.addButton("Orange Tower", TextureBank.orangeTowerFull, 0, 0);
		towerPickerUI.addButton("Green Tower", TextureBank.greenTowerFull, TILE_SIZE, 0);
	}

	public void update() {
		grid.draw();
		waveManager.update();
		player.Update();
		towerPickerUI.draw();
		updateUI();
	}
}
