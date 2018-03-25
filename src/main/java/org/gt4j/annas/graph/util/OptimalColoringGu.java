package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeInnerNode;
import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;

import java.util.ArrayList;
import java.util.Set;

public class OptimalColoringGu<V,  E extends EdgeInterface<V>>
        implements ColouringInterface<V> {


    DecompositionTreeNodeInterface<V, E> root;
    OptimalColoringBasicGu<V, E> colorBasic;

    public OptimalColoringGu(DecompositionTreeNodeInterface<V, E> node){
        root = node;
        colorBasic = new OptimalColoringBasicGu<>();
    }


    private void colorLeaves(){
        if (root.isLeaf()){
            colorBasic.computeColoring((DecompositionTreeLeaf<V, E>) root);
            return;
        }
        DecompositionTreeInnerNode<V, E> temp =
                (DecompositionTreeInnerNode<V, E>) root;

        ArrayList<DecompositionTreeLeaf> leaves = new ArrayList<>();
        leaves.addAll(temp.getLeaves());

        while (temp.getInnerChildren().size() != 0){
            temp = temp.getInnerChildren().get(0);
            leaves.addAll(temp.getLeaves());
        }
        
        // Establish a coloring of each leaf
        for (DecompositionTreeLeaf leaf : leaves){
            colorBasic.computeColoring(leaf);
        }

    }

    private void permuteLeafColors() {

    }

    public void setOptimalColoring(){
        // Traverse tree, get coloring for each leaf
        // recursively permute the coloring from the bottom up.

        colorLeaves();
        permuteLeafColors();
    }


    @Override
    public Set<Set<V>> call() throws Exception {
        return null;
    }
}
