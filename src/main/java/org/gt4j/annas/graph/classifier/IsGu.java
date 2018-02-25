package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeNode;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.Utilities;

import java.util.Collection;

public class IsGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {
    public enum Type {HOLE, K2 }


    public boolean classify(SimpleUndirectedGraph<V, E> graph) {
        SimpleUndirectedGraph<V, E> complement = Utilities.getComplement(graph);
        Collection<Collection<V>> components = Utilities.
                getConnectedComponents(complement);

        int nonTrivial = 0;
        int trivial = 0;
        for (Collection<V> component : components){
            if (component.size() == 1){ trivial++; }
            else{ nonTrivial++; }
        }
        if (nonTrivial == 1){
            return isLongHoleCondition(graph, components);
        }
        else{
            return isIsomorphic(graph, components);
        }
    }

    public boolean classify(DecompositionTreeNode root){
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
    private boolean isLongHoleCondition(SimpleUndirectedGraph<V, E> graph,
                               Collection<Collection<V>> components){
        //Every component is trivial bar 1 component, which is a long hole in G
        for (Collection<V> comp : components) {
            if (comp.size() == 1){ continue; } // Is trivial
            else{
                for (V vertex : comp){
                    if (graph.getDegree(vertex) != 2){
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * Tests the following condition:
     *  * All non-trivial anticomponents of G are isomorphic to the complement of
     *      K_2.
     *
     * @param graph
     * @return
     */
    private boolean isIsomorphic(SimpleUndirectedGraph<V, E> graph,
                                 Collection<Collection<V>> components){
        for (Collection<V> comp : components){
            if (comp.size() == 1){continue;}
            if (comp.size() == 2 && !graph.containsEdge((V) comp.toArray()[0], (V)comp.toArray()[1])){
                continue;
            }
            else{ return false;}
        }
        return true;
    }

    private boolean isTrivial(SimpleUndirectedGraph<V, E> graph){
        if (graph.getVertices().size() == 1){  return true; }
        return false;
    }

    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        return false;
    }
}
