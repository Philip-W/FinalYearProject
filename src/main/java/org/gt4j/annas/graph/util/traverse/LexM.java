package org.gt4j.annas.graph.util.traverse;


import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.util.Utilities;

import java.util.*;

/** Provides an implementation of the LexM algorithm provided by Tarjan
 * for finding minimal orderings
 */
public class LexM<V, E extends EdgeInterface<V>>  {

    SimpleUndirectedGraph<V, E> graph;
    HashMap<V, Double> lMap; // Label map
    HashMap<Integer, V> alphaMap; // ordering map maps integer ordering to the vertex
    HashMap<V, Integer> inverseAlpha;
    HashMap<V, Boolean> isReached;

    MultiHashMap<Double, V> reach;
    List<E> fillInEdges;

    SimpleUndirectedGraph<V, E> copy;


    public LexM(SimpleUndirectedGraph<V, E> graph){
        this.graph = graph;
        copy = (SimpleUndirectedGraph<V, E>) Utilities.getCopy((SimpleUndirectedGraph<WeightedVertex, WeightedVertexEdge>) graph);
        lMap = new HashMap<>();
        alphaMap = new HashMap<>();
        inverseAlpha = new HashMap<>();
        reach = new MultiHashMap<>();
        fillInEdges = new ArrayList<>();
        isReached = new HashMap<>();
        setup();
    }

    private void setup(){
        for(V v : graph.getVertices()){
            lMap.put(v, 1.0);
            inverseAlpha.put(v, 0);
            isReached.put(v, false);
        }
    }

    public ArrayList<V> getOrder(){
        runLexM();
        ArrayList<V> order = new ArrayList<>();
        for (int i = 0; i < graph.getOrder(); i++) {
            order.add(null);
        }

        for (V v : graph.getVertices()){
            int ordering = inverseAlpha.get(v);
            order.set(ordering == 0 ? 0 : ordering -1 , v);
        }

        return order;
    }


    private V getUnnumberedVertex(int k){
        V vertex = null;
        for (V v : copy.getVertices()){
            if (inverseAlpha.get(v) == 0 && lMap.get(v) == k){
                vertex = v;
            }
        }
        return vertex;
    }

    private void runLexM(){
        int k = 1;
        V currentVertex;
        for (int i = copy.getVertices().size(); i > 1; i--){
            currentVertex = getUnnumberedVertex(k);
            if (currentVertex == null){ return; }
            //System.out.println(reach);
            // mark currentVertex reached.
            isReached.put(currentVertex, true);

            alphaMap.put(i , currentVertex);
            inverseAlpha.put(currentVertex, i);
            lMap.remove(currentVertex);

            for (int j = 1; j <= k; j++){
                if (reach.getCollection(j) != null)
                reach.getCollection(j).clear();
            }

            // mark all unnumbered vertices unreached
            for (V v : inverseAlpha.keySet()){
                if (inverseAlpha.get(v) == 0){
                    isReached.put(v, false);
                }
            }


            for (E edge : copy.getEdges(currentVertex)){
                V w = edge.getOtherEndpoint(currentVertex);
                if (inverseAlpha.get(w) != 0){ continue; }
                reach.put(lMap.get(w), w);

                // mark w reached
                isReached.put(w, true);
                lMap.put(w, lMap.get(w) + 0.5);
                // mark vw in G* alpha
                //fillInEdges.add(new (currentVertex, w));
                copy.addEdge(w, currentVertex);
            }
            /*****************************************************/

            for (int j = 1; j <= k; j++){
                ArrayList<V> reachList = (ArrayList<V>) reach.get(j);
                if (reachList == null) continue;
                while(!reachList.isEmpty()){
                    V w = reachList.remove(reachList.size() - 1);
                    for (E edge : copy.getEdges(w)){
                        V z = edge.getOtherEndpoint(w);
                        if (isReached.get(z)) { continue; }
                        isReached.put(z, true);
                        if (lMap.get(z) > j){
                            reach.put(lMap.get(z), z);
                            lMap.put(z, lMap.get(z) + 0.5);
                            // add {v, z} to fill in
                            copy.addEdge(currentVertex, z);
                        }
                        else {
                            reach.put(j, z);
                        }
                    }
                }
            }

            // Sort unnumbered
            //System.out.println(lMap);
            ArrayList<V> unnumbered = new ArrayList<>();
            for (V v : copy.getVertices()){
                if (inverseAlpha.get(v) == 0){
                    unnumbered.add(v);
                }
            }

            if (unnumbered.isEmpty()) return;

            Collections.sort(unnumbered,(a, b)
                    -> lMap.get(a) < lMap.get(b) ? -1
                    : lMap.get(a) == lMap.get(b) ? 0 : 1);

            //System.out.println(unnumbered);
            //System.out.println(reach);
            //System.out.println("----------------------");
            HashSet<Double> distinctLabels = new HashSet<>();
            for (V v : unnumbered){
                distinctLabels.add(lMap.get(v));
            }

            k = distinctLabels.size();
            Double label = 1.0;
            //System.out.println(lMap);
            double current = lMap.get(unnumbered.get(0));
            for (int x = 0; x < unnumbered.size(); x++){
                V vertex = unnumbered.get(x);
                //System.out.println(vertex + " : " + lMap.get(vertex));
                if (lMap.get(vertex) == current){
                    lMap.put(vertex, label);
                }
                else{
                    label += 1;
                    current = lMap.get(unnumbered.get(x));
                    lMap.put(vertex, label);
                }
            }

            //System.out.println(lMap);
            //System.out.println("---------------------------------------");
            //System.out.println(k);
        }

    }

}
