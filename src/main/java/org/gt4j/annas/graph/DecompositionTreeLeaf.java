package org.gt4j.annas.graph;


public class DecompositionTreeLeaf <V, E extends EdgeInterface<V>>
        extends  DecompositionTreeNode<V, E>{

    protected GraphInterface<V, E> leafGraph;
    private boolean isBu;


    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph){
        this.leafGraph = leafGraph;
    }

    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph,
                                 GraphInterface<V, E> cutset){
        this.leafGraph = leafGraph;
        this.cutset = cutset;
    }

    public GraphInterface<V, E> getLeafGraph() { return leafGraph; }

    public boolean isLeaf(){return true;}

    public GraphInterface getGraph() {
        return leafGraph;
    }
}

