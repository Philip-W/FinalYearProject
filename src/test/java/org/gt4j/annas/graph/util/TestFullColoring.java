package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.classifier.IsGu;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class TestFullColoring<V, E extends EdgeInterface<V>> {
    SimpleUndirectedGraph <String, DefaultEdge> g1;

    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";
    String f = "f";
    String g = "g";
    String h = "h";
    String i = "i";
    String j = "j";
    String k = "k" ;
    String l = "l";
    String m = "m";
    String n = "n";
    String o = "o";
    String p = "p";
    String q = "q";
    String r = "r";
    String s = "s";
    String t = "t";

    /**
     * Ensures no two neighbours in a graph share the same colour
     * @param root
     * @return
     */
    private boolean isColoured(DecompositionTreeNodeInterface<V, E> root) {
        Set<V> vertices = root.getGraph().getVertices();

        for (V vertex : vertices){
            System.out.println(vertex + " : " + root.getVertexColor(vertex));
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
    public void smallTree() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);
        g1.addVertex(l); g1.addVertex(m);

        // Set Clique
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

        // K2
        g1.addEdge(j, l);
        g1.addEdge(j, m);
        g1.addEdge(k, m);
        g1.addEdge(k, l);

        g1.addEdge(j, a);
        g1.addEdge(j, b);
        g1.addEdge(j, c);
        g1.addEdge(k, a);
        g1.addEdge(k, b);
        g1.addEdge(k, c);

        g1.addEdge(l, a);
        g1.addEdge(l, b);
        g1.addEdge(l, c);

        g1.addEdge(m, a);
        g1.addEdge(m, b);
        g1.addEdge(m, c);


        ArrayList<String> cutset = new ArrayList<>();
        cutset.add(a); cutset.add(b); cutset.add(c);

        DecompositionTreeInnerNode<String, DefaultEdge> node
                = new DecompositionTreeInnerNode<>();
        node.setGraph((GraphInterface<String, DefaultEdge>) g1);
        node.setCutset(InducedSubgraph.inducedSubgraphOf(g1,cutset));

        ArrayList<String> leafA = new ArrayList<>();
        leafA.add(a); leafA.add(b); leafA.add(c);
        leafA.add(d); leafA.add(e); leafA.add(f);
        leafA.add(g); leafA.add(h); leafA.add(i);

        ArrayList<String> leafB = new ArrayList<>();
        leafB.add(a); leafB.add(b);leafB.add(c);
        leafB.add(j); leafB.add(k); leafB.add(l);
        leafB.add(m);

        DecompositionTreeLeaf<String, DefaultEdge> decompLeafA =
                new DecompositionTreeLeaf<>(
                        InducedSubgraph.inducedSubgraphOf(g1,leafA),
                        InducedSubgraph.inducedSubgraphOf(g1,cutset)
                );

        DecompositionTreeLeaf<String, DefaultEdge> decompLeafB =
                new DecompositionTreeLeaf<>(
                        InducedSubgraph.inducedSubgraphOf(g1,leafB),
                        InducedSubgraph.inducedSubgraphOf(g1,cutset)
                );

        node.addChild(decompLeafA);
        node.addChild(decompLeafB);
        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(node));


        OptimalColoringGu<String, DefaultEdge> colour = new  OptimalColoringGu<>(node);
        colour.setOptimalColoring();

        //assertTrue(colour.computeColoring(leaf) == 6);
        assertTrue(isColoured((DecompositionTreeNodeInterface<V, E>) node));


    }
}
