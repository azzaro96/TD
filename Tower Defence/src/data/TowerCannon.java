package data;

import static helpers.Artist.DrawQuadTex;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y;
	private int width, height, damage;
	private Texture texture;
	private Tile startTile;
	
	public TowerCannon(Texture t, Tile startTile, int dmg) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.texture = t;
		this.startTile = startTile;
		damage = dmg;
		width = (int)startTile.getWidth();
		height = (int)startTile.getHeight();
	}
	
	public void update() {
		
	}
	
	public void draw() {
		DrawQuadTex(texture, x, y, width, height);
	}
}
