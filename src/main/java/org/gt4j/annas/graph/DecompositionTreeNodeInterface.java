package org.gt4j.annas.graph;

import java.util.ArrayList;

public interface DecompositionTreeNodeInterface <V, E extends EdgeInterface<V>>{

    public boolean isLeaf();

    void addLeaf(DecompositionTreeLeaf n);
    void addChild(DecompositionTreeNodeInterface n);

    GraphInterface<V, E> getCutset();

    GraphInterface<V, E> getGraph();

    ArrayList<DecompositionTreeLeaf> getLeaves();
    ArrayList<DecompositionTreeNodeInterface> getChildren();
}
