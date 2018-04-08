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

}