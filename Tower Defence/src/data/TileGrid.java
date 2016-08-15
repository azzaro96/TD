package data;
import static helpers.Artist.*;

public class TileGrid {
	
	public Tile[][] map;
	private int tilesWide, tilesHigh;
	public TileGrid() {
		
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Land);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		this.tilesWide = newMap[0].length;
		this.tilesHigh = newMap.length;
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(newMap[j][i] == 0)
					map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Land);
				else
					map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Road);
			}
		}
	}
	
	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].Draw();
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < tilesWide && x > -1 && y < tilesHigh && y > -1)
		return map[x][y];
		else return new Tile (0,0,0,0 ,TileType.NULL);
	}
	
	public void SetTile(int x, int y, TileType type){
		map[x][y] = new Tile(x*32, y*32, 32, 32, type);
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}
	
	
}
