package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.util.DecomposeByCliqueCutset;
import org.gt4j.annas.graph.util.InducedSubgraph;

import org.gt4j.annas.DefaultWeightedEdge;
import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.util.DecomposeByCliqueCutset;
import org.gt4j.annas.graph.util.InducedSubgraph;
import org.gt4j.annas.graph.util.Utilities;

import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertTrue;

public class IsGuTest {
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

    @Test
    public void testSmallTree() throws Exception {
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

        node.addLeaf(decompLeafA);
        node.addLeaf(decompLeafB);
        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(node));
    }

    @Test
    public void testSmallTreeWithFullDecomp() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); g1.addVertex(i);
        g1.addVertex(j);g1.addVertex(k);
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

        DecomposeByCliqueCutset<String, DefaultEdge> decomp =
                new DecomposeByCliqueCutset<>(g1);

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

        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(root));
    }


    @Test
    public void testMediumTree() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);

        g1.addVertex(o); g1.addVertex(p); g1.addVertex(q);
        g1.addVertex(r); g1.addVertex(s); g1.addVertex(t);

        // Clique 2
        g1.addVertex(l); g1.addVertex(m); g1.addVertex(n);

        g1.addEdge(l, m);
        g1.addEdge(n, m);
        g1.addEdge(l, n);

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


        g1.addEdge(j, a);
        g1.addEdge(j, b);
        g1.addEdge(j, c);

        g1.addEdge(k, a);
        g1.addEdge(k, b);
        g1.addEdge(k, c);

        g1.addEdge(j, l);
        g1.addEdge(j, m);
        g1.addEdge(j, n);

        g1.addEdge(k, l);
        g1.addEdge(k, m);
        g1.addEdge(k, n);

        g1.addEdge(t, l);
        g1.addEdge(t, m);
        g1.addEdge(t, n);

        g1.addEdge(r, l);
        g1.addEdge(r, m);
        g1.addEdge(r, n);

        g1.addEdge(s, l);
        g1.addEdge(s, m);
        g1.addEdge(s, n);

        g1.addEdge(q, l);
        g1.addEdge(q, m);
        g1.addEdge(q, n);

        g1.addEdge(p, l);
        g1.addEdge(p, m);
        g1.addEdge(p, n);

        g1.addEdge(o, l);
        g1.addEdge(o, m);
        g1.addEdge(o, n);

        g1.addEdge(o, p);
        g1.addEdge(p, q);
        g1.addEdge(q, r);

        g1.addEdge(r, s);
        g1.addEdge(s, t);
        g1.addEdge(t, o);


        DecomposeByCliqueCutset<String, DefaultEdge> decomp =
                new DecomposeByCliqueCutset<>(g1);

        DecompositionTreeInnerNode root =
                (DecompositionTreeInnerNode) decomp.getDecomposition();

        //root = (DecompositionTreeInnerNode) root;
        ((DecompositionTreeInnerNode) root).getLeaves();

        while(root.getLeaves().size() != 2){
            DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);
            System.out.println("Leaf Cutset:");
            System.out.println(leaf.getCutset().getVertices());
            System.out.print("Leaf vertices");
            System.out.println(leaf.getGraph().getVertices());
            root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);
        }
        DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);

        System.out.println("Leaf Cutset:");
        System.out.println(leaf.getCutset().getVertices());
        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());

        leaf = (DecompositionTreeLeaf) root.getLeaves().get(1);

        System.out.println("Leaf Cutset:");

        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());

        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(root));

    }

    @Test
    public void testTwoLongHoles() throws Exception{
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); //g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);
        g1.addVertex(l); g1.addVertex(m);
        g1.addVertex(n);

        // Set Clique
        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        g1.addEdge(d, h);
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

        //g1.addEdge(i, a);
        //g1.addEdge(i, b);
        //g1.addEdge(i, c);

        g1.addEdge(j, k);
        g1.addEdge(k, l);
        g1.addEdge(l, m);
        g1.addEdge(m, n);
        g1.addEdge(n, j);

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

        g1.addEdge(n, a);
        g1.addEdge(n, b);
        g1.addEdge(n, c);

        g1.addEdge(g, j);

        DecomposeByCliqueCutset<String, DefaultEdge> decomp =
                new DecomposeByCliqueCutset<>(g1);

        DecompositionTreeInnerNode root =
                (DecompositionTreeInnerNode) decomp.getDecomposition();
/*
        DecompositionTreeInnerNode rootNode = (DecompositionTreeInnerNode) root;
        //DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root;

        DecompositionTreeLeaf  leaf1 = (DecompositionTreeLeaf) rootNode.getLeaves().get(0);
        System.out.println(leaf1.getGraph().getVertices());
        //System.out.println(leaf.getBuType());

        */

        while(root.getLeaves().size() != 2){
            DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);
            System.out.println("Leaf Cutset:");
            System.out.println(leaf.getCutset().getVertices());
            System.out.print("Leaf vertices");
            System.out.println(leaf.getGraph().getVertices());
            root = (DecompositionTreeInnerNode) root.getInnerChildren().get(0);
        }
        DecompositionTreeLeaf leaf = (DecompositionTreeLeaf) root.getLeaves().get(0);

        System.out.println("Leaf Cutset:");
        System.out.println(leaf.getCutset().getVertices());
        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());


        leaf = (DecompositionTreeLeaf) root.getLeaves().get(1);

        //System.out.println("Leaf Cutset:");
        //System.out.println(leaf.getCutset().getVertices());
        System.out.print("Leaf vertices");
        System.out.println(leaf.getGraph().getVertices());



        IsGu<String, DefaultEdge> classify = new IsGu<>();
        assertTrue(classify.classifyTree(root));
    }

}


