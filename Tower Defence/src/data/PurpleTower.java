package data;

import java.util.concurrent.CopyOnWriteArrayList;

public class PurpleTower extends Tower {

	public PurpleTower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}	

	@Override
	public void shoot(Enemy target) {
		super.spawnProjectile(ProjectileType.purpleTowerProjectile);
	}

}
