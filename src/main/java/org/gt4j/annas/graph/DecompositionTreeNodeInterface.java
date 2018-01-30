package org.gt4j.annas.graph;

public interface DecompositionTreeNodeInterface <V, E extends EdgeInterface<V>>{

    public boolean isLeaf();

    void addLeaf(DecompositionTreeLeaf n);
    void addChild(DecompositionTreeNodeInterface n);
}
