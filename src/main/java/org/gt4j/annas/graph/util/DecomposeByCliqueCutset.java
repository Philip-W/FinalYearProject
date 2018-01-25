package org.gt4j.annas.graph.util;


import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.traverse.LexBFS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    SimpleUndirectedGraph<V, E> graph;
    DecompositionTreeNodeInterface treeRoot;

    public DecomposeByCliqueCutset(final SimpleUndirectedGraph<V, E> inputGraph){
        this.graph = inputGraph;
    }

    /**
     * Here a Lexicographic breadth first search is used to obtain
     * a minimal ordering
     *
     * @return List
     *          Contains a LexBFS ordering
     */
    private List<V> getMinimalOrdering(){
        LexBFS<V> lexBFS = new LexBFS<>(graph);
        return lexBFS.getOrder();
    }

    private GraphInterface<V, E> getFillInSet(List<V> ordering){
        SimpleUndirectedGraph fillInGraph = (SimpleUndirectedGraph) Utilities.getCopy(graph);

        //Map each vertex to it's ordering value
        HashMap<V, Integer> orderingMap = new HashMap<>();
        for (int i = 0; i < ordering.size(); i++){
            orderingMap.put(ordering.get(i), i);
        }

        for ( V vertex : ordering){
            V minVertex = null;
            Set<E> edges =  fillInGraph.getEdges(vertex);

            // find the vertex m(v) = u with the minimum ordering such that an edge
            // v -> u exists
            for (Iterator<E> it = edges.iterator(); it.hasNext();){
                E edge = it.next();
                if (minVertex == null){
                    minVertex = edge.getHead();
                    continue;
                }
                else {
                    if (orderingMap.get(minVertex) > orderingMap.get(edge.getHead())) {
                        minVertex = edge.getHead();
                    }
                }
            }

            // Add edges from all neighbours of vertex to the minVertex
            for (Iterator<E> it = edges.iterator(); it.hasNext();) {
                E edge = it.next();
                if (!edge.getHead().equals(minVertex)){
                    fillInGraph.addEdge(minVertex, edge.getHead());
                }
            }
        }

        return fillInGraph;
    }

    /**
     *
     * @return DecompositionTreeNodeInterface
     *          This method will return the root of the tree after construction
     */
    private DecompositionTreeNodeInterface runDecomposition(){
        //Get Ordering
        List<V> minimalOrder = getMinimalOrdering();
        SimpleUndirectedGraph fillInGraph = (SimpleUndirectedGraph) getFillInSet(minimalOrder);

        //get fill in
        // Get set c(v)
        //call recursive decomposition?
        return treeRoot;
    }

    /**
     *
     * @param treeNode
     *          A graph
     * @return DecompositionTreeNodeInterface
     *          Recursive calls will be made each returning a new layer of the
     *          tree, ultimately returning the root.
     */
    private DecompositionTreeNodeInterface decompose(GraphInterface<V, E> treeNode){

        return null;
    }


    public DecompositionTreeNodeInterface getDecomposition() {
        treeRoot = runDecomposition();
        return treeRoot;
    }
}
