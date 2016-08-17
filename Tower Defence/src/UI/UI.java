package UI;

import java.util.ArrayList;
import static helpers.Artist.*;
import org.newdawn.slick.opengl.*;

public class UI {
	private ArrayList<Button> buttonList;

	public UI() {
		super();
		this.buttonList = new ArrayList<Button>();
	}

	public void addButton(String name, String textureName, int x, int y){
		buttonList.add(new Button(name, QuickLoad(textureName), x, y));
	}
	
	public void draw(){
		for (Button b: buttonList){
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
	}
}
