package data;

import static helpers.Artist.*;

import UI.Button;

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
		towerPickerUI.drawString(660 , 150, "Lives: " + Player.Lives);
		towerPickerUI.drawString(660 , 180, "Cash: " + Player.Cash);
		towerPickerUI.drawString(660, 210, "Wave " + waveManager.getWaveNumber());
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (towerPickerUI.getMenu("TowerPicker").isButtonClicked("Orange Tower")) {
					player.pickTower(new OrangeTower(TowerType.orangeTower, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if (towerPickerUI.getMenu("TowerPicker").isButtonClicked("Green Tower")) {
					player.pickTower(new GreenTower(TowerType.greenTower, grid.getTile(2, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	private void setupUI() {
		towerPickerUI = new UI();

		//towerPickerUI.addButton("Orange Tower", TextureBank.orangeTowerBase, 0, 0);
		//towerPickerUI.addButton("Green Tower", TextureBank.greenTowerBase, TILE_SIZE, 0);
		towerPickerUI.createMenu("TowerPicker", 640, 2*TILE_SIZE, 3*TILE_SIZE, HEIGHT, 2,  0);
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("Orange Tower", TextureBank.orangeTowerFull, 0, 0));
		towerPickerUI.getMenu("TowerPicker").addButton(new Button("Green Tower", TextureBank.greenTowerFull, 0, 0));

	}

	public void update() {
		drawQuadTex(TextureBank.towerPicker,WIDTH - 3 * TILE_SIZE , 0, 3 * TILE_SIZE, HEIGHT);
		grid.draw();
		waveManager.update();
		player.Update();
		towerPickerUI.draw();
		updateUI();
	}
}
