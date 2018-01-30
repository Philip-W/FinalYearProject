package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DecomposeByCliqueCutsetTest {

    SimpleUndirectedGraph<String, DefaultEdge> testGraph1;
    DecomposeByCliqueCutset<String, DefaultEdge> decompose;

    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";
    String e = "E";
    String f = "F";
    String g = "G";
    String h = "H";
    String i = "I";
    String j = "J";
    String k = "K";

    @Test
    public void testDecomposition() throws Exception {
        testGraph1 = new SimpleUndirectedGraph<>(
                DefaultEdge.class);

        testGraph1.addVertex(a);
        testGraph1.addVertex(b);
        testGraph1.addVertex(c);
        testGraph1.addVertex(d);
        testGraph1.addVertex(e);
        testGraph1.addVertex(f);
        testGraph1.addVertex(g);
        testGraph1.addVertex(h);
        testGraph1.addVertex(i);
        testGraph1.addVertex(j);
        testGraph1.addVertex(k);

        testGraph1.addEdge(a, c);
        testGraph1.addEdge(a, d);
        testGraph1.addEdge(a, f);

        testGraph1.addEdge(b, c);
        testGraph1.addEdge(b, g);

        testGraph1.addEdge(c, d);
        testGraph1.addEdge(c, h);
        testGraph1.addEdge(c, f);

        testGraph1.addEdge(d, f);
        testGraph1.addEdge(d, e);
        testGraph1.addEdge(d, i);

        testGraph1.addEdge(e, j);


        testGraph1.addEdge(g, h);

        testGraph1.addEdge(h, k);

        testGraph1.addEdge(i, k);
        testGraph1.addEdge(i, j);

        List<String> order = new ArrayList<>();
        order.add(a);
        order.add(g);
        order.add(b);
        order.add(h);
        order.add(e);
        order.add(j);
        order.add(i);
        order.add(k);
        order.add(c);
        order.add(d);
        order.add(f);

        decompose = new DecomposeByCliqueCutset<>(testGraph1);
        decompose.setOrder(order);
        DecompositionTreeNodeInterface root = decompose.getDecomposition();

        DecompositionTreeNodeInterface temp;
        System.out.println(root.isLeaf());
        System.out.println(root.getCutset().getVertices());

        ArrayList<DecompositionTreeLeaf> leaves = root.getLeaves();
        for (DecompositionTreeLeaf l : leaves) {
            System.out.println(l.getGraph().getVertices());
        }
    }


    @Test
    public void testFillInSet() throws Exception {
        testGraph1 = new SimpleUndirectedGraph<>(
                DefaultEdge.class);

        testGraph1.addVertex(a);
        testGraph1.addVertex(b);
        testGraph1.addVertex(c);
        testGraph1.addVertex(d);
        testGraph1.addVertex(e);
        testGraph1.addVertex(f);
        testGraph1.addVertex(g);

        testGraph1.addEdge(a, b);
        testGraph1.addEdge(b, c);
        testGraph1.addEdge(c, d);
        testGraph1.addEdge(d, e);
        testGraph1.addEdge(e, f);
        testGraph1.addEdge(f, g);


        List<String> order = new ArrayList<>();
        order.add(f);
        order.add(e);
        order.add(d);
        order.add(c);
        order.add(b);
        order.add(a);
        order.add(g);

        decompose = new DecomposeByCliqueCutset<>(testGraph1);
        GraphInterface<String, DefaultEdge> fillIn;
        fillIn =
                decompose.getFillInSet(Collections.unmodifiableList(order));


        assertTrue(fillIn.containsEdge(a, g));
        assertTrue(fillIn.containsEdge(b, g));
        assertTrue(fillIn.containsEdge(c, g));
        assertTrue(fillIn.containsEdge(d, g));
        assertTrue(fillIn.containsEdge(e, g));

    }
    @Test
    public void testBasicFillInSet() throws  Exception {
        testGraph1 = new SimpleUndirectedGraph<>(
                DefaultEdge.class);

        testGraph1.addVertex(a);
        testGraph1.addVertex(b);
        testGraph1.addVertex(c);
        testGraph1.addEdge(a, b);
        testGraph1.addEdge(b, c);

        List<String> order = new ArrayList<>();
        order.add(b);
        order.add(a);
        order.add(c);
        //System.out.println(testGraph1.getEdges());

        decompose = new DecomposeByCliqueCutset<>(testGraph1);

        GraphInterface<String, DefaultEdge> fillIn;
        fillIn =
                decompose.getFillInSet(Collections.unmodifiableList(order));



        //System.out.println(fillIn.getEdges());
        assertTrue(fillIn.containsEdge(a, c));


    }




    @Test
    public void getDecomposition() throws Exception {


    }

}