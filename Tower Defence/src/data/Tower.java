package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.Delta;

import java.util.ArrayList;

public abstract class Tower implements Entity {

	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, damage, range;
	private Enemy target;
	private Texture baseTexture, cannonTexture;
	private ArrayList<Enemy> enemies;
	private ArrayList<Projectile> projectiles;
	private boolean targeted;

	public Tower(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
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
			if (isInRange(e) && findDistance(e) < closestDistance) {
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

	public void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(
				new Projectile(quickLoad("bullet"), target, x + TILE_SIZE / 4, y + TILE_SIZE / 4, 16, 16, 360, 40));
	}

	public void updateEnemyList(ArrayList<Enemy> enemyList) {
		enemies = enemyList;
	}

	public void update() {
		if (!targeted) {
			target = acquireTarget();
		}

		if (target == null || target.isAlive() == false)
			targeted = false;

		if (targeted == true) {

			timeSinceLastShot += Delta();
			if (timeSinceLastShot > firingSpeed)
				shoot();

			for (Projectile p : projectiles) {
				p.update();
			}
			angle = calcAngle() - 50;
			draw();
		}
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
