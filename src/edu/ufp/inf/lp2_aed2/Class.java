package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Class {

  /**
   * Atributos
   */
  private Integer id;

  private String name;

  private String type;

  private Teacher teacher;

  private CourseUnit course;

  // Lista de ScheduleClass(Horario turma) pela Class - chave é data
  private RedBlackBST<Date, ScheduleClass> scheduleClassesST = new RedBlackBST<>();

  // Lista de Students do Class - chave é o numberStudent do Student
  private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

  /**
   * Construtor
   * @param id
   * @param name
   * @param type
   * @param teacher
   * @param course
   */
  public Class(Integer id, String name, String type, Teacher teacher, CourseUnit course) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.teacher = teacher;
    this.course = course;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Class{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", teacher=" + teacher +
            ", course=" + course +
            '}';
  }

  public void addScheduleClass(ScheduleClass sc) {
  }

  public ScheduleClass removeScheduleClass(Class c) {
    return null;
  }

  public ScheduleClass editScheduleClass(Class c) {
    return null;
  }

  public ScheduleClass searchScheduleClass(Class c) {
    return null;
  }


  /**
   * Get's e Set's
   */
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public CourseUnit getCourse() {
    return course;
  }

  public void setCourse(CourseUnit course) {
    this.course = course;
  }

  public RedBlackBST<Date, ScheduleClass> getScheduleClassesST() {
    return scheduleClassesST;
  }

  public void setScheduleClassesST(RedBlackBST<Date, ScheduleClass> scheduleClassesST) {
    this.scheduleClassesST = scheduleClassesST;
  }

  public SeparateChainingHashST<Integer, Student> getStudentsST() {
    return studentsST;
  }

  public void setStudentsST(SeparateChainingHashST<Integer, Student> studentsST) {
    this.studentsST = studentsST;
  }
}