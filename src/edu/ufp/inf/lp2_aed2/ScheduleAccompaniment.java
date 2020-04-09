package edu.ufp.inf.lp2_aed2;

public class ScheduleAccompaniment extends Schedule {

  private Teacher teacher;

  public ScheduleAccompaniment(Date startDate, Date finalDate, Room room, Teacher teacher) {
    super(startDate, finalDate, room);
    this.teacher = teacher;
  }

  @Override
  public String toString() {
    return "ScheduleAccompaniment{" +
            "teacher=" + teacher +
            '}';
  }

  public void addTeacher(Teacher t) {
  }

  public Teacher removeTeacher(Teacher email) {
  return null;
  }

  public Teacher editTeacher(Teacher email) {
  return null;
  }

  public Schedule searchTeacher(Teacher email) {
  return null;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
}