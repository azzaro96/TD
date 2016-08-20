package data;

import static helpers.Clock.*;

public class WaveManager {
	private float timeSinceLastWave, timeBetweenWaves, difficultyFactor, difficulty;
	private int waveNumber;
	private CreepType[] creepTypes = {
		CreepType.basicCreep, CreepType.fastCreep, CreepType.tankyCreep, CreepType.bossCreep	
	};
	private Wave currentWave;

	public WaveManager(float timeBetweenWaves) {
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		this.timeBetweenWaves = timeBetweenWaves;
		this.difficultyFactor = 1.3f;
		this.difficulty = 1;
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
		float spawnTime = 0; 
		int numberOfCreeps = 0;
		switch (waveNumber %  creepTypes.length) {
		case 0: // krip
			spawnTime = 1;
			numberOfCreeps = 10;
			break;
		case 1: // brz krip
			spawnTime = 0.5f;
			numberOfCreeps = 10;
			break;
		case 2: //tenki krip
			spawnTime = 0.5f;
			numberOfCreeps = 10;
			break;
		case 3: //boss krip
			spawnTime = 5;
			numberOfCreeps = 5;
			break;

		default:
			break;
		}
		CreepType current = creepTypes[waveNumber % creepTypes.length];
		current.setMaxHealth(current.getMaxHealth()*difficulty);
		currentWave = new Wave(current, spawnTime, numberOfCreeps);
		waveNumber++;
		if (waveNumber % creepTypes.length == 0){
			difficulty *= difficultyFactor;
		}
		
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
