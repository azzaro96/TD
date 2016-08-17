package data;


import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public class Projectile {

	private Texture texture;
	private float x, y, speed, width, height;
	private int damage;
	private Enemy target;
	private float xVelocity, yVelocity;
	private boolean alive;
	
	public Projectile(Texture t, Enemy target, float x, float y, float w, float h, float speed, int dmg) {
		texture = t;
		this.target = target;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.speed = speed;
		damage = dmg;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		calcDirection();
		alive = true;
	}

	private void calcDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistFromTarget = Math.abs(target.getX() + TILE_SIZE/4 - x);
		float yDistFromTarget = Math.abs(target.getY() + TILE_SIZE/4 - y);
		float totalDist = xDistFromTarget + yDistFromTarget;
		float xPercentOfMovement = xDistFromTarget / totalDist;
		xVelocity = xPercentOfMovement;
		yVelocity = totalAllowedMovement - xPercentOfMovement;
		if (target.getX() < x) {
			xVelocity *= -1;
		}
		if (target.getY() < y) {
			yVelocity *= -1;
		}
	}

	public void update() {
		if(alive) {
			x += Delta() * speed * xVelocity;
			y += Delta() * speed * yVelocity;
			// calcDirection();
			if(checkCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())) {
				target.damage(damage);
				alive = false;
			}
			draw();
		}
	}

	public void draw() {
		drawQuadTex(texture, x, y, 16, 16);
	}
}
