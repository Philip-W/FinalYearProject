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
    private static WeightedVertex q = new WeightedVertex("q", 20);
    private static WeightedVertex r = new WeightedVertex("r", 10);
    private static WeightedVertex s = new WeightedVertex("s", 10);
    private static WeightedVertex t = new WeightedVertex("t", 10);
    private static WeightedVertex u = new WeightedVertex("u", 10);
    private static WeightedVertex v = new WeightedVertex("v", 10);
    private static WeightedVertex w = new WeightedVertex("w", 10);
    private static WeightedVertex x = new WeightedVertex("x", 10);


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

        return data;

    }

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

        return data;
    }

}
