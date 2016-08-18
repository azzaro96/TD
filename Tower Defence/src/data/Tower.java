package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public abstract class Tower implements Entity{

	private float x, y;
	private int width, height, damage;
	private Enemy target;
	private Texture baseTexture, cannonTexture;
	
	
	public Tower(TowerType type, Tile startTile) {
		baseTexture = type.towerBase;
		cannonTexture = type.towerCannon;
		this.damage = type.dmg;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
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
