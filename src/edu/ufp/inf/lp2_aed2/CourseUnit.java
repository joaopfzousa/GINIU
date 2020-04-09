package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class CourseUnit {

  private Integer id;

  private String name;

  private Integer ects;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  private SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Students do CourseUnit - chave é o numberStudent do Student
  private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

  // Lista de Classes do CourseUnit - chave é o nome da Class
  private RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  public CourseUnit(Integer id, String name, Integer ects) {
    this.id = id;
    this.name = name;
    this.ects = ects;
  }

  @Override
  public String toString() {
    return "CourseUnit{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", ects=" + ects +
            '}';
  }

  public void addCourse(CourseUnit c) {
  }

  public CourseUnit removeCourse(Integer id) {
  return null;
  }

  public CourseUnit editCourse(Integer id) {
  return null;
  }

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

  public Integer getEcts() {
    return ects;
  }

  public void setEcts(Integer ects) {
    this.ects = ects;
  }

  public SeparateChainingHashST<Integer, Teacher> getTeachersST() {
    return teachersST;
  }

  public void setTeachersST(SeparateChainingHashST<Integer, Teacher> teachersST) {
    this.teachersST = teachersST;
  }

  public SeparateChainingHashST<Integer, Student> getStudentsST() {
    return studentsST;
  }

  public void setStudentsST(SeparateChainingHashST<Integer, Student> studentsST) {
    this.studentsST = studentsST;
  }

  public RedBlackBST<String, Class> getClassesST() {
    return classesST;
  }

  public void setClassesST(RedBlackBST<String, Class> classesST) {
    this.classesST = classesST;
  }
}