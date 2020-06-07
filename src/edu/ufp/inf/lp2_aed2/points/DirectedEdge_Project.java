package edu.ufp.inf.lp2_aed2.points;

import edu.princeton.cs.algs4.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DirectedEdge_Project extends DirectedEdge implements Serializable {

    private double tempo;

    private Boolean sentido;

    public DirectedEdge_Project(int v, int w, double weight, double tempo) {
        super(v, w, weight);
        this.tempo = tempo;
        this.sentido = false;
    }

    public Boolean getSentido() {
        return sentido;
    }

    public void setSentido(Boolean sentido) {
        this.sentido = sentido;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public Double minutos(){
        return tempo/60;
    }
    public Double segundos(){
        return tempo%60;
    }

    @Override
    public String toString() {
        BigDecimal bd = new BigDecimal(weight()).setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal bd1 = new BigDecimal(minutos()).setScale(3, RoundingMode.HALF_EVEN);
        return "DirectedEdge_Project de " + getV()+ " ate " + getW() +" tem distancia de "+bd +" demora " + bd1+ " minutos ";
    }
}
