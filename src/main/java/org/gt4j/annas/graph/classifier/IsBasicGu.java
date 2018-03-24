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
public class IsBasicGu<V, E extends EdgeInterface<V>> implements
        Classifier<V, E> {

    private DecompositionTreeLeaf<V, E> leaf;
    private GraphInterface<V, E> graph;
    private SimpleUndirectedGraph<V, E> complement;
    private Collection<Collection<V>> complementComponents;

    // Allows access to which type the graph was classified as.
    private IsGu.Type lastClassifiedType;

    public IsGu.Type getLastClassifiedType() {
        return lastClassifiedType;
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

    /**
     * Tests the following condition:
     *  * All non-trivial anticomponents of G are isomorphic to the complement of
     *      K_2.
     *
     * @return
     */
    private boolean isIsomorphicToK2(){
        for (Collection<V> comp : complementComponents){
            if (comp.size() == 1){continue;}
            else if (comp.size() == 2 && !graph.containsEdge((V) comp.toArray()[0], (V)comp.toArray()[1])){
                continue;
            }
            else{ return false;}
        }
        return true;
    }


    /** Input should be a simple undirected graph */
    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        this.graph = graph;
        complement = Utilities.getComplement((SimpleUndirectedGraph<V, E>) graph);
        complementComponents = Utilities.
                getConnectedComponents(complement);

        if (isIsomorphicToK2()){
            lastClassifiedType = IsGu.Type.K2;
            return true;
        }
        else if (isLongHoleCondition()) {
            lastClassifiedType = IsGu.Type.HOLE;
            return true;
        }
        else {
            lastClassifiedType = IsGu.Type.FALSE;
            return false;
        }
    }
}
