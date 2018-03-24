package org.gt4j.annas.graph.classifier;

import org.gt4j.annas.graph.DecompositionTreeInnerNode;
import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;

public class IsGu<V, E extends EdgeInterface<V>> {
    public enum Type {HOLE, K2, FALSE, CLIQUE};

    public boolean classifyLeaf(DecompositionTreeLeaf<V, E> leaf){


        return false;
    }


    public boolean classifyTree(DecompositionTreeNodeInterface<V, E> root){
        if (root == null) { return false; }
        if (root.isLeaf()){ return classifyLeaf((DecompositionTreeLeaf) root); }

        DecompositionTreeInnerNode<V, E> temp =
                (DecompositionTreeInnerNode<V, E>) root;

        while (!temp.isLeaf()){
            for (DecompositionTreeLeaf leaf : temp.getLeaves()){
                if (!classifyLeaf(leaf)){ return false; }
            }

            // In Tarjans algorithm there will always be only 1 non leaf component
            // and 1 leaf
            temp = temp.getNonLeafChildren().get(0);
        }


        return false;
    }

}
