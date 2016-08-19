package data;


import java.util.concurrent.CopyOnWriteArrayList;

import static helpers.Clock.*;

public class Wave {
	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private CopyOnWriteArrayList<Enemy> enemyList;
	private int enemiesPerWave, enemiesSpawned;
	private boolean waveComplete;

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.spawnTime = spawnTime;
		this.enemyType = enemyType;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new CopyOnWriteArrayList<Enemy>();
		this.waveComplete = false;
		this.enemiesSpawned = 0;

		spawn();
	}

	public void update() {
		boolean allEnemiesDead = true;
		if (enemiesSpawned < enemiesPerWave) {
			timeSinceLastSpawn += Delta();
			if (timeSinceLastSpawn > spawnTime) {
				spawn();
				timeSinceLastSpawn = 0;
			}
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				allEnemiesDead = false;
				e.update();
				e.draw();
			}
			else{
				enemyList.remove(e);
			}
		}
		
		if (allEnemiesDead && enemiesSpawned == enemiesPerWave)
			waveComplete = true;
	}

	private void spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getGrid(),
				enemyType.getWidth(), enemyType.getHeight(), enemyType.getSpeed(), enemyType.getHealth()));
		enemiesSpawned++;
	}

	public boolean isCompleted() {
		return waveComplete;
	}

	public CopyOnWriteArrayList<Enemy> getEnemyList() {
		return enemyList;
	}
	
	
}
