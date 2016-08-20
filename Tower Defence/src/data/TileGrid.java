package data;
import static helpers.Artist.*;

public class TileGrid {
	
	public Tile[][] map;
	private int tilesWide, tilesHigh;
	public TileGrid() {
		
		map = new Tile[tilesWide][tilesHigh];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Land);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		this.tilesWide = newMap[0].length;
		this.tilesHigh = newMap.length;
		map = new Tile[tilesWide][tilesHigh];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(newMap[j][i] == 0)
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Land);
				else
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Road);
			}
		}
	}
	
	public void draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].draw();
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < tilesWide && x > -1 && y < tilesHigh && y > -1)
		return map[x][y];
		else return new Tile(4000, 4000, 1, 1, TileType.NULL);
	}
	
	public void SetTile(int x, int y, TileType type){
		map[x][y] = new Tile(x*TILE_SIZE, y*TILE_SIZE, TILE_SIZE, TILE_SIZE, type);
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}
	
	
}
