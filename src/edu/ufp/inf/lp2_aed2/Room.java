package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;

public class Room {

  public Integer id;

  public Integer floor;

  public Integer numberRoom;

  //tomadas ou não
  public boolean socket;

  public Integer capacity;

  // Lista de Schedule pela Class - chave é data
  public RedBlackBST<Date, Schedule> scheduleClassesST = new RedBlackBST<>();

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
}