package com.mm.pathfinder;

public class Edge {
	private EdgeData data;
	private NodeMap nextMap;

	public Edge() {
	}

	public EdgeData getData() {
		return data;
	}

	public void setData(EdgeData data) {
		this.data = data;
	}

	public NodeMap getNextMap() {
		return nextMap;
	}

	public void setNextMap(NodeMap nextMap) {
		this.nextMap = nextMap;
	}

	@Override
	public String toString() {
		return "Edge [" + data.getMapId() + "]";
	}
}
