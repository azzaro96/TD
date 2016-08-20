package data;

public enum CSEType {
	
	SLOW(2, -0.3f, 1, true),
	STUN(0.3f, -1, 1, true),
	DMG_AMP(0.5f, 1, 1.2f, false);
	
	public static final int slow = 0, stun = 1, dmg_amp = 2;
	public static final CSEType[] EFFECTS = {SLOW, STUN, DMG_AMP};
	public static final int numberOfTypes = EFFECTS.length;
	
	private float duration, speedModifier, damageModifier;
	private boolean resistable;
	
	


	private CSEType(float duration, float speedModifier, float damageModifier, boolean resistable) {
		this.duration = duration;
		this.speedModifier = speedModifier;
		this.damageModifier = damageModifier;
		this.resistable = resistable;
	}

	

	public float getDuration() {
		return duration;
	}



	public void setDuration(float duration) {
		this.duration = duration;
	}



	public float getSpeedModifier() {
		return speedModifier;
	}



	public void setSpeedModifier(float speedModifier) {
		this.speedModifier = speedModifier;
	}



	public float getDamageModifier() {
		return damageModifier;
	}



	public void setDamageModifier(float damageModifier) {
		this.damageModifier = damageModifier;
	}



	public void setResistable(boolean resistable) {
		this.resistable = resistable;
	}



	public boolean isResistable() {
		return resistable;
	}
	
	
	
	
	
}
