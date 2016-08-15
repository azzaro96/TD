package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;
public class Enemy {
	
	private int width, height, health;
	//i status
	private float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private boolean first = true;
	public Enemy(Texture t, Tile startTile, int width, int height, float speed) {
		texture = t;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}
	
	public void Update(){
		if (first)
			first = false;
		else
			x += Delta() * speed;
	}
}
