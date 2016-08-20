package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum ProjectileType {
	
	greenTowerProjectile(TextureBank.greenProjectile, 45, CSEType.slow, 300),
	orangeTowerProjectile(TextureBank.orangeProjectile, 70, -1, 600),
	purpleTowerProjectile(TextureBank.purpleProjectile, 300, -1, 450);
	
	Texture texture;
	int damage;
	int statusEffectCode;
	float speed;
	
	private ProjectileType(Texture texture, int dmg,int statusEffectCode, float speed) {
		this.texture = texture;
		this.damage = dmg;
		this.speed = speed;
		this.statusEffectCode = statusEffectCode;
	}
	
	
	
}
