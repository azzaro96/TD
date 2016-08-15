package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class Enemy {

	private int width, height, health, currentCheckPoint;;
	// i status
	private float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private TileGrid grid;
	private ArrayList<CheckPoint> checkPoints;
	private boolean first = true;
	private int[] directions;

	public Enemy(Texture t, Tile startTile, TileGrid grid, int width, int height, float speed) {
		texture = t;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;

		this.checkPoints = new ArrayList<CheckPoint>();
		this.directions = new int[2];
		// x direction
		this.directions[0] = 0;
		// y direction
		this.directions[1] = 0;
		directions = FindNextD(startTile);
		this.currentCheckPoint = 0;
		PopulateCheckPointList();
	}

	private boolean CheckPointReached() {
		boolean reached = false;
		
		Tile t = checkPoints.get(currentCheckPoint).getTile();
		if(x > t.getX() - 3 && x < t.getX() + 3 && y > t.getY() - 3 && y < t.getY() + 3){
			reached = true;
			x = t.getX();
			y = t.getY();
		}
		return reached;
	}

	private void PopulateCheckPointList() {

		checkPoints.add(FindNextC(startTile, directions = FindNextD(startTile)));

		int counter = 0;
		boolean cont = true;

		while (cont) {
			int[] currentD = FindNextD(checkPoints.get(counter).getTile());
			//check if a next direction/checkpoint exists, end after 20 checks (arbitrary)
			if (currentD[0] == 2) {
				cont = false;
			} else {
				checkPoints.add(FindNextC(checkPoints.get(counter).getTile(),
						directions = FindNextD(checkPoints.get(counter).getTile())));
			}
			counter++;
		}
	}

	/*
	 * public boolean pathContinues(){ boolean answer = true;
	 * 
	 * Tile myTile = grid.getTile((int) (x/32),(int) (y/32)); Tile nextTile =
	 * grid.getTile((int) (x/32) + 1,(int) (y/32));
	 * 
	 * if (myTile.getType() != nextTile.getType()) return false; return answer;
	 * }
	 */
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}

	public void Update() {
		if (first)
			first = false;
		else {
			if (CheckPointReached()) {
				if(currentCheckPoint + 1 == checkPoints.size()){
					
				}else
				currentCheckPoint++;
			} else {
				x += Delta() * checkPoints.get(currentCheckPoint).getxDirection() * speed;
				y += Delta() * checkPoints.get(currentCheckPoint).getyDirection() * speed;
			}
		}
	}	

	private CheckPoint FindNextC(Tile s, int[] dir) {
		Tile next = null;
		CheckPoint c = null;
		// Boolean to decide if next checkpoint is found
		boolean found = false;

		int counter = 1;
			
		while (!found) {
			
			if ((s.getXPlace() + dir[0] * counter == grid.getTilesWide() || s.getYPlace() + dir[1] * counter == grid.getTilesHigh()) || s.getType() != grid.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace() + dir[1] * counter)
					.getType()) {
				found = true;
				counter -= 1;
				next = grid.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace() + dir[1] * counter);
			}

			counter++;
		}
		c = new CheckPoint(next, dir[0], dir[1]);
		return c;
	}

	private int[] FindNextD(Tile s) {
		int[] dir = new int[2];
		Tile u = grid.getTile(s.getXPlace(), s.getYPlace() - 1);
		Tile r = grid.getTile(s.getXPlace() + 1, s.getYPlace());
		Tile d = grid.getTile(s.getXPlace(), s.getYPlace() + 1);
		Tile l = grid.getTile(s.getXPlace() - 1, s.getYPlace());

		if (s.getType() == u.getType() && directions[1] != 1) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == r.getType() && directions[0] != -1 ) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == l.getType() && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
		} else if (s.getType() == d.getType() && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
		} else {
			dir[0] = 2;
			dir[1] = 2;
		}

		return dir;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
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

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public TileGrid getGrid() {
		return grid;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

}
