package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;
import static helpers.Artist.*;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	
	//konstruktor prima dve teksture umesto jedna jer se razlikuje cannon
	//i draw crta dva puta
	
	public TowerCannon(Texture t1, Texture t2, Tile startTile, int dmg) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.baseTexture = t1;
		this.cannonTexture = t2;
		this.startTile = startTile;
		damage = dmg;
		width = (int)startTile.getWidth();
		height = (int)startTile.getHeight();
		firingSpeed = 10;
		timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}
	
	public void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"), x + 16, y + 16 , 5, 10));
	}
	
	public void update() {
		timeSinceLastShot += Delta();
		if(timeSinceLastShot > firingSpeed)
			shoot();
		
		for(Projectile p: projectiles) {
			p.update();
		}
		
		draw();
	}
	
	public void draw() {
		DrawQuadTex(baseTexture, x, y, width, height);
		DrawQuadTex(cannonTexture, x, y, width, height);
	}
}
