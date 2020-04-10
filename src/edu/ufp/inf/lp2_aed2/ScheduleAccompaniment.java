package edu.ufp.inf.lp2_aed2;

public class ScheduleAccompaniment extends Schedule {
  /**
   * Atributo
   */
  private Teacher teacher;

  /**
   * Super construtor
   * @param startDate
   * @param finalDate
   * @param room
   * @param teacher
   */
  public ScheduleAccompaniment(Date startDate, Date finalDate, Room room, Teacher teacher) {
    super(startDate, finalDate, room);
    this.teacher = teacher;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "ScheduleAccompaniment{" +
            "teacher=" + teacher +
            '}';
  }


  /**
   * Get's e Set's
   */
  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
}