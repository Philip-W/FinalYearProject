package org.gt4j.annas.graph;

import java.util.ArrayList;
import java.util.List;

public class DecompositionTreeInnerNode<V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface{
    // Confirmed as a atomic graph
    public boolean isLeaf = false;

    protected ArrayList<DecompositionTreeNodeInterface> children;
    protected ArrayList<DecompositionTreeLeaf> leaves;
    protected GraphInterface<V, E> cutset;

    public DecompositionTreeInnerNode(){
        children = new ArrayList<>();
        leaves = new ArrayList<>();
    }

    public DecompositionTreeInnerNode(GraphInterface<V, E> cutset){
        this.cutset = cutset;
        children = new ArrayList<>();
        leaves = new ArrayList<>();

    }

    public void setCutset(GraphInterface<V, E> cutset){
        this.cutset = cutset;
    }

    @Override
    public void addChild(DecompositionTreeNodeInterface node){
        if (!children.contains(node)){
            children.add(node);
        }
    }

    @Override
    public void addLeaf(DecompositionTreeLeaf leaf){
        if (!leaves.contains(leaf)){
            leaves.add(leaf);
        }
    }

    @Override
    public boolean isLeaf(){return false;}

}
