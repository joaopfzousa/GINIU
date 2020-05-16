package edu.ufp.inf.lp2_aed2;

public class Point
{
    private double x;

    private double y;

    public Point(double x,double y){ //a e b
      this.x=x;
      this.y=y;
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

    //Rectangulo
    public static void main(String[] args) {
      // TODO code application logic here
      Point p1=new Point(1.0f,1.0f);
      Point p2=new Point();
      double dx = p1.distX(p2);
      dx = p2.distX(p1);
      double dy=p2.distY(p1);


      System.out.printf("Valor =",dx);
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
   * Distancia entre dois pontos, peso das arestas
   * @param p ponto
   * @return distancia
   */
    public Double distPoints(Point p)
    {
      return Math.sqrt(p.distX(this) * p.distX(this) + p.distY(this) * p.distY(this));
    }
}