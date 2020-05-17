package edu.ufp.inf.lp2_aed2;

public abstract class Node {

    private static Integer VALOR = 0;
    private Integer id = 0 ;

    public Node() {
        this.id = VALOR++;
    }

    public static Integer getVALOR() {
        return VALOR;
    }

    public static void setVALOR(Integer VALOR) {
        Node.VALOR = VALOR;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
