package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;

import java.util.Set;

public class MaximumWeightClique<V extends  WeightedVertex, E extends EdgeInterface<V>>
        implements MaximumCliqueInterface<V> {

    DecompositionTreeNode<V, E> treeRoot;
    Set<V> maxClique;
    int maxCliqueWeight = 0;

    public MaximumWeightClique(DecompositionTreeNode<V, E> root){
        treeRoot = root;
    }

    @Override
    public Set<V> call() throws Exception {
        return null;
    }

    private Set<V> getMaxWeightFromHole(DecompositionTreeLeaf<V, E> leaf){
        leaf.getCutset();
        return null;
    }

    private Set<V> getMaxWeightFromK2(DecompositionTreeLeaf<V, E> leaf){
        return null;
    }

    private int getSetWeight(Set<V> clique){
        return 0;
    }

    private boolean evaluateClique(DecompositionTreeLeaf<V, E> leaf) throws Exception{
        SimpleUndirectedGraph<V, E> leafGraph =
                (SimpleUndirectedGraph<V, E>) leaf.getGraph();
        Set<V> tempClique;
        try {
            switch (leaf.getBuType()) {
                case K2:
                    tempClique = getMaxWeightFromK2(leaf);
                    break;
                case HOLE:
                    tempClique = getMaxWeightFromHole(leaf);
                    break;
                case FALSE:
                    throw new Exception("Decomposition tree not in Class G_U");
                default:
                    throw new Exception("Decomposition tree not classified");
            }
        }
        catch (NullPointerException e){
            throw new Exception("Decomposition tree not classified");
        }

        int tempCliqueWeight = getSetWeight(tempClique);
        if (tempCliqueWeight > maxCliqueWeight){
            maxCliqueWeight = tempCliqueWeight;
            maxClique = tempClique;
            return true;
        }
        return  false;
    }

    private Set<V> getMaxWeightClique() throws Exception {
        DecompositionTreeNode<V, E> currentNode = treeRoot;
        DecompositionTreeLeaf<V, E> leaf;

        while (!currentNode.isLeaf()) {
            leaf = currentNode.getLeaf();
            evaluateClique(leaf);
            currentNode = currentNode.getChild();
        }

        evaluateClique((DecompositionTreeLeaf<V, E>) currentNode);

        return null;
    }
}
