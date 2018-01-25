package org.gt4j.annas.graph.util;


import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;

import java.util.List;

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
    DecompositionTreeNodeInterface treeRoot;

    public DecomposeByCliqueCutset(final GraphInterface<V, E> inputGraph){
        this.graph = inputGraph;
    }

    private List<V> getMinimalOrdering(){
        return null;
    }

    private GraphInterface<V, E> getFillInSet(){
        return null;
    }

    /**
     *
     * @return DecompositionTreeNodeInterface
     *          This method will return the root of the tree after construction
     */
    private DecompositionTreeNodeInterface runDecomposition(){
        //Get Ordering
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
