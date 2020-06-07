package edu.ufp.inf.lp2_aed2.points;

import java.io.Serializable;

public class Point3D extends Point implements Comparable<Point3D>, Serializable {

    private static Integer value = 0;

    private Integer id;

    private Integer z;

    private String description;

    private Boolean indoor;

    public Point3D(double x, double y, Integer z, Integer id, String description, Boolean indoor) {
        super(x, y);
        this.id = id;
        this.z = z;
        this.description = description;
        this.indoor = indoor;
    }
    public Point3D(double x, double y, Integer z, String description, Boolean indoor) {
        super(x, y);
        this.id = value++;
        this.z = z;
        this.description = description;
        this.indoor = indoor;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    public static Integer getValue() {
        return value;
    }

    public static void setValue(Integer value) {
        Point3D.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double distZ(Point3D P) {
        double dz = this.z - P.getZ();
        return dz;
    }

    /**
     * Distancia entre dois pontos, peso das arestas
     * @param p
     * @return
     */
    public Double distPontos(Point3D p) {
        return Math.abs(Math.sqrt(p.distX(this) * p.distX(this) + p.distY(this) * p.distY(this) + p.distZ(this)*p.distZ(this)));
    }

    @Override
    public String toString() {
        return "Id - " + id + " coordenadas ( " + getX() +", "+ getY()+", " + getZ()+" )";
    }

    @Override
    public int compareTo(Point3D o) {
        if (z == o.getZ() && o.getX() == this.getX() && o.getY() == this.getY())
            return 0;
        return 1;
    }
}
