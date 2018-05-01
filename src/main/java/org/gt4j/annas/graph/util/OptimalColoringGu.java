package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.DecompositionTreeInnerNode;
import org.gt4j.annas.graph.DecompositionTreeLeaf;
import org.gt4j.annas.graph.DecompositionTreeNodeInterface;
import org.gt4j.annas.graph.EdgeInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OptimalColoringGu<V,  E extends EdgeInterface<V>>
        implements ColouringInterface<V> {


    DecompositionTreeNodeInterface<V, E> root;
    OptimalColoringBasicGu<V, E> colorBasic;

    public OptimalColoringGu(DecompositionTreeNodeInterface<V, E> node){
        root = node;
        colorBasic = new OptimalColoringBasicGu<>();
    }

    /**
     * Handles the base case for a decomosition tree.
     * Collects all leaves into a set and colors each leaf independently
     *
     */
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

    /**
     * Recursively permutes the children of an inner node and merges the colors
     * from children into the current inner node
     *
     * @param node
     */
    private void colorDecompositionTree(
            DecompositionTreeInnerNode<V, E> node) {

        if (node.getLeaves().size() == 2){
            permuteChildren(node);
            mergeChildren(node);
            return;
        }
        colorDecompositionTree(node.getInnerChildren().get(0));
        permuteChildren(node);
        mergeChildren(node);
    }

    /**
     * Takes an inner node and swaps the coloring of it's children so that
     * both children agree on on a coloring of the cutset
     * @param node
     */
    private void permuteChildren(DecompositionTreeInnerNode<V, E> node) {
        Set<V> cutset = node.getCutset().getVertices();
        DecompositionTreeNodeInterface<V, E> child1 = null, child2 = null;

        child1 = node.getChildren().get(0);
        child2 = node.getChildren().get(1);

        for (V vertex : cutset){
            int leaf1Color = child1.getVertexColor(vertex);
            int leaf2Color = child2.getVertexColor(vertex);
            if (leaf2Color != leaf1Color){
                // swap all leaf2color for leaf1color;
                child1.swapColors(leaf1Color, leaf2Color);
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
        DecompositionTreeNodeInterface<V, E> child1, child2;
        child1 = node.getChildren().get(0);
        child2 = node.getChildren().get(1);

        for (V v : child1.getGraph().getVertices()){
            node.setVertexColor(v, child1.getVertexColor(v));
        }
        for (V v : child2.getGraph().getVertices()){
            node.setVertexColor(v, child2.getVertexColor(v));
        }
    }

    public int setOptimalColoring(){
        // Traverse tree, get coloring for each leaf
        // recursively permute the coloring from the bottom up.
        colorLeaves();
        if ( !root.isLeaf()) {
            colorDecompositionTree((DecompositionTreeInnerNode<V, E>) root);
        }
        HashSet<Integer> set = new HashSet<>();
        for (V v : root.getGraph().getVertices()){
            set.add(root.getVertexColor(v));
        }
        return set.size();
    }

    @Override
    public Set<Set<V>> call() throws Exception {
        setOptimalColoring();
        return null;
    }
}
