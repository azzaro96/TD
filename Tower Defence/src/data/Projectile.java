package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;
import org.newdawn.slick.opengl.Texture;

public class Projectile {
	
	private Texture texture;
	private float x, y, speed;
	private int damage;
	
	public Projectile(Texture t, float x, float y, float speed, int dmg) {
		texture = t;
		this.x = x;
		this.y = y;
		this.speed = speed;
		damage = dmg;
	}
	
	public void update() {
		x += Delta() * speed;
		draw();
	}
	
	public void draw() {
		DrawQuadTex(texture, x, y, 16, 16);
	}
}
