package helpers;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
public class TextureBank {
	public static final Texture
	
	//Toweri
	greenTowerBase = quickLoad("TowerBaseGreen"),
	greenTowerCannon = quickLoad("towerGunGreen"),
	orangeTowerBase = quickLoad("TowerBase"),
	orangeTowerCannon = quickLoad("TowerGun"),
	
	//Projektili
	greenProjectile = quickLoad("bullet"),
	orangeProjectile = quickLoad("bullet"),
	
	//Kripovi
	basicCreep = quickLoad("creep"),
	
	//Mapa
	land = quickLoad("land"),
	road = quickLoad("Road"),
	
	//MainMenu
	splashScreen = quickLoad("splash"),
	playButton = quickLoad("play"),
	
	//In-Game Menu
	towerPicker = quickLoad("towerPickerBG"),
	
	//HealthBars
	healthBarGreen = quickLoad("healthBarGreen"),
	healthBarYellow = quickLoad("healthBarYellow"),
	healthBarRed = quickLoad("healthBarRed");
	
	
}
