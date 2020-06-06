package edu.ufp.inf.lp2_aed2.points;

import java.io.Serializable;

public class Local extends Point3D implements Serializable {

    private Integer capacity;

    private Integer occupation;

    public Local(double x, double y, Integer z, String descricao, Integer capacity, Integer occupation, Boolean indoor) {
        super(x, y, z, descricao,indoor);
        this.capacity = capacity;
        this.occupation = occupation;
    }

    public Local(Integer id, Integer z, String descricao, Integer capacity, Integer occupation) {
        super(id, z, descricao,true);
        this.capacity = capacity;
        this.occupation = occupation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setCccupationExit() {
        if (this.occupation == 0) {
            return;
        }
        this.occupation -= 1;
    }

    public void setCccupationEntry() {
        if (this.occupation == this.occupation) {
            System.out.println("Esta cheio!");
            return;
        }
        this.occupation += 1;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Ponto de interesse - " + this.description() + " Tem uma lotacao de " + capacity + " tem uma ocupacao de " + occupation + " fica localizada no " +
                this.getZ() + "piso - " + super.toString();

    }
}
