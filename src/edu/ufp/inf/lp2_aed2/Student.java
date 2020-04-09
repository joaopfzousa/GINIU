package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.ArrayList;

public class Student extends Person {

  /**
   * Atributos
   */
  private Integer numberStudent;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  private SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Class pela Student - chave é nome da Class
  private RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  /**
   * Construtor
   * @param id
   * @param name
   * @param email
   * @param numberStudent
   */
  public Student(Integer id, String name, String email, Integer numberStudent) {
    super(id, name, email);
    this.numberStudent = numberStudent;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Student{" +
            "numberStudent=" + numberStudent +
            '}';
  }

  /**
   * Metodos
   */
  public ArrayList<ScheduleAccompaniment> searchAccompaniment(Teacher email) {
  return null;
  }

  public boolean markAccompaniment(Teacher email,Date startDate,Date finalDate) {
  return false;
  }

  public CourseUnit registerCourseUnit(CourseUnit rcu) {
  return null;
  }

  /**
   * Get's e Set's
   */
  public Integer getNumberStudent() {
    return numberStudent;
  }

  public void setNumberStudent(Integer numberStudent) {
    this.numberStudent = numberStudent;
  }

  public SeparateChainingHashST<Integer, Teacher> getTeachersST() {
    return teachersST;
  }

  public void setTeachersST(SeparateChainingHashST<Integer, Teacher> teachersST) {
    this.teachersST = teachersST;
  }

  public RedBlackBST<String, Class> getClassesST() {
    return classesST;
  }

  public void setClassesST(RedBlackBST<String, Class> classesST) {
    this.classesST = classesST;
  }
}