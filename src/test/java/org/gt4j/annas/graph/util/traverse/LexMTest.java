package org.gt4j.annas.graph.util.traverse;

import org.gt4j.annas.graph.DefaultEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LexMTest {

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
    public void test1() throws Exception {
        g1 = new SimpleUndirectedGraph<>(DefaultEdge.class);

        g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);
        g1.addVertex(d);


        g1.addEdge(a, b);
        g1.addEdge(b, c);
        g1.addEdge(c, d);
        LexM<String, DefaultEdge> lex = new LexM<>(g1);
        ArrayList<String> order = lex.getOrder();
        System.out.println(order.toString());

    }


    @Test
    public void test2() throws Exception {
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

        LexM<String, DefaultEdge> lex = new LexM<>(g1);
        ArrayList<String> order = lex.getOrder();
        System.out.println(order.toString());


    }

}