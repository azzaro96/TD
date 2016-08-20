package data;

import static helpers.Artist.*;

import UI.Button;

import org.lwjgl.input.Mouse;

import UI.UI;
import helpers.TextureBank;

public class Game {

	public static TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI gameUI;

	// Temp variables

	public Game(int[][] map) {
		grid = new TileGrid(map);

		waveManager = new WaveManager(10);

		player = new Player(grid, waveManager);
		player.setup();
		setupUI();
	}

	private void updateUI() {
		gameUI.draw();
		gameUI.getMenu("Info").getMenuButton("Lives").setCaption(""+Player.Lives);
		gameUI.getMenu("Info").getMenuButton("Gold").setCaption(""+Player.Cash);
		gameUI.getMenu("Info").getMenuButton("Wave").setCaption(""+player.getWaveManager().getWaveNumber());
		//gameUI.drawString(650 , 180, "Cash: " + Player.Cash);
		//gameUI.drawString(650, 210, "Wave " + waveManager.getWaveNumber());
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
					player.pickTower(new GreenTower(TowerType.greenTower, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
				if (gameUI.getMenu("TowerPicker").isButtonClicked("Purple Tower")) {
					player.pickTower(new PurpleTower(TowerType.purpleTower, grid.getTile(2, 0),
							waveManager.getCurrentWave().getEnemyList()));
				}
			}
		}
	}

	private void setupUI() {
		gameUI = new UI();
		
		gameUI.createMenu("TowerPicker", 640, TILE_SIZE, TILE_SIZE, HEIGHT, 1,  0);
		gameUI.getMenu("TowerPicker").addButton(new Button("Orange Tower","" + TowerType.orangeTower.getCost(), TextureBank.orangeTowerFull, 0, 0));
		gameUI.getMenu("TowerPicker").addButton(new Button("Green Tower","" + TowerType.greenTower.getCost() , TextureBank.greenTowerFull, 0, 0));
		gameUI.getMenu("TowerPicker").addButton(new Button("Purple Tower","" + TowerType.purpleTower.getCost() , TextureBank.purpleTowerFull, 0, 0));
		
		gameUI.createMenu("Info", 640, 7*TILE_SIZE, TILE_SIZE, TILE_SIZE, 1, 0);
		gameUI.getMenu("Info").addButton(new Button("Lives","" + Player.Lives, TextureBank.heart, 0, 0));
		gameUI.getMenu("Info").addButton(new Button("Gold","" + Player.Cash, TextureBank.coin, 0, 0));
		gameUI.getMenu("Info").addButton(new Button("Wave","" + player.getWaveManager().getWaveNumber(), TextureBank.road, 0, 0));
	}

	public void update() {
		drawQuadTex(TextureBank.towerPicker, 640, 0, TILE_SIZE, HEIGHT + 32);
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
