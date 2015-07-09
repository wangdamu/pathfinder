package com.mm.pathfinder;

public class EdgeData {
	private String id;
	private int mapId;
	private final Point point;
	private final EdgeEnum edgeType;

	public EdgeData(String id, int mapId, EdgeEnum edgeType, Point point) {
		this.id = id;
		this.mapId = mapId;
		this.edgeType = edgeType;
		this.point = point;
	}

	public EdgeData(String id, int mapId, EdgeEnum edgeType, int x, int y) {
		this.id = id;
		this.mapId = mapId;
		this.edgeType = edgeType;
		point = new Point(x, y);
	}

	public int getMapId() {
		return mapId;
	}

	public Point getPoint() {
		return point;
	}

	public String getId() {
		return id;
	}

	public EdgeEnum getEdgeType() {
		return edgeType;
	}

}
