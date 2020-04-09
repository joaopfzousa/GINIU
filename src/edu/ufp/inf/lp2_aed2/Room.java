package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;

public class Room {

  private Integer id;

  private Integer floor;

  private Integer numberRoom;

  public Room(Integer id, Integer floor, Integer numberRoom, boolean socket, Integer capacity) {
    this.id = id;
    this.floor = floor;
    this.numberRoom = numberRoom;
    this.socket = socket;
    this.capacity = capacity;
  }

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

  //tomadas ou não
  private boolean socket;

  private Integer capacity;

  // Lista de Schedule pela Class - chave é data
  private RedBlackBST<Date, Schedule> scheduleClassesST = new RedBlackBST<>();

  //public Vector  myPoint;

  public void addSchedule(Schedule s) {
  }

  public Schedule remove(Integer id) {
  return null;
  }

  public Schedule editSchedule(Integer id) {
  return null;
  }

  public Schedule searchSchedule(Integer id) {
  return null;
  }

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