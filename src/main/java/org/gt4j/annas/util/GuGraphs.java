package org.gt4j.annas.util;

import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.WeightedVertex;
import org.gt4j.annas.graph.WeightedVertexEdge;

public class GuGraphs {
    private static WeightedVertex a = new WeightedVertex("a", 12);
    private static WeightedVertex b = new WeightedVertex("b", 13);
    private static WeightedVertex c = new WeightedVertex("c", 10);
    private static WeightedVertex d = new WeightedVertex("d", 10);
    private static WeightedVertex e = new WeightedVertex("e", 10);
    private static WeightedVertex f = new WeightedVertex("f", 10);
    private static WeightedVertex g = new WeightedVertex("g", 10);
    private static WeightedVertex h = new WeightedVertex("h", 10);
    private static WeightedVertex i = new WeightedVertex("i", 10);
    private static WeightedVertex j = new WeightedVertex("j", 10);
    private static WeightedVertex k = new WeightedVertex("k", 15);
    private static WeightedVertex l = new WeightedVertex("l", 20);
    private static WeightedVertex m = new WeightedVertex("m", 9);
    private static WeightedVertex n = new WeightedVertex("n", 10);
    private static WeightedVertex o = new WeightedVertex("o", 10);
    private static WeightedVertex p = new WeightedVertex("p", 20);
    private static WeightedVertex q = new WeightedVertex("q", 28);
    private static WeightedVertex r = new WeightedVertex("r", 25);
    private static WeightedVertex s = new WeightedVertex("s", 10);
    private static WeightedVertex t = new WeightedVertex("t", 10);
    private static WeightedVertex u = new WeightedVertex("u", 10);
    private static WeightedVertex v = new WeightedVertex("v", 10);
    private static WeightedVertex w = new WeightedVertex("w", 100);
    private static WeightedVertex x = new WeightedVertex("x", 10);
    private static WeightedVertex y = new WeightedVertex("y", 10);
    private static WeightedVertex z = new WeightedVertex("z", 10);

    private static WeightedVertex a1 = new WeightedVertex("a1", 10);
    private static WeightedVertex a2 = new WeightedVertex("a2", 10);
    private static WeightedVertex a3 = new WeightedVertex("a3", 10);
    private static WeightedVertex a4 = new WeightedVertex("a4", 10);
    private static WeightedVertex a5 = new WeightedVertex("a5", 10);
    private static WeightedVertex a6 = new WeightedVertex("a6", 10);

    private static WeightedVertex a7 = new WeightedVertex("a7", 10);
    private static WeightedVertex a8 = new WeightedVertex("a8", 10);
    private static WeightedVertex a9 = new WeightedVertex("a9", 10);
    private static WeightedVertex a10 = new WeightedVertex("a10", 10);
    private static WeightedVertex a11 = new WeightedVertex("a11", 10);
    private static WeightedVertex a12 = new WeightedVertex("a12", 10);

    private static WeightedVertex a13 = new WeightedVertex("a13", 10);
    private static WeightedVertex a14 = new WeightedVertex("a14", 10);
    private static WeightedVertex a15 = new WeightedVertex("a15", 10);
    private static WeightedVertex a16 = new WeightedVertex("a16", 10);
    private static WeightedVertex a17 = new WeightedVertex("a17", 10);
    private static WeightedVertex a18 = new WeightedVertex("a18", 10);


    private static WeightedVertex a19 = new WeightedVertex("a19", 10);
    private static WeightedVertex a20 = new WeightedVertex("a20", 10);
    private static WeightedVertex a21 = new WeightedVertex("a21", 10);
    private static WeightedVertex a22 = new WeightedVertex("a22", 10);
    private static WeightedVertex a23 = new WeightedVertex("a23", 10);
    private static WeightedVertex a24 = new WeightedVertex("a24", 10);

