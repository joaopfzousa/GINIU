package edu.ufp.inf.lp2_aed2.points;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;

import java.io.Serializable;
import java.util.ArrayList;

public class GraphMap <T extends Point3D> implements Serializable {

    private static int nrPoints = 0;

    ArrayList<T> points;

    ArrayList<Point3D> points2;

    private Graph grafh;

    private Digraph digrafh;

}
