package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsGuTest {

    SimpleUndirectedGraph<String, DefaultEdge> testG;

    @Test
    public void classify() throws Exception {
        testG = new SimpleUndirectedGraph(DefaultEdge.class);

        IsGu<String, DefaultEdge> Gu = new IsGu<>();

        Gu.classify(testG);

    }

}