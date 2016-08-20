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
	private UI gameUI;

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
		gameUI.draw();
		gameUI.drawString(650 , 150, "Lives: " + Player.Lives);
		gameUI.drawString(650 , 180, "Cash: " + Player.Cash);
		gameUI.drawString(650, 210, "Wave " + waveManager.getWaveNumber());
		if(player.getWaveManager().getCurrentWave().getEnemyList().size() == 0){
			int nextWaveIn = (int) (player.getWaveManager().getTimeBetweenWaves() - player.getWaveManager().getTimeSinceLastWave());
			gameUI.drawString(650, 240, "Next wave in " + nextWaveIn);
		}
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (gameUI.getMenu("TowerPicker").isButtonClicked("Orange Tower")) {
					player.pickTower(new OrangeTower(TowerType.orangeTower, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if (gameUI.getMenu("TowerPicker").isButtonClicked("Green Tower")) {
					player.pickTower(new GreenTower(TowerType.greenTower, grid.getTile(2, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	private void setupUI() {
		gameUI = new UI();
		
		gameUI.createMenu("TowerPicker", 640, 2*TILE_SIZE, 5*TILE_SIZE, HEIGHT, 2,  0);
		gameUI.getMenu("TowerPicker").addButton(new Button("Orange Tower","" + TowerType.orangeTower.getCost(), TextureBank.orangeTowerFull, 0, 0));
		gameUI.getMenu("TowerPicker").addButton(new Button("Green Tower","" + TowerType.orangeTower.getCost() , TextureBank.greenTowerFull, 0, 0));
		
		gameUI.createMenu("SpeedControl", 640, 270, 2*TILE_SIZE, 3*TILE_SIZE, 3, 0);
		//gameUI.getMenu("SpeedControl").addButton(new Button("Normal", TextureBank.land, 0, 0));
		//gameUI.getMenu("SpeedControl").addButton(new Button("Medium", TextureBank.land, 0, 0));
		//gameUI.getMenu("SpeedControl").addButton(new Button("Fast", TextureBank.land, 0, 0));
	}

	public void update() {
		drawQuadTex(TextureBank.towerPicker,WIDTH - 5 * TILE_SIZE , 0, 5 * TILE_SIZE, HEIGHT);
		grid.draw();
		waveManager.update();
		player.Update();
		gameUI.draw();
		updateUI();
	}

	public Player getPlayer() {
		return player;
	}	
	
	
	
}
