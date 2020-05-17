package edu.ufp.inf.lp2_aed2;

public class Local extends Node{

    private String description;

    private Point point;

    private Integer floor;

    public Local(String description, Point point, Integer floor) {
        this.description = description;
        this.point = point;
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
