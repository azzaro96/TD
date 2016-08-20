package data;

import static helpers.Clock.*;

public class WaveManager {
	private float timeSinceLastWave, timeBetweenEnemies, timeBetweenWaves;
	private int waveNumber, enemiesPerWave;
	private Enemy enemyType;
	private Wave currentWave;

	public WaveManager(Enemy enemyType, float timeBetweenEnemies, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		this.timeBetweenWaves = 7;
		this.currentWave = null;

		newWave();
	}

	public void update() {
		if (!currentWave.isCompleted()) {
			currentWave.update();
		} else {
			timeSinceLastWave += Delta();
			if (timeBetweenWaves <= timeSinceLastWave) {
				newWave();
				timeSinceLastWave = 0;
			}
		}
	}

	public void newWave() {
		currentWave = new Wave(enemyType, timeBetweenEnemies, enemiesPerWave);
		waveNumber++;
		System.out.println("Pocinje " + waveNumber + ". talas");
	}

	public Wave getCurrentWave() {
		return currentWave;
	}

	public int getWaveNumber() {
		return waveNumber;
	}

	public float getTimeSinceLastWave() {
		return timeSinceLastWave;
	}

	public float getTimeBetweenWaves() {
		return timeBetweenWaves;
	}
	
	
	
	

}
