package edu.ufp.inf.lp2_aed2.points;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;

    private double y;

    public Point(double x,double y){ //a e b
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point (){}

    public double getX(){
      return x;
    }
    public double getY(){
      return y;
    }

    //Um ponto chama esta funçao com outro ponto
    public double distX(Point P)
    {
      double dx=this.x-P.getX();//pego no x do meu ponto e subtraio ao x do outro ponto
      return dx;
    }

    public double distY(Point P)
    {
      double dy=this.y-P.getY();//pego no x do meu ponto e subtraio ao x do outro ponto
      return dy;
    }

    public double dist (Point p)
    {
      double dx=this.distX(p);
      double dy=p.distY(this);
//        return  Math.sqrt(dx*dx+(dy*dy)) ;
      return 0;
    }

    public void move(double dx,double dy)
    {
      this.x+=dx;
      this.y+=dy;
    }

    public boolean xBetweenPoints(Point up, Point down)
    {
      if(this.getX()>=up.getX() && this.getX()<=down.getX())
      {
        return true;
      } else {
        return false;
      }
    }

    public boolean yBetweenPoints(Point up, Point down)
    {
      if(this.getY()>=down.getX() && this.getX()<=up.getX()){
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Distância entre 2 pontos, pesos das arestas
     * @param point
     * @return
     */
    public Double distance(Point point)
    {
        return Math.sqrt(point.distX(this) * point.distX(this) + point.distY(this) * point.distY(this));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}