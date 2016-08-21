package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum ProjectileType {
	
	greenTowerProjectileLVL1(TextureBank.greenProjectile, 10, CSEType.slow, 250),
	orangeTowerProjectileLVL1(TextureBank.orangeProjectile, 20, -1, 400),
	purpleTowerProjectileLVL1(TextureBank.purpleProjectile, 100, -1, 180);
	
	Texture texture;
	int damage;
	int statusEffectCode;
	float speed;
	
	private ProjectileType(Texture texture, int dmg, int statusEffectCode, float speed) {
		this.texture = texture;
		this.damage = dmg;
		this.speed = speed;
		this.statusEffectCode = statusEffectCode;
	}
	
	
	
}
