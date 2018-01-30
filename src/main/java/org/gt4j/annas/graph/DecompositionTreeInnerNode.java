package org.gt4j.annas.graph;

import java.util.ArrayList;
import java.util.List;

public class DecompositionTreeInnerNode<V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface{
    // Confirmed as a atomic graph

    protected ArrayList<DecompositionTreeNodeInterface> children;
    protected ArrayList<DecompositionTreeLeaf> leaves;
    protected GraphInterface<V, E> cutset;

    public DecompositionTreeInnerNode(){

    }
}
