package org.gt4j.annas.graph.util.traverse;


import org.gt4j.annas.graph.EdgeInterface;
import org.gt4j.annas.graph.MultiHashMap;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
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

    MultiHashMap<Integer, V> reach;
    List<E> fillInEdges;


    public LexM(SimpleUndirectedGraph<V, E> graph){
        this.graph = graph;
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
            inverseAlpha.put(v, 1);
            isReached.put(v, false);
        }
    }

    public ArrayList<V> getOrder(){
        runLexM();
        ArrayList<V> order = new ArrayList<>();
        for (int i = 0; i < graph.getVertices().size(); i++){
            order.add(alphaMap.get(i + 1));
        }
        return order;
    }

    private void runLexM(){
        int k = 1;
        V currentVertex;
        for (int i = graph.getVertices().size(); i > 1; i--){
            currentVertex = null;
            // Get unnumbered vertex
            for (V v : graph.getVertices()){
                if (inverseAlpha.get(v) == 0 && lMap.get(v) == k){
                    currentVertex = v;
                    break;
                }
            }

            if (currentVertex == null){ return; }

            // mark currentVertex reached.
            alphaMap.put(i , currentVertex);
            inverseAlpha.put(currentVertex, i);
            for (int j = 1; j < k; j++){
                reach.remove(j);
                //reach.put(j);
            }

            // mark all unnumbered vertices unreached
            for (E edge : graph.getEdges(currentVertex)){
                V w = edge.getOtherEndpoint(currentVertex);
                if (inverseAlpha.get(w) != 0){ continue; }
                reach.put(lMap.get(w), w);

                // mark w reached
                isReached.put(w, true);
                lMap.put(w, lMap.get(w) + 0.5);
                // mark vw in G* alpha
                //fillInEdges.add(new (currentVertex, w));
            }

            for (int j = 1; j < k; j++){
                ArrayList<V> reachList = (ArrayList<V>) reach.get(j);
                while(!reachList.isEmpty()){
                    V w = reachList.remove(reachList.size() - 1);
                    for (E edge : graph.getEdges(w)){
                        V z = edge.getOtherEndpoint(w);
                        if (isReached.get(z)) { continue; }
                        isReached.put(z, true);
                        if (lMap.get(z) > j){
                            reach.put(lMap.get(z), z);
                            lMap.put(z, lMap.get(z) + 0.5);
                            // add {v, z} to fill in
                        }
                        else {
                            reach.put(j, z);
                        }
                    }
                }
            }
            // Sort unnumbered
            ArrayList<V> unnumbered = new ArrayList<>();
            for (V v : graph.getVertices()){
                if (inverseAlpha.get(v) == 0){
                    unnumbered.add(v);
                }
            }

            Collections.sort(unnumbered,(a, b)
                    -> lMap.get(a) < lMap.get(b) ? -1
                    : lMap.get(a) == lMap.get(b) ? 0 : 1);
            k = unnumbered.size();
            for (int x = 1; x <= k; x++){
                lMap.put(unnumbered.get(x), x + 0.0);
            }
        }

    }

}
