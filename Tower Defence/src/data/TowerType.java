package data;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

public enum TowerType {
	
	greenTower(quickLoad("towerBaseGreen"), quickLoad("towerGunGreen"), 30, 1000, 1),
	orangeTower(quickLoad("TowerBase"), quickLoad("TowerGun"), 50, 1000, 1);
	
	Texture towerBase;
	Texture towerCannon;
	int dmg, range;
	float attackSpeed;
	
	TowerType(Texture tb, Texture tc, int dmg, int range, float as) {
		towerBase = tb;
		towerCannon = tc;
		this.dmg = dmg;
		this.range = range;
		this.attackSpeed = as;
	}
}
