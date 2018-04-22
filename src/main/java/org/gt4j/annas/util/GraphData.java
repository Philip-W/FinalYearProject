package org.gt4j.annas.util;

import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.WeightedVertex;
import org.gt4j.annas.graph.WeightedVertexEdge;

public class GraphData {

    public SimpleUndirectedGraph<WeightedVertex, WeightedVertexEdge> graph;
    public boolean isGu;
    public int optimalColor;
    public int maxCliqueWeight;

}
