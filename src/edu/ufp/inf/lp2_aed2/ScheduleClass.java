package edu.ufp.inf.lp2_aed2;

public class ScheduleClass extends Schedule {

  private Class classe;

  public ScheduleClass(Date startDate, Date finalDate, Room room, Class classe) {
    super(startDate, finalDate, room);
    this.classe = classe;
  }

  @Override
  public String toString() {
    return "ScheduleClass{" +
            "classe=" + classe +
            '}';
  }

  public void addClass(Class c) {
  }

  public Class removeClass(Class id) {
  return null;
  }

  public Class editClass(Class id) {
  return null;
  }

  public Schedule searchClass(Class id) {
  return null;
  }

  public Class getClasse() {
    return classe;
  }

  public void setClasse(Class classe) {
    this.classe = classe;
  }
}