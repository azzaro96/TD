package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class Enemy implements Entity {

	private int width, height, currentCheckPoint;
	// i status treba da se ubaci
	private float speed, x, y, health, maxHealth;
	private Texture texture, healthBar;
	private Tile startTile;
	private TileGrid grid;
	private ArrayList<CheckPoint> checkPoints;
	private boolean first = true, alive = true;
	private int[] directions;

	public Enemy(Texture t, Tile startTile, TileGrid grid, int width, int height, float speed, float hp) {
		texture = t;
		this.healthBar = quickLoad("healthBar");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;
		this.maxHealth = hp;
		this.health = maxHealth;
		this.checkPoints = new ArrayList<CheckPoint>();
		this.directions = new int[2];
		// x direction
		this.directions[0] = 0;
		// y direction
		this.directions[1] = 0;
		directions = findNextD(startTile);
		this.currentCheckPoint = 0;
		populateCheckPointList();
	}

	/**
	 * @return Da li je krip stigao na sledeci checkPoint
	 */
	private boolean checkPointReached() {
		boolean reached = false;

		Tile t = checkPoints.get(currentCheckPoint).getTile();

		// +- 3 je dodato kao margina da krip ne bi slucajno preskocio
		// checkpoint pri velikim brzinama
		if (x > t.getX() - 3 && x < t.getX() + 3 && y > t.getY() - 3 && y < t.getY() + 3) {
			reached = true;

			// centrira kripa na tile ukoliko postoji odstupanje
			x = t.getX();
			y = t.getY();
		}
		return reached;
	}

	/**
	 * @return nista 
	 * @opis skenira mapu i stvara arrayList checkPoint-ova
	 */
	private void populateCheckPointList() {
		//
		checkPoints.add(findNextC(startTile, directions = findNextD(startTile)));

		int counter = 0;
		boolean cont = true;

		while (cont) {
			
			// trenutni smer
			int[] currentD = findNextD(checkPoints.get(counter).getTile());
			
			// proverava da li postoji smer, 2 je znak da ne postoji i da je metoda zavrsena
			if (currentD[0] == 2) {
				cont = false;
			} else {
				
				// iterativno trazi checkPoint-ove
				directions = findNextD(checkPoints.get(counter).getTile());
				checkPoints.add(findNextC(checkPoints.get(counter).getTile(),directions));
			}
			counter++;
		}
	}

	public void die() {
		alive = false;
	}

	public void draw() {
		float healthPercentage = health / maxHealth;
		drawQuadTex(texture, x, y, width, height);
		
		//ovo sam eksperimentalno utvrdio da izgleda "dobro"
		drawQuadTex(healthBar, x + width*0.05f, y , width * 0.9f * healthPercentage, 4);
	}

	public void update() {
		if (first)
			first = false;
		else {
			if (checkPointReached()) {
				// stigao do poslednjeg checkPoint-a
				if (currentCheckPoint + 1 == checkPoints.size()) {
					die();
				} else
					currentCheckPoint++;
			} else {
				// kretanje
				x += Delta() * checkPoints.get(currentCheckPoint).getxDirection() * speed;
				y += Delta() * checkPoints.get(currentCheckPoint).getyDirection() * speed;
			}
		}
	}

	private CheckPoint findNextC(Tile s, int[] dir) {
		Tile next = null;
		CheckPoint c = null;
		// Boolean vrednost koja odredjuje da li je nadjen sledeci checkPoint
		boolean found = false;

		int counter = 1;

		while (!found) {

			int potentialCPXCoord = s.getXPlace() + dir[0] * counter;
			int potentialCPYCoord = s.getYPlace() + dir[1] * counter;
			
			// ako sledeci tile u tom smeru u kom se krip krece se razlikuje od predhodnog tile-a u tom smeru
			if ((potentialCPXCoord == grid.getTilesWide() || potentialCPYCoord == grid.getTilesHigh()) || 
					s.getType() != grid.getTile(potentialCPXCoord, potentialCPYCoord).getType()) {
				found = true;
				counter -= 1;
				next = grid.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace() + dir[1] * counter);
			}

			counter++;
		}
		c = new CheckPoint(next, dir[0], dir[1]);
		return c;
	}

	/**
	 * 
	 * @param Tile na kome se krip trenutno nalazi
	 * @return dvodimenzionalni vektor smera
	 */
	private int[] findNextD(Tile s) {
		int[] dir = new int[2];
		// gornja susedna
		// desna susedna
		// donja susedna
		// leva susedna

		// null pointer ne moze da se desi jer grid.GetTile() metoda ima proveru
		// i vraca NULL TileType ako se taj uslov ispuni
		Tile u = grid.getTile(s.getXPlace(), s.getYPlace() - 1);
		Tile r = grid.getTile(s.getXPlace() + 1, s.getYPlace());
		Tile d = grid.getTile(s.getXPlace(), s.getYPlace() + 1);
		Tile l = grid.getTile(s.getXPlace() - 1, s.getYPlace());

		if (s.getType() == u.getType() && directions[1] != 1) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == r.getType() && directions[0] != -1) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == l.getType() && directions[0] != 1) {
			dir[0] = -1;
			dir[1] = 0;
		} else if (s.getType() == d.getType() && directions[1] != -1) {
			dir[0] = 0;
			dir[1] = 1;
		} else { //ako ne moze da nadje sledeci smer
			dir[0] = 2;
			dir[1] = 2;
		}

		return dir;
	}
	/**
	 * 
	 * @param dmg
	 * prima damage
	 */
	public void damage(int dmg) {
		health -= dmg;
		if (health <= 0)
			die();
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

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
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

	public boolean isAlive() {
		return alive;
	}

}
