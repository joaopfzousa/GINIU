package edu.ufp.inf.lp2_aed2.points;


import edu.princeton.cs.algs4.StdOut;

class EdgeEdit implements Comparable<EdgeEdit> {

    private final int v;
    private final int w;
    private final double weight;
    private final double seconds;
    private String descricao;
    private Boolean emergency;

    public EdgeEdit(int v, int w, double weight, double seconds) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        if (Double.isNaN(seconds)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
        this.seconds = seconds;
        this.descricao = null;
        this.emergency = false;
    }

    public EdgeEdit(int v, int w, double weight, double seconds, String descricao) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        if (Double.isNaN(seconds)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
        this.seconds = seconds;
        this.descricao = descricao;
        this.emergency = false;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Returns the weight of this edge.
     *
     * @return the weight of this edge
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns either endpoint of this edge.
     *
     * @return either endpoint of this edge
     */
    public int either() {
        return v;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public double getWeight() {
        return weight;
    }

    public double getSeconds() {
        return seconds;
    }

    /**
     * Returns the endpoint of this edge that is different from the given vertex.
     *
     * @param vertex one endpoint of this edge
     * @return the other endpoint of this edge
     * @throws IllegalArgumentException if the vertex is not one of the
     *                                  endpoints of this edge
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Compares two edges by weight.
     * Note that {@code compareTo()} is not consistent with {@code equals()},
     * which uses the reference equality implementation inherited from {@code Object}.
     *
     * @param that the other edge
     * @return a negative integer, zero, or positive integer depending on whether
     * the weight of this is less than, equal to, or greater than the
     * argument edge
     */
    @Override
    public int compareTo(EdgeEdit that) {
        if (Double.compare(this.weight, that.weight) == 0) {
            if (Double.compare(this.seconds, that.seconds) == 0) {
                return 0;
            }
        }
        return 1;
    }

    /**
     * Returns a string representation of this edge.
     *
     * @return a string representation of this edge
     */
    public String toString() {
        return String.format("%d-%d %.2f distancia %.2f tempo em segundos , ligacao para %s", v, w, weight, seconds, descricao);
    }

    /**
     * Unit tests the {@code Edge} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        EdgeEdit e = new EdgeEdit(12, 34, 5.67, 23.22, "casa de banho");
        StdOut.println(e);
    }
}

/******************************************************************************
 *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/

