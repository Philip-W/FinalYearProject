package org.gt4j.annas.graph;

import org.gt4j.annas.graph.classifier.IsGu;
import org.gt4j.annas.graph.util.Utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class DecompositionTreeLeaf <V, E extends EdgeInterface<V>> implements DecompositionTreeNodeInterface<V, E> {


    GraphInterface<V, E> leafGraph;


    public DecompositionTreeLeaf(GraphInterface<V, E> leafGraph, GraphInterface<V, E> cutset){
        this.cutset = cutset;
        this.leafGraph = leafGraph;
        complement = Utilities.getComplement(
                (SimpleUndirectedGraph<V, E>) leafGraph);

        antiComponents = Utilities.getConnectedComponents(complement);

        vertexToColor = new HashMap<>();
        colorToVertices = new MultiHashMap<>();
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


    /*******************************************************/
    /* G_u specific information */
    /*******************************************************/

    // Default b_u to false as it is unclassified
    private boolean isBu = false;
    private IsGu.Type BuType;

    private ArrayList<V> maxWeightClique;
    private int cliqueWeight;

    /* For decomp leaves the cutset is the set used to seperate the leaf from
    the previous inner node
     */
    GraphInterface<V, E> cutset;
    private GraphInterface<V, E> complement;
    private Collection<Collection<V>> antiComponents;

    // maps each vertex to a color
    private HashMap<V, Integer> vertexToColor;

    // maps each color to a list of vertices with that color
    private MultiHashMap<Integer, V> colorToVertices;

    public void setBu(boolean b){ isBu = b; }

    public void setBuType(IsGu.Type type){ BuType = type; }

    public boolean getBu(){return isBu;}

    public IsGu.Type getBuType() { return BuType; }

    public void setMaxWeightClique(ArrayList<V> maxWeightClique) {
        this.maxWeightClique = maxWeightClique;
    }

    public void setCliqueWeight(int weight){
        cliqueWeight = weight;
    }

    public int getCliqueWeight(){ return cliqueWeight; }

    public ArrayList<V> getMaxWeightClique(){
        return maxWeightClique;
    }

    public SimpleUndirectedGraph<V, E> getComplement(){
        return (SimpleUndirectedGraph<V, E>) complement;
    }

    public Collection<Collection<V>> getAntiComponents() {
         return antiComponents;
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
        if(setFrom != null) {
            for (V v : setFrom) {
                vertexToColor.put(v, to);
            }
        }
        if (setTo != null) {
            for (V v : setTo) {
                vertexToColor.put(v, from);
            }
        }
    }


}

