package org.gt4j.annas.graph.util;


import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.util.traverse.LexBFS;
import org.gt4j.annas.util.SetManipulations;
import sun.security.provider.certpath.Vertex;

import java.util.*;

/**
 * An implementation of a decomposition algorithm through the use of
 * clique cutsets, as presented by Robert Tarjan in:
 * Decomposition by Clique Separators. ScienceDirect,
 * Discrete Mathematics Volume 55, Issue 2 (1985)
 *
 *
 * @author Philip Woods
 *
 * @param <V>
 *            Vertex type
 * @param <E>
 *            Edge type
 *
 * TODO:
 * * Check time complexity of fill in, thorough test
 * * Consider reducing length of fill in method
 * * Copy input graph
 */
public class DecomposeByCliqueCutset<V, E extends EdgeInterface<V>> {

    SimpleUndirectedGraph<V, E> graph;
    DecompositionTreeNodeInterface<V, E> treeRoot;

    protected MultiHashMap<Vertex, Vertex> cvMap;
    private HashMap<V, Integer> orderingMap;
    private List<V> minimalOrder;


    public DecomposeByCliqueCutset(final SimpleUndirectedGraph<V, E> inputGraph){
        this.graph = inputGraph;
        cvMap = new MultiHashMap<>();
        orderingMap = new HashMap<>();
    }

    /**
     * Here a Lexicographic breadth first search is used to obtain
     * a minimal ordering
     *
     * @return List
     *          Contains a LexBFS ordering
     */
    private List<V> getMinimalOrdering(){
        LexBFS<V> lexBFS = new LexBFS<>(graph);
        return lexBFS.getOrder();
    }

    /**
     *
     * @param ordering
     * @return GraphInterface
     *          Copy of the input graph with additional fill in edges
     */
    GraphInterface<V, E> getFillInSet(List<V> ordering){
        SimpleUndirectedGraph<V, E> fillInGraph = Utilities.getCopy(graph);

        //Map each vertex to it's ordering value allows fast (O(1)) association
        for (int i = 0; i < ordering.size(); i++){
            orderingMap.put(ordering.get(i), i + 1);
        }

        for (V vertex : ordering){
            // Set to highest ordered vertex, later modified to find the lowest
            // monotonely adjacent vertex.
            V minVertex = ordering.get(ordering.size() -1 );
            Set<E> edges =  fillInGraph.getEdges(vertex);

            // find the vertex m(v) = u with the minimum ordering such that an edge
            // v -> u exists
            for (E edge : edges){
                if (orderingMap.get(edge.getOtherEndpoint(vertex)) <
                        orderingMap.get(vertex)){ continue; }
                if (minVertex == null){
                    minVertex = edge.getOtherEndpoint(vertex);
                    continue;
                }
                else {
                    if (orderingMap.get(minVertex) > orderingMap.get(edge.getOtherEndpoint(vertex))) {
                        minVertex = edge.getOtherEndpoint(vertex);
                    }
                }
            }

            // Add edges from all neighbours of vertex to the minVertex
            for (E edge : edges){
                // The algorithm only connects vertices of higher ordering
                if (orderingMap.get(edge.getOtherEndpoint(vertex)) <
                        orderingMap.get(vertex)){ continue; }
                if (!edge.getOtherEndpoint(vertex).equals(minVertex)){
                    fillInGraph.addEdge(minVertex, edge.getOtherEndpoint(vertex));
                }
            }
        }
        return fillInGraph;
    }

    /**
     * Populates a multihash map with the sets c(v) defined as follows:
     * C(v) = {w| ordering(w) > ordering(v) & {v, w}  belongs to the fill in graph}
     *
     * @param g
     *
     */
    private void populateCv(SimpleUndirectedGraph<V, E> g){
        for (V vertex : g.getVertices()){
            for (E edge : g.getEdges(vertex)){
                if (orderingMap.get(edge.getOtherEndpoint(vertex)) >
                        orderingMap.get(vertex)){
                    cvMap.put(vertex, edge.getOtherEndpoint(vertex));
                }
            }
        }
    }

    /**
     *
     * @return DecompositionTreeNodeInterface
     *          This method will return the root of the tree after construction
     */
    private DecompositionTreeNodeInterface runDecomposition(){
        //Get Ordering
        if (minimalOrder == null){ minimalOrder = getMinimalOrdering(); }

        // Generate fill in graph
        SimpleUndirectedGraph fillInGraph = (SimpleUndirectedGraph) getFillInSet(minimalOrder);

        // Compute the sets C(v) for each vertex
        populateCv(fillInGraph);

        // Run the decomposition steps, returning the tree root.
        treeRoot = decompose(graph, minimalOrder);

        return treeRoot;
    }

    public void setOrder(List<V> order){ minimalOrder = order; }

    /**
     *
     * @param inputGraph
     * @param ordering
     * @return DecompositionTreeNodeInterface
     *          Recursive calls will be made each returning a new layer of the
     *          tree, ultimately returning the root.
     */
    private DecompositionTreeNodeInterface decompose(SimpleUndirectedGraph<V, E> inputGraph, List<V> ordering){
        Set<V> vertices  =  inputGraph.getVertices();
        List<V> bTemp;
        DecompositionTreeInnerNode<V, E> node;

        for (V currentVertex: ordering){
            ArrayList<V> neighbours = (ArrayList<V>) cvMap.get(currentVertex);

            if (neighbours == null){continue;}

            if(Utilities.isClique(inputGraph, neighbours)){
                List<V> aTemp = SetManipulations.
                        removeAll(vertices,neighbours);
                List<V> setA = null;

                SimpleUndirectedGraph<V, E> aTempGraph = InducedSubgraph.inducedSubgraphOf(
                        inputGraph, aTemp);

                Collection<Collection<V>> components = Utilities.getConnectedComponents(aTempGraph);
                for (Collection g : components){
                    if (g.contains(currentVertex)){
                        setA = new ArrayList<>(g);
                        break;
                    }
                }

               bTemp = SetManipulations.union(neighbours, setA);
               List<V> setB = SetManipulations.removeAll(vertices, bTemp);

                if (!setB.isEmpty()){

                    List<V> gPrimeSet = SetManipulations.union(setA, neighbours);
                    SimpleUndirectedGraph gPrime = InducedSubgraph.inducedSubgraphOf(
                            inputGraph, gPrimeSet);

                    List<V> gDoublePrimeSet = SetManipulations.union(setB, neighbours);
                    SimpleUndirectedGraph gDoublePrime = InducedSubgraph.
                            inducedSubgraphOf(inputGraph, gDoublePrimeSet);

                    List<V> updatedOrdering = SetManipulations.removeAll(ordering, setA);

                    SimpleUndirectedGraph<V, E> cutsetGraph =
                            InducedSubgraph.inducedSubgraphOf(inputGraph, neighbours);
                    node = new DecompositionTreeInnerNode(cutsetGraph);

                    node.addLeaf(new DecompositionTreeLeaf(gPrime, cutsetGraph));
                    DecompositionTreeNodeInterface next = decompose(gDoublePrime, updatedOrdering);
                    if (next.isLeaf()){ node.addLeaf( (DecompositionTreeLeaf) next); }
                    else { node.addChild(next); }
                    return node;
                }
            }
        }

        // The final leaf, since there could only be 1 leaf in the tree no cutset
        // is passed
        return new DecompositionTreeLeaf(inputGraph, null);
    }


    public DecompositionTreeNodeInterface getDecomposition() {
        treeRoot = runDecomposition();
        return treeRoot;
    }
}
