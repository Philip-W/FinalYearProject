package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.classifier.IsGu;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class testGuMaxClique {
    WeightedVertex a = new WeightedVertex("A", 10);
    WeightedVertex b = new WeightedVertex("B", 10);
    WeightedVertex c = new WeightedVertex("C", 10);
    WeightedVertex d = new WeightedVertex("D", 10);
    WeightedVertex e = new WeightedVertex("E", 10);
    WeightedVertex f = new WeightedVertex("F", 10);
    WeightedVertex g = new WeightedVertex("G", 10);
    WeightedVertex h = new WeightedVertex("H", 10);
    WeightedVertex i = new WeightedVertex("I", 10);
    WeightedVertex j = new WeightedVertex("J", 11);
    WeightedVertex k = new WeightedVertex("K", 10);
    WeightedVertex l = new WeightedVertex("L", 12);
    WeightedVertex m = new WeightedVertex("M", 10);


    @Test
    public void testWighted() throws Exception {
        WeightedVertex v = new WeightedVertex("v", 10);
        WeightedVertex x = new WeightedVertex("x", 13);

        SimpleUndirectedGraph<WeightedVertex, WeightedVertexEdge> g1
                = new SimpleUndirectedGraph<>(WeightedVertexEdge.class
        );

        g1.addVertex(x);
        g1.addVertex(v);
        g1.addEdge(x, v);
    }

    @Test
    public void testSmallTree() throws Exception {
        SimpleUndirectedGraph<WeightedVertex, WeightedVertexEdge> g1
                = new SimpleUndirectedGraph<>(WeightedVertexEdge.class
        );

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


        ArrayList<WeightedVertex> cutset = new ArrayList<>();
        cutset.add(a); cutset.add(b); cutset.add(c);

        DecompositionTreeInnerNode<WeightedVertex, WeightedVertexEdge> node
                = new DecompositionTreeInnerNode<>();
        node.setGraph((GraphInterface<WeightedVertex, WeightedVertexEdge>) g1);
        node.setCutset(InducedSubgraph.inducedSubgraphOf(g1,cutset));

        ArrayList<WeightedVertex> leafA = new ArrayList<>();
        leafA.add(a); leafA.add(b); leafA.add(c);
        leafA.add(d); leafA.add(e); leafA.add(f);
        leafA.add(g); leafA.add(h); leafA.add(i);

        ArrayList<WeightedVertex> leafB = new ArrayList<>();
        leafB.add(a); leafB.add(b);leafB.add(c);
        leafB.add(j); leafB.add(k); leafB.add(l);
        leafB.add(m);

        DecompositionTreeLeaf<WeightedVertex, WeightedVertexEdge> decompLeafA =
                new DecompositionTreeLeaf<>(
                        InducedSubgraph.inducedSubgraphOf(g1,leafA),
                        InducedSubgraph.inducedSubgraphOf(g1,cutset)
                );

        DecompositionTreeLeaf<WeightedVertex, WeightedVertexEdge> decompLeafB =
                new DecompositionTreeLeaf<>(
                        InducedSubgraph.inducedSubgraphOf(g1,leafB),
                        InducedSubgraph.inducedSubgraphOf(g1,cutset)
                );

        node.addChild(decompLeafA);
        node.addChild(decompLeafB);
        IsGu<WeightedVertex, WeightedVertexEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(node));
        GuMaxWeightClique<WeightedVertex, WeightedVertexEdge> maxC =
                new GuMaxWeightClique<>();

        //System.out.println(maxC.getMaxClique(node));
        for (WeightedVertex v : maxC.getMaxClique(node)){
            System.out.println(v.getIdentifier());
        }

    }
}
