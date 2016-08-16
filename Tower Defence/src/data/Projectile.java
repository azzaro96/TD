package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;

public class Projectile {

	private Texture texture;
	private float x, y, speed;
	private int damage;
	private Enemy target;
	private float xVelocity, yVelocity;

	public Projectile(Texture t, Enemy target, float x, float y, float speed, int dmg) {
		texture = t;
		this.target = target;
		this.x = x;
		this.y = y;
		this.speed = speed;
		damage = dmg;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		calcDirection();
	}

	private void calcDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistFromTarget = Math.abs(target.getX() + Game.TILE_SIZE/4 - x);
		float yDistFromTarget = Math.abs(target.getY() + Game.TILE_SIZE/4 - y);
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
		x += Delta() * speed * xVelocity;
		y += Delta() * speed * yVelocity;
		// calcDirection();
		draw();
	}

	public void draw() {
		DrawQuadTex(texture, x, y, 16, 16);
	}
}
