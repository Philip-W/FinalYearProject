package org.gt4j.annas.graph;

import java.util.ArrayList;

public interface DecompositionTreeNodeInterface <V, E extends EdgeInterface<V>>{

    public boolean isLeaf();

    GraphInterface<V, E> getCutset();

    GraphInterface<V, E> getGraph();


}
