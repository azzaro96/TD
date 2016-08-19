package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum ProjectileType {
	
	greenTowerProjectile(TextureBank.greenProjectile, 15, 300),
	orangeTowerProjectile(TextureBank.orangeProjectile, 30, 600);
	
	Texture texture;
	int dmg;
	float speed;
	
	private ProjectileType(Texture texture, int dmg, float speed) {
		this.texture = texture;
		this.dmg = dmg;
		this.speed = speed;
	}
	
	
	
}