    private static WeightedVertex a25 = new WeightedVertex("a25", 10);
    private static WeightedVertex a26 = new WeightedVertex("a26", 10);
    private static WeightedVertex a27 = new WeightedVertex("a27", 10);
    private static WeightedVertex a28 = new WeightedVertex("a28", 10);
    private static WeightedVertex a29 = new WeightedVertex("a29", 10);
    private static WeightedVertex a30 = new WeightedVertex("a30", 10);



    private static SimpleUndirectedGraph<WeightedVertex, WeightedVertexEdge> g1;

    /** Non Gu */
    public static GraphData twoLongHolesWith3PC(){
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
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
        g1.addEdge(d, l);


        GraphData data = new GraphData();
        data.graph = g1;

        return data;
    }

    public static GraphData threePC() {
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d);
        g1.addVertex(f);

        g1.addVertex(g);
        g1.addVertex(h);
        g1.addVertex(i);
        g1.addVertex(j);
        g1.addVertex(k);
        g1.addVertex(l);
        g1.addVertex(m);
        g1.addVertex(n);

        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        g1.addEdge(d, a);
        g1.addEdge(d, b);
        g1.addEdge(d, c);

        g1.addEdge(f, a);
        g1.addEdge(f, b);
        g1.addEdge(f, c);

        g1.addEdge(g, a);
        g1.addEdge(g, b);
        g1.addEdge(g, c);

        g1.addEdge(g, h);
        g1.addEdge(g, i);
        g1.addEdge(g, j);


        g1.addEdge(k, h);
        g1.addEdge(l, i);
        g1.addEdge(m, j);

        g1.addEdge(k, n);
        g1.addEdge(l, n);
        g1.addEdge(m, n);

        GraphData data = new GraphData();
        data.graph = g1;
        data.isGu = false;

