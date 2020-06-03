package edu.ufp.inf.lp2_aed2.points;

public class Point
{
    private double x;

    private double y;

    private double z;

    private final Double secondByM = 1.5;


    public Point(double x,double y, double z){ //a e b
      this.x = x;
      this.y = y;
      this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
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

    public Double distancia(Point point) {
        Double x = (point.getX() - this.x) * (point.getX() - this.x);
        Double y = (point.getY() - this.y) * (point.getY() - this.y);
        Double z = (point.getZ() - this.z) * (point.getZ() - this.z);
        return Math.sqrt(x+y+z);
    }

    public Double segundoPelaDistancia(Point point){
        return secondByM*distancia(point);
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getSecondByM() {
        return secondByM;
    }


}