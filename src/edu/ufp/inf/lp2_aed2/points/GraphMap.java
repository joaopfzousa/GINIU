package edu.ufp.inf.lp2_aed2.points;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KosarajuSharirSCC;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.ufp.inf.lp2_aed2.Room;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GraphMap implements Serializable {

    private static Integer pointsNr = 0;

    private ArrayList<DirectedEdge_Project>  arrayLisDirectedEdge;

    private ArrayList<Point3D> points3D;

    private EdgeWeightedDigraph_Project graphGeral;

    private RedBlackBST<Integer, Integer> map_grafoGeral;

    private EdgeWeightedDigraph_Project subGrafo;

    public GraphMap() {
        this.arrayLisDirectedEdge = new ArrayList<>();
        this.points3D = new ArrayList<>();
        this.graphGeral = null;
        this.subGrafo = null;
        this.map_grafoGeral = new RedBlackBST<>();
    }

    public static Integer getPointsNr() {
        return pointsNr;
    }

    public static void setPointsNr(Integer pointsNr) {
        GraphMap.pointsNr = pointsNr;
    }

    public ArrayList<DirectedEdge_Project> getArrayLisDirectedEdge() {
        return arrayLisDirectedEdge;
    }

    public void setArrayLisDirectedEdge(ArrayList<DirectedEdge_Project> arrayLisDirectedEdge) {
        this.arrayLisDirectedEdge = arrayLisDirectedEdge;
    }

    public ArrayList<Point3D> getPoints3D() {
        return points3D;
    }

    public void setPoints3D(ArrayList<Point3D> points3D) {
        this.points3D = points3D;
    }

    public EdgeWeightedDigraph_Project getGraphGeral() {
        return graphGeral;
    }

    public void setGraphGeral(EdgeWeightedDigraph_Project graphGeral) {
        this.graphGeral = graphGeral;
    }

    public RedBlackBST<Integer, Integer> getMap_grafoGeral() {
        return map_grafoGeral;
    }

    public void setMap_grafoGeral(RedBlackBST<Integer, Integer> map_grafoGeral) {
        this.map_grafoGeral = map_grafoGeral;
    }

    public EdgeWeightedDigraph_Project getSubGrafo() {
        return subGrafo;
    }

    public void setSubGrafo(EdgeWeightedDigraph_Project subGrafo) {
        this.subGrafo = subGrafo;
    }

    /**
     * Retornar os dados de um vértice
     * @param id
     * @return
     */
    public Point3D returnNode(int id)
    {
        for (Point3D t : this.getPoints3D())
        {
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    /**
     *  Adiciona uma Aresta com apenas com um sentido
     * @param p1
     * @param p2
     * @param sentido
     */
    public void addArestaUnidirecional(Point3D p1, Point3D p2, Boolean sentido) {
        double tempo = 1.25;
        double distancia = p1.distPontos(p2);
        double tempoDistancia = distancia * tempo;
        DirectedEdge_Project nova = new DirectedEdge_Project(p1.getId(), p2.getId(), distancia, tempoDistancia);
        arrayLisDirectedEdge.add(nova);
        this.graphGeral.addEdge(nova);
    }

    /**
     * Adiciona uma Aresta com apenas com um sentido com os dois sentidos
     * @param p1
     * @param p2
     * @param sentido1
     * @param sentido2
     */
    public void addArestaBidirecional(Point3D p1, Point3D p2, Boolean sentido1, Boolean sentido2) {
        double tempo = 1.25;
        double distancia = p1.distPontos(p2);
        double tempoDistancia = distancia * tempo;
        DirectedEdge_Project nova = new DirectedEdge_Project(p1.getId(), p2.getId(), distancia, tempoDistancia);
        DirectedEdge_Project nova1 = new DirectedEdge_Project(p2.getId(), p1.getId(), distancia, tempoDistancia);
        nova.setSentido(sentido1);
        nova1.setSentido(sentido2);
        arrayLisDirectedEdge.add(nova);
        arrayLisDirectedEdge.add(nova1);
        this.graphGeral.addEdge(nova);
        this.graphGeral.addEdge(nova1);
    }

    /**
     * load DirectEdge
     */
    public void loadDirectedEdge()
    {
        String arestasPath = "./data/graphs/edgesGrafo";
        In in = new In(arestasPath);
        String s;

        while (!in.isEmpty())
        {
            s = in.readLine();

            String[] fields = s.split(";");
            Integer id = Integer.parseInt(fields[0]);
            Integer id1 = Integer.parseInt(fields[1]);

            Point3D um = returnNode(id);
            Point3D dois = returnNode(id1);

            boolean sentido = Boolean.parseBoolean(fields[2]);
            addArestaUnidirecional(um, dois, sentido);
        }
    }


    /**
     * Carregar os pontos 3DS
     */
    public void loadPoints3D()
    {
        String nosPath = "./data/graphs/nosGrafo";
        In in = new In(nosPath);
        String s;
        while (!in.isEmpty())
        {
            s = in.readLine();
            String[] fields = s.split(";");
            Integer id = Integer.parseInt(fields[0]);
            Double x = Double.parseDouble(fields[1]);
            Double y = Double.parseDouble(fields[2]);
            Integer z = Integer.parseInt(fields[3]);

            boolean indoor = Boolean.parseBoolean(fields[4]);
            String description = fields[5];

            Point3D novo = new Point3D(x, y, z, description, indoor);
            novo.setId(id);
            points3D.add(novo);

        }
        this.graphGeral = new EdgeWeightedDigraph_Project(points3D.size());
    }

    /**
     * list all DirectEdge
     */
    public void listAllDirectedEdge()
    {
        for (DirectedEdge_Project d : this.arrayLisDirectedEdge)
        {
            System.out.println(d);
        }
    }

    /**
     * list all Points3D
     */
    public void listAllPoints3D()
    {
        for (Point3D p : this.points3D)
        {
            System.out.println(p);
        }
    }

    /**
     * Retornar os diferentes andares
     * @return
     */
    public ArrayList<Integer> getDistinctExistingFloors()
    {
        ArrayList<Integer> floors = new ArrayList<>();
        for (Point3D p : this.points3D)
        {
            if (!floors.contains(p.getZ()))
                floors.add(p.getZ());
        }
        return floors;
    }

    /**
     * Pontos todos por andar
     * @param floor
     * @return
     */
    public ArrayList<Point3D> getPointsByFloor(int floor)
    {
        ArrayList<Point3D> aux = new ArrayList<>();
        for (Point3D p : this.points3D)
        {
            if (p.getZ() == floor)
                aux.add(p);

        }
        return aux;
    }

    /**
     * Pontos a ignorar
     * @param ignored
     * @return lista de todos os pontos que posso passar
     */
    public ArrayList<Point3D> getPointsValid(ArrayList<Point3D> ignored)
    {
        ArrayList<Point3D> aux = new ArrayList<>();
        for (Point3D t : this.points3D)
        {
            if (!ignored.contains(t))
                aux.add(t);
        }
        return aux;
    }

    /**
     * Adicionar point3D
     * @param point
     */
    public void addPoint3D(Point3D point)
    {
        if (!this.points3D.contains(point))
        {
            this.pointsNr++;
            this.points3D.add(point);
        }
    }

    /**
     * Remove Point3D
     * @param point
     */
    public void removePoints(Point3D point)
    {
        Iterator<Point3D> i = this.points3D.iterator();
        while (i.hasNext())
        {
            Point3D a = (Point3D) i.next();
            if (a.compareTo(point) == 0)
                i.remove();

        }
    }

    /**
     * adicionar um ponto3D
     * @param x
     * @param y
     * @param z
     * @param descricao
     * @param indoor
     * @return
     */
    public Point3D novoPonto(double x, double y, Integer z, String descricao, Boolean indoor) {
        Point3D aux = new Point3D(x, y, z, pointsNr, descricao, indoor);
        this.pointsNr++;
        return aux;
    }

    /**
     * Mapear o graph
     * @param floor
     * @return redblack mapeada
     */
    public RedBlackBST<Integer, Integer> mapGraph(int floor)
    {
        int count = 0;
        RedBlackBST<Integer, Integer> aux = new RedBlackBST<>();
        for (Point3D p : this.points3D)
        {
            if ((p.getZ() == floor)) {
                aux.put(count, p.getId());
                count++;
            }
        }
        return aux;
    }

    /**
     * Mapear todas as Arestas
     * @param floor
     * @return
     */
    public ArrayList<DirectedEdge_Project> mapEdges(int floor)
    {
        ArrayList<DirectedEdge_Project> aux = new ArrayList<DirectedEdge_Project>();

        for (Point3D t : this.points3D)
        {
            //check all vertices on floor
            if ((t.getZ() == floor))
            {
                for (DirectedEdge_Project d : this.arrayLisDirectedEdge)
                { // vai andar nas arestas
                    if (d.getV() == t.getId() || d.getW() == t.getId())  // verify if edge in id
                        aux.add(d);
                }
            }
        }
        return aux;
    }

    /**
     * Mapear as arestas de Emergência
     * @param floor
     * @return
     */
    public ArrayList<DirectedEdge_Project> mapEmergencyEdges(int floor)
    {
        ArrayList<DirectedEdge_Project> aux = new ArrayList<DirectedEdge_Project>();
        for (DirectedEdge_Project d : this.arrayLisDirectedEdge) //iterate on edges
        {
            if (d.getSentido())  // verify edge on id
                aux.add(d);
        }
        return aux;
    }

    /**
     * Devolve todos os pontos que são outdoor
     * @return
     */
    public ArrayList<Point3D> outdoor()
    {
        ArrayList<Point3D> aux = new ArrayList<>();

        for (Point3D p : this.points3D)
        {
            if (!p.getIndoor())
                aux.add(p);

        }
        return aux;
    }

    /**
     * retorna o ponto mais próximo
     * @param ponto
     * @return
     */
    public Point3D returnClosestPoint(Point3D ponto)
    {
        Point3D reference = this.points3D.get(0); // primeiro no do arraylist
        double dist = ponto.distPontos(reference);

        for (Point3D x : this.points3D)
        {
            if (ponto.distPontos(x) < dist) {
                dist = ponto.distPontos(x);
                reference = x;
            }
        }
        return reference;
    }

    /**
     * Path pela distancia mais curta
     * @param point
     */
    public void emergencyPathByDistance(Point3D point)
    {
        Point3D reference = returnClosestPoint(point);

        ArrayList<Point3D> saida = outdoor(); // retorna as saidas

        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(this.graphGeral, reference.getId());

        Point3D print = saida.get(0); // first node on arraylist
        double dist = 100000000.00;

        for (Point3D p : saida) {
            if (sp.hasPathTo(p.getId()))
            {
                if (sp.distTo(p.getId()) < dist)
                {
                    dist = sp.distTo(p.getId());
                    print = p;
                }
            }
        }

        System.out.println(reference.getId()+ " to " + print.getId() + "("+ sp.distTo(print.getId()) +") \n");

        int j = 0;
        for (DirectedEdge_Project e : sp.pathTo(print.getId()))
        {
            j++;
            BigDecimal bd = new BigDecimal(e.weight()).setScale(2, RoundingMode.HALF_EVEN);
            System.out.print(j + "º ->" + " " + e.getV() + "->" + e.getW() + " com distancia de " + bd + "\n");
        }
        System.out.println("\n" + print.getDescription());
    }

    /**
     * Path pelo tempo mais curto
     * @param point
     */
    public void emergencyPathTempo(Point3D point)
    {
        Point3D reference = returnClosestPoint(point);

        ArrayList<Point3D> saida = outdoor(); // retorna as saidas

        DijkstraSP_ProjectTemp sp = new DijkstraSP_ProjectTemp(this.graphGeral, reference.getId()); // aplica dijkstraSP

        Point3D print = saida.get(0); // primeiro no do arraylist
        double dist = 100000000.00;

        for (Point3D p : saida)
        {
            if (sp.hasPathTo(p.getId()))
            {
                if (sp.distTo(p.getId()) < dist)
                {
                    dist = sp.distTo(p.getId());
                    print = p;
                }
            }
        }

        System.out.println(reference.getId()+ " to " + print.getId() + "("+ sp.distTo(print.getId()) +") \n");
        int j = 0;
        for (DirectedEdge_Project e : sp.pathTo(print.getId()))
        {
            j++;
            BigDecimal bd = new BigDecimal(e.weight()).setScale(2, RoundingMode.HALF_EVEN);
            System.out.print(j + "º ->" + " " + e.getV() + "->" + e.getW() + " com distancia de " + bd + "\n");
        }
        System.out.println("\n" + print.getDescription());
    }

    /**
     * Caminho evitando certos pontos
     * @param point
     * @param points
     */
    public void avoidPointsPath(Point3D point, ArrayList<Integer> points)
    {
        Point3D reference = returnClosestPoint(point);

        EdgeWeightedDigraph_Project aux = new EdgeWeightedDigraph_Project(this.graphGeral.V());
        ArrayList<DirectedEdge_Project> aux1 = this.arrayLisDirectedEdge;
        for (DirectedEdge_Project e : aux1)
        {
            for (Integer i : points)
            {
                if (e.getV() == i || e.getW() == i)
                    e.setWeight(Double.POSITIVE_INFINITY);
            }
        }

        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(aux, reference.getId());

        for (int t = 0; t < aux.V(); t++)
        {
            if (sp.hasPathTo(t))
            {
                System.out.println(reference.getId()+ " to " + t + "("+ sp.distTo(t) +") \n");
                for (DirectedEdge_Project e : sp.pathTo(t))
                {
                    System.out.println(e.getV() + "->" + e.getW() + " com distancia de " + e.weight() + " segundos ");
                }
            }
        }
    }

    /**
     * Caminho evitando certos pontos
     * @param graph
     * @param id
     * @param pontos
     */
    public void avoidPointsPath(EdgeWeightedDigraph_Project graph, Integer id, ArrayList<Integer> pontos)
    {
        ArrayList<DirectedEdge_Project> aux1 = this.arrayLisDirectedEdge;
        for (DirectedEdge_Project e : aux1)
        {
            for (Integer i : pontos)
            {
                if (e.getV() == i || e.getW() == i)
                    e.setWeight(Double.POSITIVE_INFINITY);
            }
        }

        DijkstraSP_ProjectWeight dp = new DijkstraSP_ProjectWeight(graph, id);

        for (int t = 0; t < graph.V(); t++)
        {
            if (dp.hasPathTo(t))
            {
                System.out.println(id+ " to " + t + "("+ dp.distTo(t) +") \n");
                for (DirectedEdge_Project d : dp.pathTo(t))
                    System.out.print(d);
                System.out.println();
            }else {
                System.out.println(id + " to " + t + "  no path \n");
            }
        }
    }

    /**
     * Testar se o grafo é conexo
     * @param graph
     */
    public void grafoConexo(EdgeWeightedDigraph_Project graph)
    {
        KosarajuSharirSCC scc = new KosarajuSharirSCC(graph.criarDigrafo());
        int m = scc.count(); // é conexo quando tem um so elemento fortemente ligado

        if (m == 1) {
            System.out.println("O Grafo é conexo");
        } else {
            System.out.println("O Grafo não é conexo");
        }
    }


    /**
     *  Caminho mais curto entre dois pontos pela distancia
     * @param r1
     * @param r2
     * @param graphGeral
     */
    public void shortestPathBetweenTwoPointsByDistance(Room r1, Room r2, EdgeWeightedDigraph_Project graphGeral)
    {
        DijkstraSP_ProjectWeight dp = new DijkstraSP_ProjectWeight(graphGeral, r1.getPoint().getId());

        if (dp.hasPathTo(r2.getId()))
        {
            System.out.println(r1.getPoint().getId() + " to "+ r2.getPoint().getId() + "(" + dp.distTo(r2.getPoint().getId()) +")");

            for (DirectedEdge_Project e : dp.pathTo(r2.getPoint().getId())) {
                System.out.print(e.getV() + "->" + e.getW() + " com distancia de " + e.weight() + " segundos ");
            }
            System.out.println();
        }
    }

    /**
     * Caminho mais curto entre dois pontos pelo tempo
     * @param r1
     * @param r2
     * @param graphGeral
     */
    public void shortestPathbetweenTwoPointsByTemp(Room r1, Room r2, EdgeWeightedDigraph_Project graphGeral)
    {
        DijkstraSP_ProjectTemp dp = new DijkstraSP_ProjectTemp(graphGeral, r1.getPoint().getId());

        if (dp.hasPathTo(r2.getId()))
        {
            System.out.println(r1.getPoint().getId() + " to "+ r2.getPoint().getId() + "(" + dp.distTo(r2.getPoint().getId()) +")");

            for (DirectedEdge_Project e : dp.pathTo(r2.getPoint().getId())) {
                System.out.print(e.getV() + "->" + e.getW() + " com distancia de " + e.weight() + " segundos ");
            }
            System.out.println();
        }
    }

    public void caminhosUmParaTodos(Point3D p1,EdgeWeightedDigraph_Project graphGeral)
    {
        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(graphGeral, p1.getId());

        for (int t = 0; t < graphGeral.V(); t++)
        {
            if (sp.hasPathTo(t))
            {
                System.out.println( p1.getId() + " to " + t + "(" + sp.distTo(t) + ")");
                for (DirectedEdge_Project e : sp.pathTo(t))
                    System.out.println(e + "  ");

                System.out.println();
            }else {
                System.out.println(p1 + " to " + t + "   no path");
            }
        }
    }

    public void caminhosUmParaTodos(EdgeWeightedDigraph_Project graphGeral,Integer s1)
    {
        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(graphGeral, s1);

        for (int t = 0; t < graphGeral.V(); t++)
        {
            if (sp.hasPathTo(t))
            {
                System.out.println( s1 + " to " + t + "(" + sp.distTo(t) + ")");
                for (DirectedEdge_Project e : sp.pathTo(t))
                    System.out.println(e + "  ");

                System.out.println();
            }else {
                System.out.println(s1 + " to " + t + "   no path");
            }
        }
    }

    public static void main(String[] args) {
        GraphMap grafoTeste = new GraphMap();
        grafoTeste.loadPoints3D();
        grafoTeste.loadDirectedEdge();
        //  grafoTeste.imprimeTodasDirectedEdgeVersaoEditada();
        //  grafoTeste.imprimeTodosPontos3D();
        grafoTeste.grafoConexo(grafoTeste.graphGeral);
        grafoTeste.emergencyPathByDistance(new Point3D(20.0, 15.0, 3, "teste", true));
        grafoTeste.emergencyPathTempo(new Point3D(20.0, 15.0, 3, "teste", true));
        grafoTeste.caminhosUmParaTodos(grafoTeste.graphGeral,2);
        ArrayList<Integer> teste = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i<5;i++){
            teste.add(random.nextInt(46));
        }

        for(Integer i : teste)
            System.out.println(i);


        grafoTeste.avoidPointsPath(grafoTeste.graphGeral,26,teste);
    }
}