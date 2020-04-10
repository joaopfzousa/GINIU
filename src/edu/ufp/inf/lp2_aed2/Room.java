package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;

public class Room {

  /**
   * Atributos
   */
  private Integer id;

  private Integer floor;

  private Integer numberRoom;

  //tomadas ou não
  private boolean socket;

  private Integer capacity;

  // Lista de Schedule pela Class - chave é data
  private RedBlackBST<Date, Schedule> scheduleClassesST = new RedBlackBST<>();

  //public Vector  myPoint;

  /**
   * Construtor
   * @param id
   * @param floor
   * @param numberRoom
   * @param socket
   * @param capacity
   */
  public Room(Integer id, Integer floor, Integer numberRoom, boolean socket, Integer capacity) {
    this.id = id;
    this.floor = floor;
    this.numberRoom = numberRoom;
    this.socket = socket;
    this.capacity = capacity;
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
            '}';
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

  public Integer getNumberRoom() {
    return numberRoom;
  }

  public void setNumberRoom(Integer numberRoom) {
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

  public RedBlackBST<Date, Schedule> getScheduleClassesST() {
    return scheduleClassesST;
  }

  public void setScheduleClassesST(RedBlackBST<Date, Schedule> scheduleClassesST) {
    this.scheduleClassesST = scheduleClassesST;
  }
}