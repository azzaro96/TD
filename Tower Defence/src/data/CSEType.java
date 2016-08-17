package data;

public enum CSEType {
	
	SLOW(new CreepStatusEffect(2, -0.3f, 1), true),
	STUN(new CreepStatusEffect(0.3f, -1, 1), true),
	DMG_AMP(new CreepStatusEffect(0.5f, 1, 1.2f), false);
	
	public static final int slow = 0, stun = 1, dmg_amp = 2;
	public static final CSEType[] EFFECTS = {SLOW, STUN, DMG_AMP};
	public static final int numberOfTypes = EFFECTS.length;
	
	private CreepStatusEffect status;
	private boolean resistable;
	
	private CSEType(CreepStatusEffect status , boolean resistable) {
		this.status = status;
		this.resistable = resistable;
	}

	public CreepStatusEffect getStatus() {
		return status;
	}

	public boolean isResistable() {
		return resistable;
	}
	
	
	
	
	
}
