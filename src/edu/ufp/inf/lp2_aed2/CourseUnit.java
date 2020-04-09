package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class CourseUnit {

  public Integer id;

  public String name;

  public Integer ects;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  public SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Students do CourseUnit - chave é o numberStudent do Student
  public SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

  // Lista de Classes do CourseUnit - chave é o nome da Class
  private RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  public void addCourse(CourseUnit c) {
  }

  public CourseUnit removeCourse(Integer id) {
  return null;
  }

  public CourseUnit editCourse(Integer id) {
  return null;
  }
}