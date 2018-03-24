package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.classifier.IsGu;

import java.util.ArrayList;

public class GuMaxWeightClique<V extends WeightedVertex,
        E extends EdgeInterface<V>> {

    /**
     * Sets the max weight clique of the given leaf (storing it in the leaf)
     * and returns the sum of the weighted clique
     * @param leaf
     * @return
     */
    public ArrayList<V> maxCliqueInLeaf(DecompositionTreeLeaf<V, E> leaf){
            if (!leaf.getBu()) return null ; // Should throw unClassified graph exception
            if (leaf.getBuType() == IsGu.Type.K2){
                maxCliqueInK2();
            }

        return null;
    }

    public ArrayList<V> maxCliqueInK2(DecompositionTreeLeaf<V, E> leaf){


    }

    public ArrayList<V> getMaxClique(DecompositionTreeNodeInterface<V, E> root){
        ArrayList<V> maxClique = null;
        if (root.isLeaf()){
            maxClique = maxCliqueInLeaf((DecompositionTreeLeaf<V, E>) root);
        }
        DecompositionTreeInnerNode<V, E> temp =
                (DecompositionTreeInnerNode<V, E>) root;

        ArrayList<DecompositionTreeLeaf> leaves = new ArrayList<>();
        leaves.addAll(temp.getLeaves());

        while (temp.getInnerChildren().size() != 0){
            temp = temp.getInnerChildren().get(0);
            leaves.addAll(temp.getLeaves());
        }


        for (DecompositionTreeLeaf leaf : leaves){
            maxCliqueInLeaf(leaf);
        }

        return maxClique;
    }


    ArrayList<>
}
