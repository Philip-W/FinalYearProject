package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.util.traverse.LexM;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    String l = "L";
    String m = "M";

    @Test
    public void testCopy() throws  Exception {
        testGraph1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
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
/*
        SimpleUndirectedGraph<String, DefaultEdge> newGraph =
                Utilities.getCopy(testGraph1);

        assertTrue(newGraph.containsVertex(a));
        assertTrue(newGraph.containsVertex(b));
        assertTrue(newGraph.containsVertex(c));
        assertTrue(newGraph.containsVertex(d));
        assertTrue(newGraph.containsVertex(e));
        assertTrue(newGraph.containsVertex(f));
        assertTrue(newGraph.containsVertex(g));

        assertTrue(newGraph.containsEdge(a, b));
        assertTrue(newGraph.containsEdge(b, c));
        assertTrue(newGraph.containsEdge(c, d));
        assertTrue(newGraph.containsEdge(d, e));
        assertTrue(newGraph.containsEdge(e, f));
        assertTrue(newGraph.containsEdge(f, g));
        */
    }

    /** graph from tarjan's paper */
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
        testGraph1.addEdge(k, f);

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
        //decompose.setOrder(order);
        DecompositionTreeInnerNode root = (DecompositionTreeInnerNode) decompose.getDecomposition();

        //DecompositionTreeLeaf root = (DecompositionTreeLeaf) decompose.getDecomposition();
        //System.out.println(root.getGraph().getVertices());


        while(root.getLeaves().size() != 2){
            DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);
            System.out.println(leaf.getGraph().getVertices());
            //System.out.println("Leaf Cutset:");
            //System.out.println(leaf.getCutset().getVertices());
            //System.out.print("Leaf vertices");
            //System.out.println(leaf.getGraph().getVertices());
            root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);
            if (root.getGraph() != null){
            System.out.println(root.getGraph().getVertices());}
        }
        DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);
        System.out.println(leaf.getGraph().getVertices());
        //System.out.println("Leaf Cutset:");
        //System.out.println(leaf.getCutset().getVertices());
        //System.out.print("Leaf vertices");
        //System.out.println(leaf.getGraph().getVertices());

        leaf = (DecompositionTreeLeaf) root.getLeaves().get(1);
        System.out.println(leaf.getGraph().getVertices());
        //System.out.println("Leaf Cutset:");

        //System.out.print("Leaf vertices");
        //System.out.println(leaf.getGraph().getVertices());

