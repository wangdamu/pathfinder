package com.mm.pathfinder;

public enum EdgeEnum {
	NPC(1), GATE(2);

	private final int id;

	EdgeEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
