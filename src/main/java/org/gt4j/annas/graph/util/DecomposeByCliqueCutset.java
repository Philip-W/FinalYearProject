package org.gt4j.annas.graph.util;


import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;

/**
 * An implementation of a decomposition algorithm through the use of
 * clique cutsets, as presented by Robert Tarjan in:
 * Decomposition by Clique Separators. ScienceDirect,
 * Discrete Mathematics Volume 55, Issue 2 (1985)
 *
 *
 * @author Philip Woods
 *
 * @param <V>
 *            Vertex type
 * @param <E>
 *            Edge type
 */
public class DecomposeByCliqueCutset<V, E extends EdgeInterface<V>> {

    GraphInterface<V, E> graph;


    public DecomposeByCliqueCutset(final GraphInterface<V, E> inputGraph){

    }



}
