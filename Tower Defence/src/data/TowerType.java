package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum TowerType {
	
	greenTower(TextureBank.greenTowerBase, TextureBank.greenTowerCannon, ProjectileType.greenTowerProjectile, 30, 70, 5, 1),
	orangeTower(TextureBank.orangeTowerBase, TextureBank.orangeTowerCannon,ProjectileType.orangeTowerProjectile, 50, 120, 25, 1);
	
	Texture towerBase;
	Texture towerCannon;
	ProjectileType projectileType;
	int dmg, range, cost;
	float attackSpeed;
	
	TowerType(Texture tb, Texture tc,ProjectileType projectileType, int dmg, int range, int cost, float as) {
		towerBase = tb;
		towerCannon = tc;
		this.projectileType = projectileType;
		this.dmg = dmg;
		this.range = range;
		this.attackSpeed = as;
		this.cost = cost;
	}
}
