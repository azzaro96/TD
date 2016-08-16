package data;

import static helpers.Artist.DrawQuadTex;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {
	
	private float x, y;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	
	//konstruktor prima dve teksture umesto jedna jer se razlikuje cannon
	//i draw crta dva puta
	
	public TowerCannon(Texture t1, Texture t2, Tile startTile, int dmg) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.baseTexture = t1;
		this.cannonTexture = t2;
		this.startTile = startTile;
		damage = dmg;
		width = (int)startTile.getWidth();
		height = (int)startTile.getHeight();
	}
	
	public void update() {
		
	}
	
	public void draw() {
		DrawQuadTex(baseTexture, x, y, width, height);
		DrawQuadTex(cannonTexture, x, y, width, height);
	}
}
