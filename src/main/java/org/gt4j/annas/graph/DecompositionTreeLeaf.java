package org.gt4j.annas.graph;

import java.util.ArrayList;

public class DecompositionTreeLeaf <V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface {


    GraphInterface<V, E> leafGraph;

    /* For decomp leaves the cutset is the set used to seperate the leaf from
    the previous inner node
     */
    GraphInterface<V, E> cutset;

    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph, GraphInterface<V, E> cutset){
        this.cutset = cutset;
        this.leafGraph = leafGraph;
    }


    public GraphInterface<V, E> getLeafGraph() { return leafGraph; }

    public boolean isLeaf(){return true;}

    @Override
    public GraphInterface getCutset() {
        return cutset;
    }

    @Override
    public GraphInterface getGraph() {
        return leafGraph;
    }

}

