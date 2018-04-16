package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsBasicGuTest {

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

    @Test
    public void classifyTestClique() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);
        g1.addVertex(d); g1.addVertex(e);g1.addVertex(f);
        g1.addVertex(g);

        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(a, d);
        g1.addEdge(a, e);
        g1.addEdge(a, f);
        g1.addEdge(a, g);

        g1.addEdge(b, c);
        g1.addEdge(b, d);
        g1.addEdge(b, e);
        g1.addEdge(b, f);
        g1.addEdge(b, g);

        g1.addEdge(c, d);
        g1.addEdge(c, e);
        g1.addEdge(c, f);
        g1.addEdge(c, g);

        g1.addEdge(d, e);
        g1.addEdge(d, f);
        g1.addEdge(d, g);

        g1.addEdge(e, f);
        g1.addEdge(e, g);

        g1.addEdge(f, g);

        IsBasicGu<String, DefaultEdge> classifier =
                new IsBasicGu<>();

        assertTrue(classifier.classify(g1));
    }


    @Test
    public void classifyTestK2() throws Exception {
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

        IsBasicGu<String, DefaultEdge> classifier =
                new IsBasicGu<>();

        assertTrue(classifier.classify(g1));

    }


    @Test
    public void classifyTestLongHole() throws  Exception {
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

        IsBasicGu<String, DefaultEdge> classifier =
                new IsBasicGu<>();

        assertTrue(classifier.classify(g1));


        // make the graph chordal
        g1.addEdge(i, f);
        assertTrue(!classifier.classify(g1));

    }
}