package edu.ufp.inf.lp2_aed2;

public class ScheduleClass extends Schedule {
  /**
   * Atributo
   */
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
    return "ScheduleClass{" + super.toString() +
            ", classe=" + classe +
            '}';
  }

  /**
   * toStringFileScheduleClass é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileScheduleClass(){
    return getStartDate().getDayOfWeekInt() + "/" + getStartDate().getHour() + "/" + getStartDate().getMinute()+ ";" + getFinalDate().getDayOfWeekInt() + "/" + getFinalDate().getHour() + "/" + getFinalDate().getMinute()+ ";" + getRoom().getNumberRoom() + ";" + getClasse().getName() + ";" ;
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