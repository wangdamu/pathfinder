package com.mm.pathfinder;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

public class MapFinder {
	private Map<Integer, NodeMap> nodeMaps = new HashMap<>();

	public void addNodeMap(NodeMap nodeMap) {
		nodeMaps.put(nodeMap.getMapId(), nodeMap);
	}

	public NodeMap getNodeMapCreateIfAbsent(Integer mapId) {
		NodeMap ret = nodeMaps.get(mapId);
		if (ret == null) {
			ret = new NodeMap();
			ret.setMapId(mapId);
			nodeMaps.put(mapId, ret);
		}
		return ret;
	}

	/**
	 * 寻找从from地图 到达target地图经过的传送门
	 * 
	 * @param from
	 * @param target
	 * @return null: 没找�? emptyList 本地图， 不经过传送门 else: 传�?门集�?
	 */
	public List<Edge> find(int from, int target) {
		// 同一个地图不再检�?
		if (from == target) {
			return Collections.emptyList();
		}

		NodeMap head = nodeMaps.get(from);
		if (head == null) {
			return null;
		}

		NodeMap targetMap = nodeMaps.get(target);
		if (targetMap == null) {
			return null;
		}

		NodeMapWrapper headWrapper = new NodeMapWrapper(0, head, null);
		Set<Integer> visited = new HashSet<Integer>();
		List<EdgeWrapper> edges = new LinkedList<>();
		find(headWrapper, target, visited, edges);

		if (edges.size() == 0) { // 没找�?
			return null;
		}

		EdgeWrapper shortestEdgeWrapper = null;
		for (EdgeWrapper edge : edges) {
			if (shortestEdgeWrapper == null || shortestEdgeWrapper.getLastMapWrapper().getCounter() > edge.getLastMapWrapper().getCounter()) {
				shortestEdgeWrapper = edge;
			}
		}

		List<Edge> ret = new LinkedList<>();
		EdgeWrapper edge = shortestEdgeWrapper;
		while (edge != null) {
			ret.add(0, edge.getEdge());
			edge = edge.getLastMapWrapper().getLastEdgeWrapper();
		}
		return ret;
	}

	private void find(NodeMapWrapper mapWrapper, int target, Set<Integer> visited, List<EdgeWrapper> endEdgeList) {
		if (visited.contains(mapWrapper.getNodeMap().getMapId())) {
			return;
		}
		if (mapWrapper.getNodeMap().getMapId() == target) { // 找到
			if (mapWrapper.getLastEdgeWrapper() != null) {
				endEdgeList.add(mapWrapper.getLastEdgeWrapper());
			}
			return;
		}
		visited.add(mapWrapper.getNodeMap().getMapId());

		List<Edge> list = mapWrapper.getNodeMap().getEdges();
		if (CollectionUtils.isNotEmpty(list)) {
			for (Edge edge : list) {
				EdgeWrapper edgeWrapper = new EdgeWrapper(edge, mapWrapper);
				NodeMapWrapper newMapWrapper = new NodeMapWrapper(mapWrapper.getCounter() + 1, edge.getNextMap(), edgeWrapper);
				find(newMapWrapper, target, visited, endEdgeList);
			}
		}
	}

	private class EdgeWrapper {
		private Edge edge;
		private NodeMapWrapper lastMapWrapper;

		public EdgeWrapper(Edge edge, NodeMapWrapper lastMapWrapper) {
			super();
			this.edge = edge;
			this.lastMapWrapper = lastMapWrapper;
		}

		public Edge getEdge() {
			return edge;
		}

		public NodeMapWrapper getLastMapWrapper() {
			return lastMapWrapper;
		}
	}

	private class NodeMapWrapper {
		private int counter;
		private NodeMap nodeMap;
		private EdgeWrapper lastEdgeWrapper;

		public NodeMapWrapper(int counter, NodeMap nodeMap, EdgeWrapper lastEdgeWrapper) {
			super();
			this.counter = counter;
			this.nodeMap = nodeMap;
			this.lastEdgeWrapper = lastEdgeWrapper;
		}

		public int getCounter() {
			return counter;
		}

		public NodeMap getNodeMap() {
			return nodeMap;
		}

		public EdgeWrapper getLastEdgeWrapper() {
			return lastEdgeWrapper;
		}
	}
}
