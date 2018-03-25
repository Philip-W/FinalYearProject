package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.EdgeInterface;

import java.util.Collection;

public class OptimalColoringBasicGu<V,  E extends EdgeInterface<V>> {

    public OptimalColoringBasicGu(DecompositionTreeLeaf<V, E> leaf){

    }

    private void colorLongHole(DecompositionTreeLeaf<V, E> leaf){
        int color = 1;

        for (Collection<V> component : leaf.getAntiComponents()){
            if (component.size() == 1){
                leaf.setVertexColor((V) component.toArray()[0], color);
                color++;
            }
            else{
                leaf.setVertexColor((V) component.toArray()[0], color);
                leaf.setVertexColor((V) component.toArray()[1], color);
                color++;
            }
        }
    }


    private void colorK2(DecompositionTreeLeaf<V, E> leaf){

    }

    /**
     * Computes the coloring of a given leaf, returning the number of colors
     * required to color the leaf graph.
     *
     * @param leaf
     * @return
     */
    public int computeColoring(DecompositionTreeLeaf<V, E> leaf){


        return -1;
    }
}
