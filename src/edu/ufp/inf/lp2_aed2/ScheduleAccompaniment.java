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
   * Metodos
   */
  public void addTeacher(Teacher t) {
  }

  public Teacher removeTeacher(Teacher email) {
  return null;
  }

  public Teacher editTeacher(Teacher email) {
  return null;
  }

  public Teacher searchTeacher(Teacher email) {
  return null;
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