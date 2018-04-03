package org.gt4j.annas.graph;

import java.util.ArrayList;

public class DecompositionTreeInnerNode<V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface{
    // Confirmed as a atomic graph
    final boolean isLeaf = false;

    ArrayList<DecompositionTreeInnerNode<V, E>> innerChildren;
    ArrayList<DecompositionTreeNodeInterface<V, E>> children;
    ArrayList<DecompositionTreeLeaf<V, E>> leaves;


    /* For inner nodes, the cutset is the set that seperates the inner node
    graph into 2 further subgraphs
     */
    GraphInterface<V, E> cutset;

    public DecompositionTreeInnerNode(){
        children = new ArrayList<>();
        leaves = new ArrayList<>();
        innerChildren = new ArrayList<>();
    }

    public DecompositionTreeInnerNode(GraphInterface<V, E> cutset){
        this.cutset = cutset;
        children = new ArrayList<>();
        leaves = new ArrayList<>();
        innerChildren = new ArrayList<>();
    }

    public void setCutset(GraphInterface<V, E> cutset){
        this.cutset = cutset;
    }

    public void addChild(DecompositionTreeNodeInterface node){

        if (!children.contains(node)){
            children.add(node);
        }

        if (node.isLeaf() && !leaves.contains(node)){
            leaves.add((DecompositionTreeLeaf) node);
        }

        else if (!innerChildren.contains(node)){
            innerChildren.add((DecompositionTreeInnerNode) node);
        }
    }

    public void addLeaf(DecompositionTreeLeaf leaf){
        if (!leaves.contains(leaf)){
            leaves.add(leaf);
        }
    }

    @Override
    public boolean isLeaf(){return isLeaf;}

    public GraphInterface<V, E> getCutset(){
        return cutset;
    }

    public ArrayList<DecompositionTreeNodeInterface<V, E>> getChildren() {
        return children;
    }

    public GraphInterface getGraph() {
        return null;
    }

    @Override
    public void setVertexColor(Object vertex, int color) {

    }

    @Override
    public int getVertexColor(Object vertex) {
        return 0;
    }

    @Override
    public void swapColors(int to, int from) {

    }

    public ArrayList<DecompositionTreeLeaf<V, E>> getLeaves() {
        return leaves;
    }

    public ArrayList<DecompositionTreeInnerNode<V, E>> getInnerChildren() {
        return innerChildren;
    }
}
