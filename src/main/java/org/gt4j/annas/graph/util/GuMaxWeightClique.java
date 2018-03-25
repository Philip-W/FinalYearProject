package org.gt4j.annas.graph.util;

import org.gt4j.annas.graph.*;
import org.gt4j.annas.graph.classifier.IsGu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class GuMaxWeightClique<V extends WeightedVertex,
        E extends EdgeInterface<V>> implements  MaximumCliqueInterface<V>{

    /**
     * Sets the max weight clique of the given leaf (storing it in the leaf)
     * and returns the vertices of the weighted clique
     * @param leaf
     * @return
     */
    public ArrayList<V> maxCliqueInLeaf(DecompositionTreeLeaf<V, E> leaf){
        ArrayList<V> clique = null;
        if (!leaf.getBu()) return null ; // Should throw unClassified graph exception
        if (leaf.getBuType() == IsGu.Type.K2){
            clique = maxCliqueInK2(leaf);
        }
        else if (leaf.getBuType() == IsGu.Type.HOLE){
            clique = maxCliqueInLongHole(leaf);
        }
        leaf.setMaxWeightClique(clique);
        int size = 0;
        for (V v : clique){ size += v.getWeight(); }
        leaf.setCliqueWeight(size);

        return clique;
    }


    public ArrayList<V> maxCliqueInLongHole(DecompositionTreeLeaf<V, E> leaf){
        ArrayList<V> clique = new ArrayList<>();

        for (Collection<V> components : leaf.getAntiComponents()){
            if (components.size() == 1){
                clique.addAll(components);
            }

            // Found the component with the long hole
            else {
                int currentHighest = 0;
                V highPairOne = null;
                V highPairTwo = null;
                for (V v : components) {
                    E[] edges = (E[]) leaf.getLeafGraph().getEdges(v).toArray();
                    V first = edges[0].getOtherEndpoint(v);
                    V second = edges[1].getOtherEndpoint(v);
                    V highest = first.getWeight() > second.getWeight() ?
                            first : second;

                    if (v.getWeight() + highest.getWeight() > currentHighest) {
                        highPairOne = v;
                        highPairTwo = highest;
                        currentHighest = v.getWeight() + highest.getWeight();
                    }
                }
                clique.add(highPairOne);
                clique.add(highPairTwo);
            }
        }
        return clique;
    }

    /**
     * Given a leaf of the form:
     *      * All non-trivial anticomponents of G are isomorphic to the complement of
     *      K_2.
     *
     * This method returns a list of vertices that make up a maximum weight clique
     * @param leaf
     * @return
     */
    public ArrayList<V> maxCliqueInK2(DecompositionTreeLeaf<V, E> leaf){
        ArrayList<V> clique = new ArrayList<>();

        for (Collection<V> component : leaf.getAntiComponents()){
            if (component.size() == 1){ clique.addAll(component); }
            else {
                V[] comp = (V[]) component.toArray();
                V max = comp[0].getWeight() > comp[1].getWeight() ?
                        comp[0] : comp[1];
                clique.add(max);
            }
        }
        return clique;
    }

    private ArrayList<V> getMaxClique(DecompositionTreeNodeInterface<V, E> root){
        ArrayList<V> maxClique = null;
        if (root.isLeaf()){
            maxClique = maxCliqueInLeaf((DecompositionTreeLeaf<V, E>) root);
            return maxClique;
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

        DecompositionTreeLeaf<V, E> max = leaves.get(0);
        for (DecompositionTreeLeaf leaf : leaves){
            if (leaf.getCliqueWeight() > max.getCliqueWeight()){
                max = leaf;
            }
        }
        return max.getMaxWeightClique();
    }

    @Override
    public Set<V> call() throws Exception {
        return null;
    }
}
