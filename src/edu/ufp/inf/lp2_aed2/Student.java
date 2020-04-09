package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.ArrayList;

public class Student extends Person {

  public Integer numberStudent;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  public SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Class pela Student - chave é nome da Class
  public RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  public ArrayList<ScheduleAccompaniment> searchAccompaniment(Teacher email) {
  return null;
  }

  public boolean markAccompaniment(Teacher email,Date startDate,Date finalDate) {
  return false;
  }

  public CourseUnit registerCourseUnit(CourseUnit rcu) {
  return null;
  }
}