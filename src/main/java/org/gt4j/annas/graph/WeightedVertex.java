package org.gt4j.annas.graph;

public class WeightedVertex {
    private Object identifier;
    private int weight;

    public WeightedVertex(Object identifier, int weight){
        this.weight = weight;
        this.identifier = identifier;
    }

    public String toString(){
        return "[" + identifier.toString() + " : " + weight + "]";
    }

    public int getWeight() {
        return weight;
    }

    public Object getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
