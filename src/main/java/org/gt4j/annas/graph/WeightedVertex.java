package org.gt4j.annas.graph;

public class WeightedVertex {
    private int weight;

    private Object identifier;

    public WeightedVertex(Object identifier, int weight){
        this.identifier = identifier;
        this.weight  = weight;
    }

    public Object getIdentifier() {
        return identifier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }
}
