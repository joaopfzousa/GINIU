package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Schedule {

  public Date startDate;

  public Date finalDate;

  public Room room;

  // Lista de Teacher do CourseUnit - chave é o id do Teacher(id Person)
  public SeparateChainingHashST<Integer, Teacher> teachersST = new SeparateChainingHashST<>();
}