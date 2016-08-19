package data;

import static helpers.Artist.TILE_SIZE;
import static helpers.Artist.drawQuadTex;
import static helpers.Artist.drawQuadTexRot;
import static helpers.Artist.quickLoad;
import static helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.opengl.Texture;

public abstract class Tower implements Entity {

	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage, range, towerCost;
	private Enemy target;
	private Texture baseTexture, cannonTexture;
	private CopyOnWriteArrayList<Enemy> enemies;
	public ArrayList<Projectile> projectiles;
	private boolean targeted;

	public Tower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		baseTexture = type.towerBase;
		cannonTexture = type.towerCannon;
		this.damage = type.dmg;
		this.range = type.range;
		this.firingSpeed = type.attackSpeed;
		this.angle = 0f;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.enemies = enemies;
		this.targeted = false;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}

	// stavio sam da crta iz dva dela, on crta sam bbazu (izgleda)

	private Enemy acquireTarget() {
		Enemy closest = null;
		float closestDistance = 10000;
		for (Enemy e : enemies) {
			if (isInRange(e) && findDistance(e) < closestDistance && e.isAlive()) {
				closest = e;
				closestDistance = findDistance(e);
			}
		}
		if (closest != null)
			targeted = true;
		return closest;
	}

	private float findDistance(Enemy e) {
		// zasto ne koristi rastojanje izmedju dve tacke, nesto mi je hm hm
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}

	private boolean isInRange(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		if (xDistance <= range && yDistance <= range)
			return true;
		return false;
	}

	private float calcAngle() {
		double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}

	public abstract void shoot(Enemy target);

	public void updateEnemyList(CopyOnWriteArrayList<Enemy> enemyList) {
		enemies = enemyList;
	}

	public void update() {
		if (!targeted) {
			target = acquireTarget();
		} else {
			angle = calcAngle() - 50;
			if (timeSinceLastShot > firingSpeed) {
				shoot(target);
				timeSinceLastShot = 0;
			}
		}

		if (target == null || target.isAlive() == false)
			targeted = false;

		if (targeted == true) {

			timeSinceLastShot += Delta();

			for (Projectile p : projectiles) {
				p.update();
			}
			draw();
		}
	}
	//skracena verzija stvaranja projektila
	public void spawnProjectile(ProjectileType type){
		projectiles.add(new Projectile(type, target, x + type.texture.getImageWidth() / 2, y + type.texture.getImageHeight() /2, width, height, enemies));
	}
	
	public void draw() {
		drawQuadTex(baseTexture, x, y, width, height);
		drawQuadTexRot(cannonTexture, x, y, width, height, angle);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
