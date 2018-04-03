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

    private void colorDecompositionTree(
            DecompositionTreeInnerNode<V, E> node) {

        //DecompositionTreeInnerNode<V, E> next;
        if (node.getLeaves().size() == 2){
            permuteChildren(node);
            mergeChildren(node);
            return;
        }
        colorDecompositionTree(node.getInnerChildren().get(0));
    }

    /**
     * Takes an inner node and swaps the coloring of it's children so that
     * both children agree on on a coloring of the cutset
     * @param node
     */
    private void permuteChildren(DecompositionTreeInnerNode<V, E> node) {
        Set<V> cutset = node.getCutset().getVertices();
        DecompositionTreeLeaf<V, E> leaf1 = null, leaf2 = null;

        for (V vertex : cutset){
            int leaf1Color = leaf1.getVertexColor(vertex);
            int leaf2Color = leaf2.getVertexColor(vertex);
            if (leaf2Color != leaf1Color){
                // swap all leaf2color for leaf1color;
                leaf1.swapColors(leaf1Color, leaf2Color);
            }
        }



    }

    /**
     * Sets the coloring of an inner node based on the coloring of it's children,
     * For this to work, both children must agree on a coloring permutation of
     * the cutset they both share.
     *
     * @param node
     * @return
     */
    private void mergeChildren(
            DecompositionTreeInnerNode<V,E> node) {
    }

    public void setOptimalColoring(){
        // Traverse tree, get coloring for each leaf
        // recursively permute the coloring from the bottom up.

        colorLeaves();
        if ( root.isLeaf()){ return; }

        colorDecompositionTree((DecompositionTreeInnerNode<V, E>) root);

    }


    @Override
    public Set<Set<V>> call() throws Exception {
        return null;
    }
}
