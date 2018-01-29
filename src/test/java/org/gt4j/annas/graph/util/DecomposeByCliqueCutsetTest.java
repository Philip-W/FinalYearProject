package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
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

        decompose.getDecomposition();
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