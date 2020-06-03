package edu.ufp.inf.lp2_aed2.points;

public class Local extends Node {

    private Point ponto;

    private String descricao;

    private Boolean indoorOutdoor;

    public Local(Point ponto, String descricao, Boolean indoorOutdoor) {
        this.ponto = ponto;
        this.descricao = descricao;
        this.indoorOutdoor=indoorOutdoor;
    }

    public void setPonto(Point ponto) {
        this.ponto = ponto;
    }

    public Boolean getIndoorOutdoor() {
        return indoorOutdoor;
    }

    public void setIndoorOutdoor(Boolean indoorOutdoor) {
        this.indoorOutdoor = indoorOutdoor;
    }

    public Point getPonto() {
        return ponto;
    }

    public void setPoint(Point ponto) {
        this.ponto = ponto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "PontosPassagem{" +
                "point=" + ponto +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Local novo = new Local(new Point(2.33,2.21,232.1),"Casa de banho",false);
        System.out.println(novo);
    }
}
