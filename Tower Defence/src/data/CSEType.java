package data;

public enum CSEType {
	
	NULL(null, false),
	SLOW(new CreepStatusEffect(2, -0.3f, 1), true),
	STUN(new CreepStatusEffect(0.3f, -1, 1), true),
	DMG_AMP(new CreepStatusEffect(0.5f, 1, 1.2f), false);
	
	private CreepStatusEffect status;
	private boolean resistable;
	
	private CSEType(CreepStatusEffect status , boolean resistable) {
		this.status = status;
		this.resistable = resistable;
	}
	
	
	
}
