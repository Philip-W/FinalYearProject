package org.gt4j.annas.graph.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.UndirectedGraph;

/**
 * Implementation of an algorithm to determine if a graph is biconnected. The
 * algorithm uses a modified depth first search. In the case that the graph is
 * not biconnected then the algorithm will return a set of articulation points.
 * An articulation point is a vertex that when removed increases the number of
 * connected components.
 * 
 * @author Sam Wilson
 *
 * @param <V>
 * @param <E>
 */
public class BiconnectedComponent<V, E extends EdgeInterface<V>> implements Algorithm<Collection<V>> {

	private UndirectedGraph<V, E> graph;

	private List<V> visited;

	private List<V> aps;

	private Map<V, Integer> depth;

	private Map<V, V> parent;

	private Map<V, Integer> lowpoint;

	private int dfscounter;

	/**
	 * @param graph
	 */
	public BiconnectedComponent(UndirectedGraph<V, E> graph) {
		super();
		this.graph = graph;
	}

	/**
	 * Execute the biconnected component algorithm.
	 * 
	 * @return a collection of articulation points
	 */
	public Collection<V> call() {
		if (this.graph.getOrder() == 0) {
			return new ArrayList<V>(0);
		}
		this.visited = new LinkedList<>();
		this.depth = new Hashtable<>();
		this.aps = new LinkedList<>();
		this.parent = new Hashtable<>();
		this.lowpoint = new Hashtable<>();
		this.dfscounter = 0;
		V v = graph.getVertices().iterator().next();
		doArticulationPointDFS(v);
		return this.aps;
	}

	/**
	 * Determines if the graph is biconnected
	 * 
	 * @return true if the graph is biconnected, otherwise false;
	 */
	public boolean isBiconnected() {
		return this.call().size() == 0;
	}

	private void doArticulationPointDFS(V vertex) {
		if (vertex == null) {
			return;
		}

		this.visited.add(vertex);
		this.depth.put(vertex, dfscounter);
		this.lowpoint.put(vertex, dfscounter);
		this.dfscounter++;

		int children = 0;

		int tmp = this.lowpoint.get(vertex);
		for (EdgeInterface<V> edge : this.graph.getEdges(vertex)) {
			V y = edge.getOtherEndpoint(vertex);

			if (!visited.contains(y)) {
				children++;
				this.parent.put(y, vertex);
				this.doArticulationPointDFS(y);

				tmp = Math.min(tmp, this.lowpoint.get(y));

			} else if (this.parent.get(vertex) != y) {

				tmp = Math.min(tmp, this.depth.get(y));

			}

			this.lowpoint.put(vertex, tmp);

			if (this.parent.get(vertex) == null && children > 1) {
				if (!aps.contains(vertex)) {
					aps.add(vertex);
				}

			}

			if (this.parent.get(vertex) != null
					&& this.lowpoint.get(y) >= this.depth.get(vertex)) {
				if (!aps.contains(vertex)) {
					aps.add(vertex);
				}
			}
		}

	}
}
