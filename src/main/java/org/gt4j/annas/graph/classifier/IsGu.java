package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.GraphInterface;

public class IsGu<V, E extends EdgeInterface<V>> implements Classifier<V, E>  {


    @Override
    public boolean classify(GraphInterface<V, E> graph) {
        return false;
    }

    public boolean classify(DecompositionTreeNodeInterface root){

        return false;
    }
}
