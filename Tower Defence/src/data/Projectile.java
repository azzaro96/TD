package data;

import static helpers.Artist.TILE_SIZE;
import static helpers.Artist.checkCollision;
import static helpers.Artist.drawQuadTex;
import static helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.opengl.Texture;

public class Projectile implements Entity {

	private Texture texture;
	private float x, y, speed;
	private int damage, width, height;
	private Enemy target;
	private float xVelocity, yVelocity;
	private boolean alive;
	private CopyOnWriteArrayList<Enemy> wave;
	
	
	//dotat arraylist wave u konstruktoru, izmenjena klasa tower
	public Projectile(ProjectileType type, Enemy target, float x, float y, int w, int h, CopyOnWriteArrayList<Enemy> wave) {
		texture = type.texture;
		this.target = target;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.speed = type.speed;
		damage = type.dmg;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		calcDirection();
		alive = true;
		this.wave = wave;
	}

	private void calcDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistFromTarget = Math.abs(target.getX() + TILE_SIZE / 4 - x);
		float yDistFromTarget = Math.abs(target.getY() + TILE_SIZE / 4 - y);
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

	/*
	 * public void update() { if(alive) { x += Delta() * speed * xVelocity; y +=
	 * Delta() * speed * yVelocity; // calcDirection(); if(checkCollision(x, y,
	 * width, height, target.getX(), target.getY(), target.getWidth(),
	 * target.getHeight())) { target.damage(damage); alive = false; } draw(); }
	 * }
	 */
	
	
	//ceo wave proverava da l je pogodio metak
	public void update() {
		if (alive) {
			x += Delta() * speed * xVelocity;
			y += Delta() * speed * yVelocity;
			// calcDirection();
			for (Enemy e : wave) {
				if (checkCollision(x, y, width, height, e.getX(), e.getY(), e.getWidth(),
						e.getHeight())) {
					e.damage(damage);
					alive = false;
				}
			}
			draw();
		}
	}

	public void draw() {
		drawQuadTex(texture, x, y, texture.getImageWidth(), texture.getImageHeight());
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}
}
