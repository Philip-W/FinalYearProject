package org.gt4j.annas.graph;


import org.gt4j.annas.graph.classifier.IsGu;

public class DecompositionTreeLeaf <V, E extends EdgeInterface<V>>
        extends  DecompositionTreeNode<V, E>{

    protected GraphInterface<V, E> leafGraph;
    private boolean isBu;
    private IsGu.Type BuType;


    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph){
        this.leafGraph = leafGraph;
    }

    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph,
                                 GraphInterface<V, E> cutset){
        this.leafGraph = leafGraph;
        this.cutset = cutset;
    }

    public boolean isLeaf(){return true;}

    public GraphInterface<V, E> getGraph() {
        return leafGraph;
    }

    public void setBu(boolean b){ isBu = b; }

    public void setBuType(IsGu.Type type){ BuType = type; }

    public boolean getBu(){return isBu;}
    public IsGu.Type getBuType() { return BuType; }

}

