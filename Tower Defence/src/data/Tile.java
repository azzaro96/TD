package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public class Tile {
	
	private float x, y, width, height;
	private Texture texture;
	private TileType type;
	
	public Tile(float x, float y, float w, float h, TileType t) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		type = t;
		if (type == TileType.Land)
			texture = land;
		else
			texture = road;
	}
	
	
	public int getXPlace(){
		return (int) x/TILE_SIZE; 
	}
	
	public int getYPlace(){
		return (int) y/TILE_SIZE;
	}
	
	public void draw() {
		drawQuadTex(texture, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
	
	
}
