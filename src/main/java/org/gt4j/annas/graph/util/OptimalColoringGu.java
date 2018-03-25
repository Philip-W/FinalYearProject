package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;

import java.util.Set;

public class OptimalColoringGu<V,  E extends EdgeInterface<V>>
        implements ColouringInterface<V> {


    DecompositionTreeNodeInterface<V, E> root;

    public OptimalColoringGu(DecompositionTreeNodeInterface<V, E> node){
        root = node;
    }



    public void setOptimalColoring(){
        // Traverse tree, get coloring for each leaf
        // recursively permute the coloring from the bottom up.

    }


    @Override
    public Set<Set<V>> call() throws Exception {
        return null;
    }
}
