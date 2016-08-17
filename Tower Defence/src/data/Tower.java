package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public abstract class Tower implements Entity{

	private float x, y;
	private int width, height, damage;
	private Enemy target;
	private Texture baseTexture, cannonTexture;
	
	
	public Tower(Texture t1, Texture t2, float x, float y, int width, int height) {
		baseTexture = t1;
		cannonTexture = t2;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

	public void update() {
		
	}
	
	//stavio sam da crta iz dva dela, on crta sam bbazu (izgleda)
	public void draw() {
		drawQuadTex(baseTexture, x, y, width, height);
		drawQuadTex(cannonTexture, x, y, width, height);
	}

}
