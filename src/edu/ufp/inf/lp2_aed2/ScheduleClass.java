package edu.ufp.inf.lp2_aed2;

public class ScheduleClass extends Schedule {

  private Class classe;

  public ScheduleClass(Date startDate, Date finalDate, Room room, Class classe) {
    super(startDate, finalDate, room);
    this.classe = classe;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "ScheduleClass{" +
            "classe=" + classe +
            '}';
  }

  /**
   * Get's e Set's
   */
  public Class getClasse() {
    return classe;
  }

  public void setClasse(Class classe) {
    this.classe = classe;
  }
}