        return data;
    }

    // Hole - CC - k2 - 3Clique
    public static GraphData mediumGraph(){
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);

        //g1.addVertex(o); g1.addVertex(p); g1.addVertex(q);
        //g1.addVertex(r); g1.addVertex(s); g1.addVertex(t);

        // Clique 2
        g1.addVertex(l); g1.addVertex(m); g1.addVertex(n);

        g1.addEdge(l, m);
        g1.addEdge(n, m);
        g1.addEdge(l, n);

        // Set Clique
        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        // Long hole
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

        // k2
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

        //g1.addEdge(t, l);
        //g1.addEdge(t, m);
        //g1.addEdge(t, n);

        /*
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
*/
        GraphData data = new GraphData();
        data.graph = g1;
        data.isGu = false;

        return data;
    }

    /** Gu graphs */
    public static GraphData twoLongHoles(){
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
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

        // Second hole
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

        GraphData data = new GraphData();
        data.graph = g1;
        data.optimalColor = 6;
        data.maxCliqueWeight = 70;

        return data;
    }

    public static GraphData threeLongHoles(){
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        //first hole
        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h);

        // second hole
        g1.addVertex(j); g1.addVertex(k);
        g1.addVertex(l); g1.addVertex(m);
        g1.addVertex(n);

        //third
        g1.addVertex(o); g1.addVertex(p); g1.addVertex(q);
        g1.addVertex(r); g1.addVertex(s); g1.addVertex(t);
        //g1.addVertex(u);

        // Set Clique
        g1.addEdge(a, b);
        g1.addEdge(a, c);
        g1.addEdge(c, b);

        // First hole
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


        // Second hole
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


        // Third hole
        g1.addEdge(o, p); g1.addEdge(p, q);
        g1.addEdge(q, r); g1.addEdge(r, s);
        g1.addEdge(s, t); g1.addEdge(t, o);

        g1.addEdge(o, a);
        g1.addEdge(o, b);
        g1.addEdge(o, c);

        g1.addEdge(p, a);
        g1.addEdge(p, b);
        g1.addEdge(p, c);

        g1.addEdge(q, a);
        g1.addEdge(q, b);
        g1.addEdge(q, c);

        g1.addEdge(r, a);
        g1.addEdge(r, b);
        g1.addEdge(r, c);

        g1.addEdge(s, a);
        g1.addEdge(s, b);
        g1.addEdge(s, c);

        g1.addEdge(t, a);
        g1.addEdge(t, b);
        g1.addEdge(t, c);

        GraphData data = new GraphData();
        data.graph = g1;
        data.optimalColor = 6;
        data.maxCliqueWeight = 75;

        return data;

    }

    public static GraphData twoCutset() {
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); //g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);
        g1.addVertex(l); g1.addVertex(m);
        g1.addVertex(n);

        g1.addVertex(o);
        g1.addVertex(p); g1.addVertex(q);
        g1.addVertex(r); g1.addVertex(s);
        g1.addVertex(t);

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

        g1.addEdge(o, c);

        g1.addEdge(p, q);
        g1.addEdge(q, r);
        g1.addEdge(r, s);
        g1.addEdge(s, t);
        g1.addEdge(t, p);

        g1.addEdge(p, o);
        g1.addEdge(q, o);
        g1.addEdge(r, o);
        g1.addEdge(s, o);
        g1.addEdge(t, o);

        GraphData data = new GraphData();
        data.graph = g1;
        data.optimalColor = 6;
        data.maxCliqueWeight = 70;

        return data;

    }

    // 23 vertices
    public static GraphData largeGraph(){
        g1 = new SimpleUndirectedGraph<>(WeightedVertexEdge.class);
        g1.addVertex(a); g1.addVertex(b); g1.addVertex(c);

        g1.addVertex(d); g1.addVertex(e);
        g1.addVertex(f); g1.addVertex(g);
        g1.addVertex(h); //g1.addVertex(i);
        g1.addVertex(j); g1.addVertex(k);
        g1.addVertex(l); g1.addVertex(m);
        g1.addVertex(n);

        g1.addVertex(o);
        g1.addVertex(p); g1.addVertex(q);
        g1.addVertex(r); g1.addVertex(s);
        g1.addVertex(t);

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

        g1.addEdge(o, c);

        g1.addEdge(p, q);
        g1.addEdge(q, r);
        g1.addEdge(r, s);
        g1.addEdge(s, t);
        g1.addEdge(t, p);

        g1.addEdge(p, o);
        g1.addEdge(q, o);
        g1.addEdge(r, o);
        g1.addEdge(s, o);
        g1.addEdge(t, o);


        g1.addVertex(u);
        g1.addVertex(v);
        g1.addVertex(w);
        g1.addVertex(x);

        g1.addEdge(u, o);
        g1.addEdge(v, o);
        g1.addEdge(u, v);

        g1.addEdge(w, u);
        g1.addEdge(w, v);
        g1.addEdge(x, u);
        g1.addEdge(x, v);


        GraphData data = new GraphData();
        data.graph = g1;
        data.optimalColor = 6;
        data.maxCliqueWeight = 120;

        return data;
    }

    // 46 vertices
    public static GraphData largerGraph(){
        GraphData data = largeGraph();
        data.graph.addVertex(a1);

        data.graph.addVertex(a2);
        data.graph.addVertex(a3);
        data.graph.addVertex(a4);
        data.graph.addVertex(a5);
        data.graph.addVertex(a6);

        data.graph.addVertex(a7);
        data.graph.addVertex(a8);
        data.graph.addVertex(a9);
        data.graph.addVertex(a10);
        data.graph.addVertex(a11);
        data.graph.addVertex(a12);
        data.graph.addVertex(a13);
        data.graph.addVertex(a14);
        data.graph.addVertex(a15);
        data.graph.addVertex(a16);
        data.graph.addVertex(a17);
        data.graph.addVertex(a18);

        // Add connection to last clique
        data.graph.addEdge(a1, v);

        // Add super long hole
        data.graph.addEdge(a2, a3);
        data.graph.addEdge(a3, a4);
        data.graph.addEdge(a4, a5);
        data.graph.addEdge(a5, a6);
        data.graph.addEdge(a6, a7);
        data.graph.addEdge(a7, a8);
        data.graph.addEdge(a8, a9);
        data.graph.addEdge(a9, a10);
        data.graph.addEdge(a10, a11);
        data.graph.addEdge(a11, a12);
        data.graph.addEdge(a12, a13);
        data.graph.addEdge(a13, a14);
        data.graph.addEdge(a14, a2);

        data.graph.addEdge(a1, a2);
        data.graph.addEdge(a1, a3);
        data.graph.addEdge(a1, a4);
        data.graph.addEdge(a1, a5);
        data.graph.addEdge(a1, a6);
        data.graph.addEdge(a1, a7);
        data.graph.addEdge(a1, a8);
        data.graph.addEdge(a1, a9);
        data.graph.addEdge(a1, a10);
        data.graph.addEdge(a1, a11);
        data.graph.addEdge(a1, a12);
        data.graph.addEdge(a1, a13);
        data.graph.addEdge(a1, a14);


        data.graph.addVertex(a19);
        data.graph.addVertex(a20);
        data.graph.addVertex(a21);
        data.graph.addVertex(a22);

        data.graph.addEdge(a1, a15);
        data.graph.addEdge(a1, a16);
        data.graph.addEdge(a1, a17);
        data.graph.addEdge(a1, a18);
        data.graph.addEdge(a1, a19);
        data.graph.addEdge(a1, a20);
        data.graph.addEdge(a1, a21);
        data.graph.addEdge(a1, a22);

        // Add 4 k2s

        // a15
        data.graph.addEdge(a15, a17);
        data.graph.addEdge(a15, a18);
        data.graph.addEdge(a15, a19);
        data.graph.addEdge(a15, a20);
        data.graph.addEdge(a15, a21);
        data.graph.addEdge(a15, a22);

        //a16
        data.graph.addEdge(a16, a17);
        data.graph.addEdge(a16, a18);
        data.graph.addEdge(a16, a19);
        data.graph.addEdge(a16, a20);
        data.graph.addEdge(a16, a21);
        data.graph.addEdge(a16, a22);

        // a17
        data.graph.addEdge(a17, a16);
        data.graph.addEdge(a17, a15);
        data.graph.addEdge(a17, a19);
        data.graph.addEdge(a17, a20);
        data.graph.addEdge(a17, a21);
        data.graph.addEdge(a17, a22);

        // a18
        data.graph.addEdge(a18, a16);
        data.graph.addEdge(a18, a15);
        data.graph.addEdge(a18, a19);
        data.graph.addEdge(a18, a20);
        data.graph.addEdge(a18, a21);
        data.graph.addEdge(a18, a22);

        // a19
        data.graph.addEdge(a19, a15);
        data.graph.addEdge(a19, a16);
        data.graph.addEdge(a19, a17);
        data.graph.addEdge(a19, a18);
        data.graph.addEdge(a19, a21);
        data.graph.addEdge(a19, a22);

        // a20
        data.graph.addEdge(a20, a15);
        data.graph.addEdge(a20, a16);
        data.graph.addEdge(a20, a17);
        data.graph.addEdge(a20, a18);
        data.graph.addEdge(a20, a21);
        data.graph.addEdge(a20, a22);

        // a21
        data.graph.addEdge(a21, a15);
        data.graph.addEdge(a21, a16);
        data.graph.addEdge(a21, a17);
        data.graph.addEdge(a21, a18);
        data.graph.addEdge(a21, a19);
        data.graph.addEdge(a21, a20);

        // a22
        data.graph.addEdge(a22, a15);
        data.graph.addEdge(a22, a16);
        data.graph.addEdge(a22, a17);
        data.graph.addEdge(a22, a18);
        data.graph.addEdge(a22, a19);
        data.graph.addEdge(a22, a20);

        return data;
    }
}
