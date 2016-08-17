package data;

public class CreepStatusEffect {
	
	private float duration;
	private float speedModifier;
	private float damageModifier;

	public CreepStatusEffect(float duration, float speedModifier, float damageModifier) {
		super();
		this.duration = duration;
		this.speedModifier = speedModifier;
		this.damageModifier = damageModifier;
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
	
	
	
}
