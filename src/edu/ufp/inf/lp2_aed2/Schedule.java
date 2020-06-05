package edu.ufp.inf.lp2_aed2;

import java.io.Serializable;

public abstract class Schedule implements Serializable {
  /**
   * Atributos
   */
  private Date startDate;

  private Date finalDate;

  private Room room;

  /**
   * Construtor
   * @param startDate
   * @param finalDate
   * @param room
   */
  public Schedule(Date startDate, Date finalDate, Room room) {
    this.startDate = startDate;
    this.finalDate = finalDate;
    this.room = room;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Schedule{" +
            "startDate=" + startDate +
            ", finalDate=" + finalDate +
            ", room=" + room +
            '}';
  }

  /**
   * Get's e Set's
   */
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
}