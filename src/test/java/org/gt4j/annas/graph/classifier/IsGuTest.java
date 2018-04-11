package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.InducedSubgraph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class IsGuTest {
    SimpleUndirectedGraph<String, DefaultEdge> g1;
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

    @Test
    public void testSingleLeaf() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);

        // Set Clique
        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        g1.addEdge(d, a);
        g1.addEdge(d, c);
        g1.addEdge(d, b);
        g1.addEdge(d, f);
        g1.addEdge(d, g);

        g1.addEdge(e, a);
        g1.addEdge(e, c);
        g1.addEdge(e, b);
        g1.addEdge(e, f);
        g1.addEdge(e, g);

        g1.addEdge(f, a);
        g1.addEdge(f, c);
        g1.addEdge(f, b);

        g1.addEdge(g, a);
        g1.addEdge(g, c);
        g1.addEdge(g, b);
        ArrayList<String> cutset = new ArrayList<>();
        cutset.add(a); cutset.add(b); cutset.add(c);

        InducedSubgraph.inducedSubgraphOf(g1,cutset);

        DecompositionTreeLeaf<String, DefaultEdge> leaf =
                new DecompositionTreeLeaf<>(g1,
                        InducedSubgraph.inducedSubgraphOf(g1,cutset));

        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(leaf));
    }



}
