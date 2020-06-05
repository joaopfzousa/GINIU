package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.ufp.inf.lp2_aed2.points.Node;
import edu.ufp.inf.lp2_aed2.points.Point;

import java.io.Serializable;

public class Room extends Node implements Serializable {
  /**
   * Atributos
   */
  private Integer id;

  private Integer floor;

  private String numberRoom;

  //tomadas ou não
  private boolean socket;

  private Integer capacity;

  // Lista de Schedule pela Class - chave é data
  private RedBlackBST<Date, ScheduleClass> scheduleClassesST = new RedBlackBST<>();

  // Lista de Schedule pela Class - chave é data
  private RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentST = new RedBlackBST<>();

  private Point myPoint;

  /**
   * Construtor
   * @param id
   * @param floor
   * @param numberRoom
   * @param socket
   * @param capacity
   */
  public Room(Integer id, Integer floor, String numberRoom, boolean socket, Integer capacity) {
    super();
    this.id = id;
    this.floor = floor;
    this.numberRoom = numberRoom;
    this.socket = socket;
    this.capacity = capacity;
    this.myPoint = null;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Room{" +
            "id=" + id +
            ", floor=" + floor +
            ", numberRoom=" + numberRoom +
            ", socket=" + socket +
            ", capacity=" + capacity +
            ", point=" + myPoint +
            '}';
  }

  /**
   * toStringFileRoom é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileRoom(){
    return id + ";" + floor + ";" + numberRoom + ";" + socket + ";" + capacity + ";" ;
  }

  public Integer getNode()
  {
    return super.getId();
  }

  /**
   * Procura ocupações das salas por datas
   * @param frstDate
   * @param finalDate
   * @return as salas por aquelas datas
   */
  public RedBlackBST<Date, Schedule> searchLeaveRoomBetweenDates(Date frstDate, Date finalDate)
  {
    RedBlackBST<Date, Schedule> sST = new RedBlackBST<>();

    for(Date d : this.getScheduleAccompanimentST().keys(frstDate, finalDate))
    {
      ScheduleAccompaniment sa = this.getScheduleAccompanimentST().get(d);

      sST.put(sa.getStartDate(), sa);
    }

    for(Date dt: this.getScheduleClassesST().keys(frstDate, finalDate))
    {
      ScheduleClass sc = this.getScheduleClassesST().get(dt);

      sST.put(sc.getStartDate(), sc);
    }

    return sST;
  }

  /**
   * Get's e Set's
   */
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public String getNumberRoom() {
    return numberRoom;
  }

  public void setNumberRoom(String numberRoom) {
    this.numberRoom = numberRoom;
  }

  public boolean isSocket() {
    return socket;
  }

  public void setSocket(boolean socket) {
    this.socket = socket;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public RedBlackBST<Date, ScheduleClass> getScheduleClassesST() {
    return scheduleClassesST;
  }

  public void setScheduleClassesST(RedBlackBST<Date, ScheduleClass> scheduleClassesST) {
    this.scheduleClassesST = scheduleClassesST;
  }

  public RedBlackBST<Date, ScheduleAccompaniment> getScheduleAccompanimentST() {
    return scheduleAccompanimentST;
  }

  public void setScheduleAccompanimentST(RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentST) {
    this.scheduleAccompanimentST = scheduleAccompanimentST;
  }

  public Point getMyPoint() {
    return myPoint;
  }

  public void setMyPoint(Point myPoint) {
    this.myPoint = myPoint;
  }
}