/*

        // First layer
        // Check cutset contents
        Set<String> cutset =  root.getCutset().getVertices();
        assertTrue(cutset.contains("F"));
        assertTrue(cutset.contains("D"));
        assertTrue(cutset.contains("C"));
        //System.out.println(root.getLeaves().size());

        // Check first leaf contents
        ArrayList<DecompositionTreeLeaf> leaves = root.getLeaves();
        DecompositionTreeLeaf l = leaves.get(0);
        Set<String> v = l.getGraph().getVertices();
        assertTrue(v.contains("F"));
        assertTrue(v.contains("D"));
        assertTrue(v.contains("C"));
        assertTrue(v.contains("A"));

        //l = leaves.get(1);
        //System.out.println(l.getGraph().getVertices());

        root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);

        // Second layer
        cutset =  root.getCutset().getVertices();
        System.out.println(cutset.toString());

        leaves = root.getLeaves();
        l = leaves.get(0);
        v = l.getGraph().getVertices();

        // Check cutset
        assertTrue(cutset.contains("C"));
        assertTrue(cutset.contains("H"));
        assertTrue(!cutset.contains("A"));

        // Check leaf
        assertTrue(v.contains("C"));
        assertTrue(v.contains("G"));

        root = (DecompositionTreeInnerNode) root.getChildren().get(0);
        // Third Layer

        cutset =  root.getCutset().getVertices();
        leaves = root.getLeaves();
        l = leaves.get(0);
        v = l.getGraph().getVertices();
       // System.out.println()

        // Cutset
        assertTrue(cutset.contains("D"));
        assertTrue(cutset.contains("I"));
        assertTrue(!cutset.contains("A"));

        // Check leaf
        assertTrue(v.contains("E"));
        assertTrue(v.contains("J"));

        //l = leaves.get(1);
        root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);
        l = (DecompositionTreeLeaf) root.getLeaves().get(1);
        System.out.println(root.getLeaves().size());
        v = l.getGraph().getVertices();
        System.out.println(l.getGraph().getVertices());

        assertTrue(v.contains("C"));
        assertTrue(v.contains("D"));
        assertTrue(v.contains("F"));
        assertTrue(v.contains("H"));
        assertTrue(v.contains("I"));
        assertTrue(v.contains("K"));
*/
    }

    @Test
    public void testK2() throws Exception {
        testGraph1 = new SimpleUndirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        testGraph1.addVertex(a);
        testGraph1.addVertex(b);
        testGraph1.addVertex(c);
        testGraph1.addVertex(j); testGraph1.addVertex(k);
        testGraph1.addVertex(l); testGraph1.addVertex(m);



        // Set Clique
        testGraph1.addEdge(a, b);
        testGraph1.addEdge(a, c);
        testGraph1.addEdge(c, b);

        testGraph1.addEdge(j, l);
        testGraph1.addEdge(j, m);
        testGraph1.addEdge(k, m);
        testGraph1.addEdge(k, l);

        testGraph1.addEdge(j, a);
        testGraph1.addEdge(j, b);
        testGraph1.addEdge(j, c);
        testGraph1.addEdge(k, a);
        testGraph1.addEdge(k, b);
        testGraph1.addEdge(k, c);

        testGraph1.addEdge(l, a);
        testGraph1.addEdge(l, b);
        testGraph1.addEdge(l, c);

        testGraph1.addEdge(m, a);
        testGraph1.addEdge(m, b);
        testGraph1.addEdge(m, c);



        DecomposeByCliqueCutset<String, DefaultEdge> decomp =
                new DecomposeByCliqueCutset<>(testGraph1);

        DecompositionTreeInnerNode root =
                (DecompositionTreeInnerNode) decomp.getDecomposition();



        while(root.getLeaves().size() != 2){
            DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);
            //System.out.println("Leaf Cutset:");
            //System.out.println(leaf.getCutset().getVertices());
            System.out.print("Leaf vertices");
            System.out.println(leaf.getGraph().getVertices());
            root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);
        }
        DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);

        //System.out.println("Leaf Cutset:");
        //System.out.println(leaf.getCutset().getVertices());
        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());

        leaf = (DecompositionTreeLeaf) root.getLeaves().get(1);

        //System.out.println("Leaf Cutset:");

        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());
    }


    @Test
    public void testFillInSet() throws Exception {
        // Build  new graph
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

        // Create a fixed order for which we know will generate a particular
        // fill in set
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

        // Ensure appropriate edges have been generated
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

        decompose = new DecomposeByCliqueCutset<>(testGraph1);

        GraphInterface<String, DefaultEdge> fillIn;
        fillIn =
                decompose.getFillInSet(Collections.unmodifiableList(order));

        assertTrue(fillIn.containsEdge(a, c));

    }

    @Test
    public void perfectElimination() throws Exception {
        testGraph1 = new SimpleUndirectedGraph<String, DefaultEdge>(DefaultEdge.class);
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


        testGraph1.addEdge(a, c);
        testGraph1.addEdge(a, e);

        testGraph1.addEdge(c, i);
        testGraph1.addEdge(c, d);
        testGraph1.addEdge(c, e);

        testGraph1.addEdge(e, d);
        testGraph1.addEdge(e, h);
        testGraph1.addEdge(e, i);

        testGraph1.addEdge(d, i);
        testGraph1.addEdge(h, i);

        testGraph1.addEdge(h, j);
        testGraph1.addEdge(i, j);

        testGraph1.addEdge(j, g);
        testGraph1.addEdge(j, f);
        testGraph1.addEdge(g, f);
        testGraph1.addEdge(g, b);
        testGraph1.addEdge(b, f);


        decompose = new DecomposeByCliqueCutset<>(testGraph1);

        LexM<String, DefaultEdge> lex = new LexM<>(testGraph1);
        ArrayList<String> order = lex.getOrder();
        System.out.println(order);

        GraphInterface<String, DefaultEdge> fillIn;
        fillIn =
                decompose.getFillInSet(order);
        System.out.println(fillIn.getEdges());
    }
}