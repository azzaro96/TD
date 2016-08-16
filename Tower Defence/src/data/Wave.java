package data;

import java.util.ArrayList;

import static helpers.Clock.*;

public class Wave {
	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;
	private boolean waveComplete;

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.spawnTime = spawnTime;
		this.enemyType = enemyType;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new ArrayList<Enemy>();
		this.waveComplete = false;

		Spawn();
	}

	public void Update() {
		boolean allEnemiesDead = true;
		if (enemyList.size() < enemiesPerWave) {
			timeSinceLastSpawn += Delta();
			if (timeSinceLastSpawn > spawnTime) {
				Spawn();
				timeSinceLastSpawn = 0;
			}
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				allEnemiesDead = false;
				e.Update();
				e.Draw();
			}
		}
		
		if (allEnemiesDead)
			waveComplete = true;
	}

	private void Spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getGrid(),
				enemyType.getWidth(), enemyType.getHeight(), enemyType.getSpeed()));
	}

	public boolean isCompleted() {
		return waveComplete;
	}

}
