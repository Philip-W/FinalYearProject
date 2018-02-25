package org.gt4j.annas.graph;

import java.util.ArrayList;

public class DecompositionTreeInnerNode<V, E extends EdgeInterface<V>> extends DecompositionTreeNode {
    // Confirmed as a atomic graph
    public boolean isLeaf = false;

    protected DecompositionTreeNode child;
    protected DecompositionTreeLeaf leaf;
    //protected GraphInterface<V, E> cutset;


    public DecompositionTreeInnerNode(GraphInterface<V, E> cutset){
        this.cutset = cutset;
    }

    public void setCutset(GraphInterface<V, E> cutset){
        this.cutset = cutset;
    }

    public void setChild(DecompositionTreeNode node){ this.child = node; }


    public void setLeaf(DecompositionTreeLeaf leaf){ this.leaf = leaf; }

    @Override
    public boolean isLeaf(){return false;}

    public DecompositionTreeNode<V, E> getChild() {
        return child;
    }

    @Override
    public GraphInterface getGraph() {
        return null;
    }

    public DecompositionTreeLeaf getLeaf() {
        return leaf;
    }
}
