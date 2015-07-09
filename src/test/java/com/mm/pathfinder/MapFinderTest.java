package com.mm.pathfinder;

import java.util.Arrays;
import java.util.List;

public class MapFinderTest {
	public static void main(String[] args) {
		NodeMap map1 = new NodeMap();
		map1.setMapId(1);
		NodeMap map2 = new NodeMap();
		map2.setMapId(2);
		NodeMap map3 = new NodeMap();
		map3.setMapId(3);
		NodeMap map4 = new NodeMap();
		map4.setMapId(4);
		NodeMap map5 = new NodeMap();
		map5.setMapId(5);

		Edge edge1 = new Edge();
		edge1.setNextMap(map2);
		edge1.setData(new EdgeData("edge1", 1, EdgeEnum.GATE, 100, 100));
		Edge edge2 = new Edge();
		edge2.setNextMap(map3);
		edge2.setData(new EdgeData("edge2", 2, EdgeEnum.GATE, 200, 200));
		Edge edge3 = new Edge();
		edge3.setNextMap(map4);
		edge3.setData(new EdgeData("edge3", 3, EdgeEnum.GATE, 200, 200));
		Edge edge32 = new Edge();
		edge32.setNextMap(map2);
		edge32.setData(new EdgeData("edge32", 3, EdgeEnum.GATE, 200, 200));
		Edge edge14 = new Edge();
		edge14.setNextMap(map4);
		edge14.setData(new EdgeData("edge14", 1, EdgeEnum.GATE, 120, 120));

		map1.addEdge(edge1);
		map2.addEdge(edge2);
		map3.addEdge(edge3);
		map1.addEdge(edge14);
		map3.addEdge(edge32);

		MapFinder mapFinder = new MapFinder();
		mapFinder.addNodeMap(map1);
		mapFinder.addNodeMap(map2);
		mapFinder.addNodeMap(map3);
		mapFinder.addNodeMap(map4);
		mapFinder.addNodeMap(map5);

		// [Edge [1], Edge [2]]
		// mapFinder.find(1, 4)[Edge [1]]
		// mapFinder.find(1, 5)No way
		// mapFinder.find(1, 1)[]
		// mapFinder.find(1, 2)[Edge [1]]
		// mapFinder.find(1, 3)[Edge [1], Edge [2]]
		// mapFinder.find(2, 4)[Edge [2], Edge [3]]
		// mapFinder.find(2, 3)[Edge [2]]
		// mapFinder.find(2, 5)No way
		// mapFinder.find(3, 2)[Edge [3]]

		List<Edge> ret = mapFinder.find(1, 3);
		System.out.println((ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(1, 4);
		System.out.println("mapFinder.find(1, 4)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(1, 5);
		System.out.println("mapFinder.find(1, 5)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(1, 1);
		System.out.println("mapFinder.find(1, 1)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(1, 2);
		System.out.println("mapFinder.find(1, 2)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(1, 3);
		System.out.println("mapFinder.find(1, 3)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(2, 4);
		System.out.println("mapFinder.find(2, 4)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(2, 3);
		System.out.println("mapFinder.find(2, 3)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(2, 5);
		System.out.println("mapFinder.find(2, 5)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));

		ret = mapFinder.find(3, 2);
		System.out.println("mapFinder.find(3, 2)" + (ret != null ? Arrays.toString(ret.toArray()) : "No way"));
	}
}
