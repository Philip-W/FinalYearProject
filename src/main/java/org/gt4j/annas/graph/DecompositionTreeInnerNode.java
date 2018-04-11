package org.gt4j.annas.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DecompositionTreeInnerNode<V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface<V, E>{
    // Confirmed as a atomic graph
    final boolean isLeaf = false;

    ArrayList<DecompositionTreeInnerNode<V, E>> innerChildren;
    ArrayList<DecompositionTreeNodeInterface<V, E>> children;
    ArrayList<DecompositionTreeLeaf<V, E>> leaves;

    // maps each vertex to a color
    private HashMap<V, Integer> vertexToColor;

    // maps each color to a list of vertices with that color
    private MultiHashMap<Integer, V> colorToVertices;
    private SimpleUndirectedGraph<V, E> graph;

    /* For inner nodes, the cutset is the set that seperates the inner node
    graph into 2 further subgraphs
     */
    GraphInterface<V, E> cutset;

    public DecompositionTreeInnerNode(){
        children = new ArrayList<>();
        leaves = new ArrayList<>();
        innerChildren = new ArrayList<>();
        vertexToColor = new HashMap<>();
        colorToVertices = new MultiHashMap<>();
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
    public void setVertexColor(V vertex, int color){
        colorToVertices.put(color, vertex);
        vertexToColor.put(vertex, color);
    }

    @Override
    public int getVertexColor(V vertex){
        return vertexToColor.getOrDefault(vertex, -1);
    }


    public ArrayList<DecompositionTreeLeaf<V, E>> getLeaves() {
        return leaves;
    }

    public ArrayList<DecompositionTreeInnerNode<V, E>> getInnerChildren() {
        return innerChildren;
    }


    /**
     * Swaps two colors in both hash tables, used for permuting cutsets.
     * @param to
     * @param from
     */
    @Override
    public void swapColors(int to, int from) {
        // Handle colorToVertices
        Collection<V> setFrom = colorToVertices.getCollection(from);
        Collection<V> setTo   = colorToVertices.getCollection(to);

        colorToVertices.remove(to);
        colorToVertices.remove(from);

        colorToVertices.putAll(to ,setFrom);
        colorToVertices.putAll(from, setTo);

        for (V v : setFrom){ vertexToColor.put(v, to); }

        for (V v : setTo){ vertexToColor.put(v, from); }
    }


    public void setGraph(SimpleUndirectedGraph g){
        graph = g;
    }
}
