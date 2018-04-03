package org.gt4j.annas.graph;

import java.util.ArrayList;

public interface DecompositionTreeNodeInterface <V, E extends EdgeInterface<V>>{

    boolean isLeaf();

    GraphInterface<V, E> getCutset();

    GraphInterface<V, E> getGraph();


    void setVertexColor(V vertex, int color);

    int getVertexColor(V vertex);

    void swapColors(int to, int from);

}
