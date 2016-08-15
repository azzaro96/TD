package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;
public class Player {
	private TileGrid grid;
	
	public Player(TileGrid grid){
		this.grid = grid;
	}
	
	public void SetTile(){
		grid.SetTile((int)Math.floor(Mouse.getX() / 32), (int)Math.floor((HEIGHT - Mouse.getY() - 1) /32), TileType.Road);
	}
	
	public void Update(){
		if (Mouse.isButtonDown(0)) {
			SetTile();
		}
	}
}
