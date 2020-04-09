package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Schedule {

  private Date startDate;

  private Date finalDate;

  private Room room;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  private SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();

  public Schedule(Date startDate, Date finalDate, Room room) {
    this.startDate = startDate;
    this.finalDate = finalDate;
    this.room = room;
  }

  @Override
  public String toString() {
    return "Schedule{" +
            "startDate=" + startDate +
            ", finalDate=" + finalDate +
            ", room=" + room +
            '}';
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getFinalDate() {
    return finalDate;
  }

  public void setFinalDate(Date finalDate) {
    this.finalDate = finalDate;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public SeparateChainingHashST<Integer, Teacher> getTeachersST() {
    return teachersST;
  }

  public void setTeachersST(SeparateChainingHashST<Integer, Teacher> teachersST) {
    this.teachersST = teachersST;
  }
}