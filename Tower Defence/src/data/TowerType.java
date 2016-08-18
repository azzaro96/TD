package data;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.Texture;

public enum TowerType {
	
	greenTower(quickLoad("towerBaseGreen"), quickLoad("towerGunGreen"), 30),
	orangeTower(quickLoad("TowerBase"), quickLoad("TowerGun"), 50);
	
	Texture towerBase;
	Texture towerCannon;
	int dmg;
	
	TowerType(Texture tb, Texture tc, int dmg) {
		towerBase = tb;
		towerCannon = tc;
		this.dmg = dmg;
	}
}
