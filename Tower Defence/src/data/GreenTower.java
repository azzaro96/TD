package data;

import java.util.concurrent.CopyOnWriteArrayList;

// Ovako od sad gradimo towere

public class GreenTower extends Tower {
	
	public GreenTower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}

	@Override
	
	/**
	 * samo skracena verzija
	 */
	public void shoot(Enemy target) {
		super.spawnProjectile(ProjectileType.greenTowerProjectile);
	}
}
