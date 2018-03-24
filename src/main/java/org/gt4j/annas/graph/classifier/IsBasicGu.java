package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;


/**
 * A graph given to this class should be basic (i.e contain no clique cutsets
 * and will classify if the given graph belongs to the class B_u and if so,
 * it will assign the type of B_u it is
 *
 * @param <V>
 * @param <E>
 */
public class IsBasicGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {


    public IsBasicGu(DecompositionTreeLeaf<V, E> leaf){


    }


    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        return false;
    }
}
