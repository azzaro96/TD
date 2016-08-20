package data;

import static helpers.Artist.drawQuadTex;
import static helpers.Clock.*;
import static helpers.Artist.*;
import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage, range;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Creep> enemies;
	private Creep target;
	private boolean targeted;
	//konstruktor prima dve teksture umesto jedna jer se razlikuje cannon
	//i draw crta dva puta
	
	public TowerCannon(Texture t1, Texture t2, Tile startTile, int dmg, int range, ArrayList<Creep> enemies) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.baseTexture = t1;
		this.cannonTexture = t2;
		this.startTile = startTile;
		this.enemies = enemies;
		this.targeted = false;
		//this.target = acquireTarget();
		//this.angle = calcAngle();
		damage = dmg;
		this.range = range;
		width = (int)startTile.getWidth();
		height = (int)startTile.getHeight();
		firingSpeed = 0.66f;
		timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}
	
	private Creep acquireTarget(){
		Creep closest = null;
		float closestDistance = 10000;
		for(Creep e: enemies) {
			if(isInRange(e) && findDistance(e) < closestDistance) {
				closest = e;
				closestDistance = findDistance(e);
			}
		}
		if(closest != null)
			targeted = true;
		return closest;
	}
	
	private boolean isInRange(Creep e) {
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		if(xDistance <= range && yDistance <= range)
			return true;
		return false;
	}
	
	private float findDistance(Creep e) {
		//zasto ne koristi rastojanje izmedju dve tacke, nesto mi je hm hm
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}
	
	
	private float calcAngle(){
		double angleTemp = Math.atan2(target.getY() - y, target.getX()  - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}
	
	public void shoot() {
		timeSinceLastShot = 0;
		//projectiles.add(new Projectile(quickLoad("bullet"),target, x + TILE_SIZE/4, y + TILE_SIZE/4 ,16,16, 360, 40));
	}
	

	public void update() {
		if(!targeted) {
			target = acquireTarget();
		}
		
		if(target == null || target.isAlive() == false)
			targeted = false;
		
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
		drawQuadTex(baseTexture, x, y, width, height);
		drawQuadTexRot(cannonTexture, x, y, width, height, angle - 60);
	}

	public void updateEnemyList(ArrayList<Creep> enemyList) {
		enemies = enemyList;		
	}
}
