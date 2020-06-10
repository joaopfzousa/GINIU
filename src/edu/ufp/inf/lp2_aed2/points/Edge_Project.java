package edu.ufp.inf.lp2_aed2.points;

import edu.princeton.cs.algs4.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Edge_Project extends DirectedEdge implements Serializable {

    private double temp;

    private Boolean direction;

    public Edge_Project(int v, int w, double weight, double temp) {
        super(v, w, weight);
        this.temp = temp;
        this.direction = null;
    }

    public Edge_Project(int v, int w, double weight, double temp, Boolean direction) {
        super(v, w, weight);
        this.temp = temp;
        this.direction = direction;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

    public Double minutes(){
        return temp / 60;
    }

    public Double seconds(){
        return temp % 60;
    }

    @Override
    public String toString() {
        BigDecimal metros = new BigDecimal(weight()).setScale(3, RoundingMode.HALF_EVEN);
        BigDecimal minutos = new BigDecimal(minutes()).setScale(3, RoundingMode.HALF_EVEN);
        return "Edge de " + getV()+ " ate " + getW() + " tem distancia de " + metros + " demora " + minutos + " minutos ";
    }
}
