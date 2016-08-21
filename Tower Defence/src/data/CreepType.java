package data;

import org.newdawn.slick.opengl.Texture;

import helpers.TextureBank;

public enum CreepType {
	
	
	
	basicCreep(TextureBank.creepRose, 100, 50, 1, false),
	fastCreep(TextureBank.creepBlue, 60, 140, 1, false),
	tankyCreep(TextureBank.creepPurple, 400, 30, 1, false),
	bossCreep(TextureBank.creepBoss, 1000, 50, 10, true);
	
	private Texture texture;
	private float maxHealth;
	private float speed;
	private int bounty;
	private boolean boss;
	
	
	private CreepType(Texture texture, float maxHealth, float speed, int bounty, boolean boss) {
		this.texture = texture;
		this.maxHealth = maxHealth;
		this.speed = speed;
		this.boss = boss;
		this.bounty = bounty;
	}
	

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(float maxHealth) {
		this.maxHealth = maxHealth;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}
	
	public void increaseBounty(){
		if(this == bossCreep)
			bounty += 10;
		else
			bounty++;
	}
	
	
	
	
	
	
}
