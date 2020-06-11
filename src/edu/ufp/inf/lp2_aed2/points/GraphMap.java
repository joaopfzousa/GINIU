package edu.ufp.inf.lp2_aed2.points;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KosarajuSharirSCC;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.ufp.inf.lp2_aed2.Room;
import edu.ufp.inf.lp2_aed2.University;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GraphMap implements Serializable {

    private University university;

    private static Integer pointsNr = 0;

    private ArrayList<Edge_Project> arrayLisDirectedEdge;

    private ArrayList<Point3D> points3D;

    private EdgeWeightedDigraph_Project graphGeral;

    private RedBlackBST<Integer, Integer> map_grafoGeral;

    private EdgeWeightedDigraph_Project subGrafo;

    private ArrayList<Edge_Project> arrayListDirectedEdge_subgraph;

    public GraphMap(University university) {
        this.arrayLisDirectedEdge = new ArrayList<>();
        this.points3D = new ArrayList<>();
        this.graphGeral = null;
        this.subGrafo = null;
        this.arrayListDirectedEdge_subgraph = null;
        this.map_grafoGeral = new RedBlackBST<>();
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public static Integer getPointsNr() {
        return pointsNr;
    }

    public static void setPointsNr(Integer pointsNr) {
        GraphMap.pointsNr = pointsNr;
    }

    public ArrayList<Edge_Project> getArrayLisDirectedEdge() {
        return arrayLisDirectedEdge;
    }

    public void setArrayLisDirectedEdge(ArrayList<Edge_Project> arrayLisDirectedEdge) {
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

    public void setSubGrafo(Integer nPoints) {
        this.subGrafo = new EdgeWeightedDigraph_Project(nPoints);
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
     * Retorna o vertice antigo
     * @param id
     * @return
     */
    public Point3D returnNodeOld(int id)
    {
        for(Integer i : this.map_grafoGeral.keys())
        {
            if(this.map_grafoGeral.get(i) == id)
            {
                return returnNode(i);
            }
        }
        return null;
    }

    /**
     *  Adiciona uma Aresta com apenas com um sentido
     * @param p1
     * @param p2
     * @param direction
     */
    public Edge_Project addArestaUnidirecional(Point3D p1, Point3D p2, Boolean direction)
    {
        double temp = 1.25;
        double distance = p1.distPontos(p2);
        double tempoDistancia = distance * temp;
        Edge_Project edge = new Edge_Project(p1.getId(), p2.getId(), distance, tempoDistancia, direction);
        arrayLisDirectedEdge.add(edge);
        this.graphGeral.addEdge(edge);
        return edge;
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
        Edge_Project nova = new Edge_Project(p1.getId(), p2.getId(), distancia, tempoDistancia, sentido1);
        Edge_Project nova1 = new Edge_Project(p2.getId(), p1.getId(), distancia, tempoDistancia, sentido2);
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
            int id = Integer.parseInt(fields[0]);
            int id1 = Integer.parseInt(fields[1]);

            Point3D point1 = returnNode(id);
            Point3D point2 = returnNode(id1);

            boolean sentido = Boolean.parseBoolean(fields[2]);

            addArestaUnidirecional(point1, point2, sentido);
        }
    }

    /**
     * load DirectEdge
     */
    public void loadDirectedEdgeRoom()
    {
        String arestasPath = "./data/graphs/edgesRoom";
        In in = new In(arestasPath);
        String s;

        while (!in.isEmpty())
        {
            s = in.readLine();

            String[] fields = s.split(";");
            int id = Integer.parseInt(fields[0]);
            int id1 = Integer.parseInt(fields[1]);

            Point3D point1 = returnNode(id);
            Point3D point2 = returnNode(id1);

            boolean sentido = Boolean.parseBoolean(fields[2]);

            addArestaUnidirecional(point1, point2, sentido);
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
     * Carregar os pontos 3DS
     */
    public void loadPoints3DRoom()
    {
        String nosPath = "./data/graphs/nosRoom";
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
            Room r = this.university.getRoomST().get(description);

            Point3D novo = new Point3D(x, y, z, description, indoor);
            novo.setId(id);
            r.setPoint(novo);
            points3D.add(novo);
        }
        this.graphGeral = new EdgeWeightedDigraph_Project(points3D.size());
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
            if (p.getZ() == floor && !aux.contains(p))
                aux.add(p);

        }
        return aux;
    }

    public ArrayList<Edge_Project> getEdgesByFloor(ArrayList<Point3D> points3D_subgrafo)
    {
        ArrayList<Edge_Project> aux = new ArrayList<>();

        for (Point3D p : points3D_subgrafo)
        {
            for (Edge_Project ep : this.arrayLisDirectedEdge)
            {
                Point3D w = returnNode(ep.getW());
                Point3D v = returnNode(ep.getV());

                if ((p.getId() == ep.getW() || p.getId() == ep.getV()) && !aux.contains(ep) && w.getZ() == v.getZ())
                    aux.add(ep);
            }
        }
        return aux;
    }

    public EdgeWeightedDigraph_Project getSubgrafoByFloor(int idfloor)
    {
        ArrayList<Point3D> aux = getPointsByFloor(idfloor);
        this.map_grafoGeral = mapGraph(idfloor);

        ArrayList<Edge_Project> edges = getEdgesByFloor(aux);

        int size = aux.size();

        this.subGrafo = new EdgeWeightedDigraph_Project(size);

        for(Edge_Project ep: edges)
        {
            Edge_Project ep_novo = new Edge_Project(this.map_grafoGeral.get(ep.getV()), this.map_grafoGeral.get(ep.getW()), ep.getWeight(), ep.getTemp());
            this.subGrafo.addEdge(ep_novo);
        }
        return this.subGrafo;
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
     * Remove Point3D
     * @param edge
     */
    public void removeDirectEdges(Edge_Project edge)
    {
        if(arrayLisDirectedEdge.size() > 0)
        {
            if(edge != null)
            {
                arrayLisDirectedEdge.remove(edge);
            }else{
                System.out.println("[GraphMap] -> This edge is null");
            }
        }else{
            System.out.println("[GraphMap] -> arrayLisDirectedEdge is empty");
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
            if ((p.getZ() == floor))
            {
                aux.put(p.getId(), count);
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
    public ArrayList<Edge_Project> mapEdges(int floor)
    {
        ArrayList<Edge_Project> aux = new ArrayList<Edge_Project>();

        for (Point3D t : this.points3D)
        {
            //check all vertices on floor
            if ((t.getZ() == floor))
            {
                for (Edge_Project d : this.arrayLisDirectedEdge)
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
    public ArrayList<Edge_Project> mapEmergencyEdges(int floor)
    {
        ArrayList<Edge_Project> aux = new ArrayList<Edge_Project>();
        for (Edge_Project d : this.arrayLisDirectedEdge) //iterate on edges
        {
            if (d.getDirection())  // verify edge on id
                aux.add(d);
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

    public ArrayList<Point3D> getOutdoorByFloor(int floor)
    {
        ArrayList<Point3D> aux = new ArrayList<>();

        ArrayList<Point3D> points = getPointsByFloor(floor);

        for(Point3D p : points)
        {
            if(p.getIndoor())
            {
                aux.add(p);
            }
        }
        return aux;
    }

    /**
     * Path pela distancia mais curta
     * @param point
     */
    public ArrayList<String> emergencyPathByDistance(String point, EdgeWeightedDigraph_Project graph, int floor)
    {
        ArrayList<String> aux = new ArrayList<>();

        ArrayList<Point3D> saida = getOutdoorByFloor(floor); // retorna as saidas

        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(graph, Integer.parseInt(point));

        Point3D print = saida.get(0); // first node on arraylist
        double dist = 100000000.00;

        for (Point3D p : saida)
        {
            if (sp.hasPathTo(this.map_grafoGeral.get(p.getId())))
            {
                if (sp.distTo(this.map_grafoGeral.get(p.getId())) < dist)
                {
                    dist = sp.distTo(this.map_grafoGeral.get(p.getId()));
                    print = p;
                }
            }
        }

        Integer idCerto = this.map_grafoGeral.get(print.getId());

        aux.add(point + " to " + idCerto + "("+ sp.distTo(idCerto) +") \n");
        int j = 0;
        for (Edge_Project e : sp.pathTo(idCerto))
        {
            j++;
            BigDecimal bd = new BigDecimal(e.weight()).setScale(2, RoundingMode.HALF_EVEN);
            aux.add(j + "º ->" + " " + e.getV() + "->" + e.getW() + " com distancia de " + bd + "\n");
        }
        aux.add("\n" + print.getDescription());

        return aux;
    }

    /**
     * Path pelo tempo mais curto
     * @param point
     */
    public ArrayList<String> emergencyPathTempo(String point, EdgeWeightedDigraph_Project graph, int floor)
    {
        ArrayList<String> aux = new ArrayList<>();

        ArrayList<Point3D> saida = getOutdoorByFloor(floor);  // retorna as saidas

        DijkstraSP_ProjectTemp sp = new DijkstraSP_ProjectTemp(graph, Integer.parseInt(point)); // aplica dijkstraSP

        Point3D print = saida.get(0); // primeiro no do arraylist
        double dist = 100000000.00;

        for (Point3D p : saida)
        {
            if (sp.hasPathTo(this.map_grafoGeral.get(p.getId())))
            {
                if (sp.distTo(this.map_grafoGeral.get(p.getId())) < dist)
                {
                    dist = sp.distTo(this.map_grafoGeral.get(p.getId()));
                    print = p;
                }
            }
        }

        Integer idCerto = this.map_grafoGeral.get(print.getId());
        aux.add(point + " to " + idCerto + "("+ sp.distTo(idCerto) +") \n");
        int j = 0;
        for (Edge_Project e : sp.pathTo(idCerto))
        {
            j++;
            BigDecimal bd = new BigDecimal(e.weight()).setScale(2, RoundingMode.HALF_EVEN);
            aux.add(j + "º ->" + " " + e.getV() + "->" + e.getW() + " com distancia de " + bd + "\n");
        }
        aux.add("\n" + print.getDescription());

        return aux;
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
        ArrayList<Edge_Project> aux1 = this.arrayLisDirectedEdge;
        for (Edge_Project e : aux1)
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
                for (Edge_Project e : sp.pathTo(t))
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
        ArrayList<Edge_Project> aux1 = this.arrayLisDirectedEdge;
        for (Edge_Project e : aux1)
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
                for (Edge_Project d : dp.pathTo(t))
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
    public String grafoConexo(EdgeWeightedDigraph_Project graph)
    {
        KosarajuSharirSCC scc = new KosarajuSharirSCC(graph.criarDigrafo());
        int m = scc.count(); // é conexo quando tem um so elemento fortemente ligado

        if (m == 1) {
            return "O Grafo é conexo!";
        } else {
            return "O Grafo não é conexo";
        }
    }


    /**
     *  Caminho mais curto entre dois pontos pela distancia
     * @param r1
     * @param r2
     * @param graphGeral
     */
    public ArrayList<String> shortestPathBetweenTwoPointsByDistance(Point3D r1, Point3D r2, EdgeWeightedDigraph_Project graphGeral)
    {
        ArrayList<String> aux = new ArrayList<>();

        DijkstraSP_ProjectWeight dp = new DijkstraSP_ProjectWeight(graphGeral, r1.getId());

        if (dp.hasPathTo(r2.getId()))
        {
            aux.add(r1.getId() + " to "+ r2.getId() + "(" + dp.distTo(r2.getId()) +")");
            for (Edge_Project e : dp.pathTo(r2.getId())) {
                aux.add(e.getV() + "->" + e.getW() + " com distancia de " + e.weight() + " segundos ");
            }
        }
        return aux;
    }

    /**
     * Caminho mais curto entre dois pontos pelo tempo
     * @param r1
     * @param r2
     * @param graphGeral
     */
    public ArrayList<String> shortestPathbetweenTwoPointsByTemp(Point3D r1, Point3D r2, EdgeWeightedDigraph_Project graphGeral)
    {
        ArrayList<String> aux = new ArrayList<>();

        DijkstraSP_ProjectTemp dp = new DijkstraSP_ProjectTemp(graphGeral, r1.getId());

        if (dp.hasPathTo(r2.getId()))
        {
            aux.add(r1.getId() + " to "+ r2.getId() + "(" + dp.distTo(r2.getId()) +")");
            for (Edge_Project e : dp.pathTo(r2.getId())) {
                aux.add(e.getV() + "->" + e.getW() + " com distancia de " + e.weight() + " segundos ");
            }
        }
        return aux;
    }

    public void caminhosUmParaTodos(Point3D p1,EdgeWeightedDigraph_Project graphGeral)
    {
        DijkstraSP_ProjectWeight sp = new DijkstraSP_ProjectWeight(graphGeral, p1.getId());

        for (int t = 0; t < graphGeral.V(); t++)
        {
            if (sp.hasPathTo(t))
            {
                System.out.println( p1.getId() + " to " + t + "(" + sp.distTo(t) + ")");
                for (Edge_Project e : sp.pathTo(t))
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
                for (Edge_Project e : sp.pathTo(t))
                    System.out.println(e + "  ");

                System.out.println();
            }else {
                System.out.println(s1 + " to " + t + "   no path");
            }
        }
    }

    public static void main(String[] args) {
        University u = new University("UFP");
        GraphMap grafoTeste = new GraphMap(u);
        grafoTeste.loadPoints3D();
        grafoTeste.loadDirectedEdge();
        //  grafoTeste.imprimeTodasDirectedEdgeVersaoEditada();
        //  grafoTeste.imprimeTodosPontos3D();
        grafoTeste.grafoConexo(grafoTeste.graphGeral);
        grafoTeste.emergencyPathByDistance(String.valueOf(new Point3D(20.0, 15.0, 3, "teste", true).getId()), grafoTeste.graphGeral,3);
        grafoTeste.emergencyPathTempo(String.valueOf(new Point3D(20.0, 15.0, 3, "teste", true).getId()), grafoTeste.graphGeral, 3);
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