package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.WeightedVertex;

import java.util.ArrayList;

public class GuMaxWeightClique<V extends WeightedVertex,
        E extends EdgeInterface<V>> {


    public ArrayList<V> getMaxClique(DecompositionTreeNodeInterface<V, E> root){

        return new ArrayList<>();
    }
}
