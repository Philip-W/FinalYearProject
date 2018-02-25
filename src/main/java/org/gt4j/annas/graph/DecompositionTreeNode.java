package org.gt4j.annas.graph;

public class DecompositionTreeNode<V, E extends EdgeInterface<V>>{
    protected GraphInterface<V, E> graph;
    protected GraphInterface<V, E> cutset;

    public boolean isLeaf() {
        return false;
    }


    public GraphInterface<V, E> getCutset() {
        return cutset;
    }

    public DecompositionTreeLeaf getLeaf() {
        return null;
    }

    public DecompositionTreeNode getChild() {
        return null;
    }

    public GraphInterface<V, E> getGraph(){
        return graph;
    };


}
