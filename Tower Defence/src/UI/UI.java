package UI;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

import data.TowerType;

public class UI {
	private ArrayList<Button> buttonList;
	private ArrayList<Menu> menuList;
	private TrueTypeFont font;
	private Font awtFont;
	
	public UI() {
		this.buttonList = new ArrayList<Button>();
		this.menuList = new ArrayList<Menu>();
		awtFont = new Font("Arial", Font.BOLD, 12);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void drawString(int x, int y, String text){
		font.drawString(x, y, text);
	}
	
	private Button getButton(String buttonName) {
		for (Button b : buttonList) {
			if (b.getName().equals(buttonName)) {
				return b;
			}
		}
		return null;
	}

	public void addButton(String name, Texture texture, int x, int y) {
		buttonList.add(new Button(name, texture, x, y));
	}

	public void draw() {
		for (Button b : buttonList) {
			drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		for (Menu m : menuList) {
			m.draw();
		}
	}

	public boolean isButtonClicked(String buttonName) {
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY()
				&& mouseY < b.getY() + b.getHeight()) {
			return true;
		}
		return false;
	}

	public void createMenu(String name, int x, int y, int width, int height, int columns, int rows) {
		menuList.add(new Menu(name, x, y, width, height, columns, rows));
	}

	public Menu getMenu(String name) {
		for (Menu m : menuList) {
			if (name.equals(m.getName()))
				return m;
		}
		return null;
	}

	public class Menu {

		private int[] towerCosts;
		private ArrayList<Button> menuButtons;
		private int x, y, width, height, buttonAmount, columns, rows, padding;
		String name;

		public Menu(String name, int x, int y, int width, int height, int columns, int rows) {
			this.x = x;
			this.y = y;
			this.name = name;
			this.buttonAmount = 0;
			this.columns = columns;
			this.rows = rows;
			this.width = width;
			this.height = height;
			this.padding = (width - (columns * TILE_SIZE)) / (columns + 1);
			this.menuButtons = new ArrayList<Button>();
			towerCosts = new int[]{
					TowerType.orangeTower.getCost(),
					TowerType.greenTower.getCost()
						};
		}

		public boolean isButtonClicked(String buttonName) {
			Button b = getButton(buttonName);
			float mouseY = HEIGHT - Mouse.getY() - 1;
			if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() && mouseY > b.getY()
					&& mouseY < b.getY() + b.getHeight()) {
				return true;
			}
			return false;
		}

		private Button getButton(String buttonName) {
			for (Button b : menuButtons) {
				if (b.getName().equals(buttonName)) {
					return b;
				}
			}
			return null;
		}

		public void addButton(Button b) {
			if (columns != 0) {
				b.setY(y + (buttonAmount / columns) * TILE_SIZE);
			}
			b.setX(x + (buttonAmount % 2) *(padding + TILE_SIZE) + padding);
			buttonAmount++;
			menuButtons.add(b);
		}

		public void draw() {
			int i =0;
			for (Button b : menuButtons) {
				drawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
				drawString(b.getX(), b.getY(),"" + towerCosts[i++]);
			}
		}

		public String getName() {
			return name;
		}

	}
}
