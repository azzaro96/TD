package data;

import java.util.concurrent.CopyOnWriteArrayList;
import static helpers.Artist.*;

public class BlueTower extends AoeTower {

	public BlueTower(TowerType type, Tile startTile, CopyOnWriteArrayList<Creep> enemies) {
		super(type, startTile, enemies);
	}

	@Override
	public void shoot(Creep target) {
		spawnProjectile(ProjectileType.blueTowerProjectileLVL1);
	}

	
	
	
	
}
