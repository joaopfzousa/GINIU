package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Teacher extends Person {

  /**
   * Atributos
   */
  // Lista de CourseUnit do Teacher - chave é o id do CourseUnit
  public SeparateChainingHashST<Integer, CourseUnit> courseUnitsST = new SeparateChainingHashST<>();

  // Lista de Class pela Teacher - chave é nome da Class
  public RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  // Lista de Schedule pela Teacher - chave é data
  public RedBlackBST<Date, Schedule> schedulesST = new RedBlackBST<>();

  // Lista de ScheduleAccompaniment pela Teacher - chave é data
  public RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentsST = new RedBlackBST<>();

  /**
   * Super construtor
   * @param id
   * @param name
   * @param email
   */
  public Teacher(Integer id, String name, String email) {
    super(id, name, email);
  }

  /**
   * Metodo
   */
  public void addCourseUnit(CourseUnit c) {
  }

  public CourseUnit removeCourseUnit(Integer id) {
    return null;
  }

  public CourseUnit editCourseUnit(Integer id) {
    return null;
  }

  public CourseUnit searchCourseUnit(Integer id) {return null;}

  public CourseUnit registerCourseUnit(CourseUnit rcu) {
    return null;
  }

  public void addScheduleAccompaniment(ScheduleAccompaniment sa) {
  }

  public ScheduleAccompaniment removeScheduleAccompaniment(Teacher teacher) {
    return null;
  }

  public ScheduleAccompaniment editScheduleAccompaniment(Teacher teacher) {
    return null;
  }

  public ScheduleAccompaniment searchScheduleAccompaniment(Teacher teacher) {return null;}

}