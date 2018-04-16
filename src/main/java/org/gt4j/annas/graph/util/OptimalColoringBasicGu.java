package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.classifier.IsGu;

import java.util.Collection;

public class OptimalColoringBasicGu<V,  E extends EdgeInterface<V>> {


    private int colorLongHole(DecompositionTreeLeaf<V, E> leaf){
        int color = 1; // This is the next free colour

        for (Collection<V> component : leaf.getAntiComponents()){
            // Vertex is complete to every other vertex, should be unique color
            if (component.size() == 1){
                leaf.setVertexColor((V) component.toArray()[0], color);
                color++;
            }
            // Else is a long hole
            else {
                V vertex = (V) component.toArray()[0];
                leaf.setVertexColor(vertex, color);
                //leaf.getLeafGraph().getEdges(vertex);
                V adj1, adj2; // 2 adjacent neighbours
                SimpleUndirectedGraph<V, E> graph =
                        InducedSubgraph.inducedSubgraphOf(
                                (SimpleUndirectedGraph<V, E>) leaf.getLeafGraph()
                                , component);

                E edge = (E) graph.getEdges(vertex).toArray()[0];
                vertex = edge.getOtherEndpoint(vertex);


                while (true){
                    // This should only return 2 edges! requires testing.
                    adj1 =  ((E)graph.getEdges(vertex).toArray()[0]).getOtherEndpoint(vertex);
                    adj2 = ((E)graph.getEdges(vertex).toArray()[1]).getOtherEndpoint(vertex);;
                    int leftColor = leaf.getVertexColor(adj1);
                    int rightColor = leaf.getVertexColor(adj2);

                    // One unColored vertex
                    if (leftColor == -1 || rightColor == -1){
                        V nextVertex = leftColor == -1 ? adj1 : adj2;
                        V previousV  = rightColor == -1 ? adj1 : adj2;

                        int previousCol = leaf.getVertexColor(previousV);
                        if (previousCol == color){
                            leaf.setVertexColor(vertex, color+1);
                        }
                        else { leaf.setVertexColor(vertex, color); }
                        vertex = nextVertex;
                        continue;
                    }

                    // Reached end and parity is even
                    else if (leftColor == rightColor){
                        if (leftColor == color){
                            leaf.setVertexColor(vertex, color + 1);
                        }
                        else {
                            leaf.setVertexColor(vertex, color);
                        }
                        break;
                    }

                    // reached the end of the circle and the parity is odd
                    else {
                        leaf.setVertexColor(vertex, color + 2);
                        break;
                    }
                }
                // find parity of long hole, if even 2 colors used, 3 if odd.
                int colorsused = component.size() % 2;
                color += colorsused == 1 ? 3 : 2;
            }

        }
        return --color;
    }


    private int colorK2(DecompositionTreeLeaf<V, E> leaf){
        int color = 1;
        for (Collection<V> component : leaf.getAntiComponents()){
            if (component.size() == 1){
                leaf.setVertexColor((V) component.toArray()[0], color);
                color++;
            }
            else{
                leaf.setVertexColor((V) component.toArray()[0], color);
                leaf.setVertexColor((V) component.toArray()[1], color);
                color++;
            }
        }
        return color;
    }

    /**
     * Computes the coloring of a given leaf, returning the number of colors
     * required to color the leaf graph.
     *
     * @param leaf
     * @return
     */
    public int computeColoring(DecompositionTreeLeaf<V, E> leaf){
        if ( !leaf.getBu()) { return -1; } // Throw wrong class error
        else {
            if (leaf.getBuType() == IsGu.Type.K2){
                return colorK2(leaf);
            }
            else {
                return colorLongHole(leaf);
            }
        }
    }
}
