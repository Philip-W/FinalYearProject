package org.gt4j.annas.graph;

public class DecompositionTreeLeaf <V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface {


    protected GraphInterface<V, E> leafGraph;

    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph){
        this.leafGraph = leafGraph;
    }


    public GraphInterface<V, E> getLeafGraph() { return leafGraph; }

    public boolean isLeaf(){return true;}
}

