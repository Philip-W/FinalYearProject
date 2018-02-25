package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeNode;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.Utilities;

import java.util.Collection;

public class IsGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {

    public boolean classify(SimpleUndirectedGraph<V, E> graph) {
        SimpleUndirectedGraph<V, E> comp = Utilities.getComplement(graph);
        Collection<Collection<V>> components = Utilities.getConnectedComponents(comp);

        if (components.size() == 1){
            return isLongHole(graph);
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
    private boolean isLongHole(SimpleUndirectedGraph<V, E> graph){
        if (graph.getVertices().size() < 5){
            return false;
        }
        for (V v : graph.getVertices()){
            if (graph.getDegree(v) != 2){
                return false;
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
            if (comp.size() == 2 && graph.containsEdge((V) comp.toArray()[0], (V)comp.toArray()[1])){
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
