package org.gt4j.annas.graph;

public class WeightedVertexEdge implements EdgeInterface<WeightedVertex> {
    private WeightedVertex head;
    private WeightedVertex tail;


    public WeightedVertexEdge(){ super(); }


    @Override
    public WeightedVertex getHead() {
        return this.head;
    }

    @Override
    public WeightedVertex getTail() {
        return this.tail;
    }

    @Override
    public void setHead(WeightedVertex vertex) {
        this.head = vertex;
    }

    @Override
    public void setTail(WeightedVertex vertex) {
        this.tail = vertex;
    }

    @Override
    public boolean isIncident(WeightedVertex vertex) {
        return this.head.equals(vertex) || this.tail.equals(vertex);
    }

    @Override
    public WeightedVertex getOtherEndpoint(WeightedVertex vertex) {
        if (this.head.equals(vertex)){
            return this.tail;
        }
        else if (this.tail.equals(vertex)){
            return this.head;
        }
        else {
            return null;
        }
    }
}
