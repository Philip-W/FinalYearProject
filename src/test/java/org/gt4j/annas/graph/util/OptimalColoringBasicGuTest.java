package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.classifier.IsBasicGu;
import org.gt4j.annas.graph.classifier.IsGu;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class OptimalColoringBasicGuTest<V, E extends EdgeInterface<V>> {
    GraphInterface<String, DefaultEdge> g1;
    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";
    String f = "f";
    String g = "g";
    String h = "h";
    String i = "i";

    /**
     * Ensures no two neighbours in a graph share the same colour
     * @param root
     * @return
     */
    private boolean isColoured(DecompositionTreeNodeInterface<V, E> root) {
        Set<V> vertices = root.getGraph().getVertices();

        for (V vertex : vertices){
            Set<V> nVertex = new HashSet<>();
            Set<E> edges = root.getGraph().getEdges();
            for (E edge : edges){
                nVertex.add(edge.getOtherEndpoint(vertex));
            }

            for (V adj : nVertex){
                if (root.getVertexColor(adj) == root.getVertexColor(vertex))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void colourLongHole() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); g1.addVertex(i);

        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        g1.addEdge(d, i);
        g1.addEdge(i, h);
        g1.addEdge(h, g);
        g1.addEdge(g, f);
        g1.addEdge(f, e);
        g1.addEdge(e, d);

        g1.addEdge(d, a);
        g1.addEdge(d, b);
        g1.addEdge(d, c);

        g1.addEdge(e, a);
        g1.addEdge(e, b);
        g1.addEdge(e, c);

        g1.addEdge(f, a);
        g1.addEdge(f, b);
        g1.addEdge(f, c);

        g1.addEdge(g, a);
        g1.addEdge(g, b);
        g1.addEdge(g, c);

        g1.addEdge(h, a);
        g1.addEdge(h, b);
        g1.addEdge(h, c);

        g1.addEdge(i, a);
        g1.addEdge(i, b);
        g1.addEdge(i, c);

        IsGu<String, DefaultEdge> classifier =
                new IsGu<>();

        DecompositionTreeLeaf<String, DefaultEdge> leaf = new DecompositionTreeLeaf<>(g1, null);


        classifier.classifyLeaf(leaf);
        OptimalColoringBasicGu<String, DefaultEdge> colour = new  OptimalColoringBasicGu<>();
        //System.out.println(colour.computeColoring(leaf));
        assertTrue(colour.computeColoring(leaf) == 5);
        assertTrue(isColoured((DecompositionTreeNodeInterface<V, E>) leaf));
    }

    @Test
    public void colourOddHole() throws Exception {

        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h);// g1.addVertex(i);

        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);


        g1.addEdge(d, h);
        g1.addEdge(h, g);
        g1.addEdge(g, f);
        g1.addEdge(f, e);
        g1.addEdge(e, d);

        g1.addEdge(d, a);
        g1.addEdge(d, b);
        g1.addEdge(d, c);

        g1.addEdge(e, a);
        g1.addEdge(e, b);
        g1.addEdge(e, c);

        g1.addEdge(f, a);
        g1.addEdge(f, b);
        g1.addEdge(f, c);

        g1.addEdge(g, a);
        g1.addEdge(g, b);
        g1.addEdge(g, c);

        g1.addEdge(h, a);
        g1.addEdge(h, b);
        g1.addEdge(h, c);

        //g1.addEdge(i, a);
        //g1.addEdge(i, b);
        //g1.addEdge(i, c);

        IsGu<String, DefaultEdge> classifier =
                new IsGu<>();

        DecompositionTreeLeaf<String, DefaultEdge> leaf = new DecompositionTreeLeaf<>(g1, null);


        classifier.classifyLeaf(leaf);
        OptimalColoringBasicGu<String, DefaultEdge> colour = new  OptimalColoringBasicGu<>();
        assertTrue(colour.computeColoring(leaf) == 6);
        assertTrue(isColoured((DecompositionTreeNodeInterface<V, E>) leaf));
    }
}