package helpers;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
public class TextureBank {
	public static final Texture
	
	//Toweri
	greenTowerBase = quickLoad("towerBaseGreen"),
	greenTowerCannon = quickLoad("towerGunGreen"),
	orangeTowerBase = quickLoad("TowerBase"),
	orangeTowerCannon = quickLoad("TowerGun"),
	greenTowerFull = quickLoad("greenTowerFull"),
	orangeTowerFull = quickLoad("orangeTowerFull"),
	purpleTowerBase = quickLoad("purpleTowerBase"),
	purpleTowerCannon = quickLoad("purpleTowerCannon"),
	purpleTowerFull = quickLoad("purpleTowerFull"),
	
	Range = quickLoad("Range"),
	
	//Projektili
	greenProjectile = quickLoad("greenBullet"),
	orangeProjectile = quickLoad("bullet"),
	purpleProjectile = quickLoad("purpleBullet"),
	
	//Kripovi
	creepRose = quickLoad("creep"),
	creepBlue = quickLoad("creepBlue"),
	creepBoss = quickLoad("creepBoss"),
	creepPurple = quickLoad("creepPurple"),
	
	//Mapa
	land = quickLoad("Land"),
	road = quickLoad("Road"),
	
	//MainMenu
	splashScreen = quickLoad("splash"),
	playButton = quickLoad("play"),
	splashScreenEnd = quickLoad("splashEnd"),
	
	//In-Game Menu
	towerPicker = quickLoad("towerPickerBG"),
	coin = quickLoad("coin"),
	heart = quickLoad("heart"),
	
	//HealthBars
	healthBarGreen = quickLoad("healthBarGreen"),
	healthBarYellow = quickLoad("healthBarYellow"),
	healthBarRed = quickLoad("healthBarRed");
	
	
}
