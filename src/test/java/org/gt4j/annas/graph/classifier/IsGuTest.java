package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsGuTest {

    SimpleUndirectedGraph<String, DefaultEdge> testG;
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";
    String e = "E";
    String f = "F";

    @Test
    public void classify() throws Exception {
        testG = new SimpleUndirectedGraph(DefaultEdge.class);
        testG.addVertices(a);
        testG.addVertices(b);
        testG.addVertices(c);
        testG.addVertices(d);
        testG.addVertices(e);
        testG.addVertices(f);

        testG.addEdge(a, b);
        testG.addEdge(b, c);
        testG.addEdge(c, d);
        testG.addEdge(d, e);
        testG.addEdge(e, f);
        testG.addEdge(f, a);


        IsGu<String, DefaultEdge> Gu = new IsGu<>();

        assertTrue(Gu.classify(testG));

    }

}