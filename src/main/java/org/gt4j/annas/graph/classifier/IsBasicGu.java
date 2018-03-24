package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.Utilities;

import java.util.Collection;


/**
 * A graph given to this class should be basic (i.e contain no clique cutsets
 * and will classify if the given graph belongs to the class B_u and if so,
 * it will assign the type of B_u it is
 *
 * @param <V>
 * @param <E>
 */
public class IsBasicGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {

    private DecompositionTreeLeaf<V, E> leaf;
    private GraphInterface<V, E> graph;
    private SimpleUndirectedGraph<V, E> complement;
    private Collection<Collection<V>> complementComponents;

    public IsBasicGu(DecompositionTreeLeaf<V, E> leaf){
        this.leaf = leaf;
        graph = leaf.getGraph();
        complement = Utilities.getComplement((SimpleUndirectedGraph<V, E>) graph);
        complementComponents = Utilities.
                getConnectedComponents(complement);
    }


    /** Tests the following condition:
     *      * G has exactly one nontrivial anticomponent, and this anticomponent
     *        is a long hole (Cycle length >=5)
     * @return
     */
    private boolean isLongHoleCondition(){
        //Every component is trivial bar 1 component, which is a long hole in G
        int loopCount = 0; // Counts the number of non trivial anticomponenets
        for (Collection<V> comp : complementComponents) {
            if (comp.size() == 1){ continue; } // Is trivial
            else{
                if (comp.size() < 5){ return false; }
                loopCount++;
                for (V vertex : comp){
                    if (graph.getDegree(vertex) != 2){
                        return false;
                    }
                }
            }
        }
        return loopCount == 1;
    }


    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        return false;
    }
}
