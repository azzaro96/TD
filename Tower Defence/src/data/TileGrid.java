package data;
import static helpers.Artist.*;

public class TileGrid {
	
	public Tile[][] map;
	
	public TileGrid() {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Land);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
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
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
}
