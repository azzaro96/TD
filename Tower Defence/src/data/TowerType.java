package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum TowerType {
	
	greenTower(TextureBank.greenTowerBase, TextureBank.greenTowerCannon, ProjectileType.greenTowerProjectile, 50, 70, 5, 1),
	orangeTower(TextureBank.orangeTowerBase, TextureBank.orangeTowerCannon,ProjectileType.orangeTowerProjectile, 100, 120, 25, 1);
	
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

	public Texture getTowerBase() {
		return towerBase;
	}

	public Texture getTowerCannon() {
		return towerCannon;
	}

	public ProjectileType getProjectileType() {
		return projectileType;
	}

	public int getDmg() {
		return dmg;
	}

	public int getRange() {
		return range;
	}

	public int getCost() {
		return cost;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}
	
	
	
	
}
