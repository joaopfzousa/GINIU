package edu.ufp.inf.lp2_aed2;

public class Edge {

    private Integer v;

    private Integer w;

    private Double weight;

    private Double seconds;

    public Edge(Integer v, Integer w) {
        this.v = v;
        this.w = w;
    }

    public Edge(Integer v, Integer w, Double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Integer v, Integer w, Double weight, Double seconds) {
        this.v = v;
        this.w = w;
        this.weight = weight;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSeconds() {
        return seconds;
    }

    public void setSeconds(Double seconds) {
        this.seconds = seconds;
    }

    public void tempoMedio()
    {

    }
}
