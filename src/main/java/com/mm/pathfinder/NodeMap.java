package com.mm.pathfinder;

import java.util.ArrayList;
import java.util.List;

public class NodeMap {
	private int mapId;
	private List<Edge> edges = new ArrayList<Edge>();

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
}
