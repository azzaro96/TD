package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;
import static helpers.Artist.*;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Enemy> enemies;
	private Enemy target;
	//konstruktor prima dve teksture umesto jedna jer se razlikuje cannon
	//i draw crta dva puta
	
	public TowerCannon(Texture t1, Texture t2, Tile startTile, int dmg, ArrayList<Enemy> enemies) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.baseTexture = t1;
		this.cannonTexture = t2;
		this.startTile = startTile;
		this.enemies = enemies;
		this.target = acquireTarget();
		this.angle = calcAngle();
		damage = dmg;
		width = (int)startTile.getWidth();
		height = (int)startTile.getHeight();
		firingSpeed = 0.66f;
		timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}
	
	private Enemy acquireTarget(){
		return enemies.get(0);
	}
	
	private float calcAngle(){
		double angleTemp = Math.atan2(target.getY() - y, target.getX()  - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}
	
	public void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"),target, x + Game.TILE_SIZE/4, y + Game.TILE_SIZE/4 , 360, 40));
	}
	
	public void update() {
		timeSinceLastShot += Delta();
		if(timeSinceLastShot > firingSpeed)
			shoot();
		
		for(Projectile p: projectiles) {
			p.update();
		}
		angle = calcAngle();
		draw();
	}
	
	public void draw() {
		DrawQuadTex(baseTexture, x, y, width, height);
		DrawQuadTexRot(cannonTexture, x, y, width, height, angle - 60);
	}
}
