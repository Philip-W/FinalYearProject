package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;

public class IsGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {


    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        return false;
    }

    public boolean classify(DecompositionTreeNodeInterface root){

        return false;
    }

    /**
     * Tests the following condition:
     *      * G has exactly one nontrivial anticomponent, and this anticomponent
     *          is a long hole (Cycle length >=5)
     *
     * @param graph
     * @return
     */
    private boolean isLongHole(SimpleUndirectedGraph<V, E> graph){
        return false;
    }

    /**
     * Tests the following condition:
     *  * All non-trivial anticomponents of G are isomorphic to the complement of
     *      K_2.
     *
     * @param graph
     * @return
     */
    private boolean isIsomorphic(SimpleUndirectedGraph<V, E> graph){
        return false;
    }
}
