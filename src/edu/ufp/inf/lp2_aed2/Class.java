package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Class {

  public Integer id;

  public String name;

  public String type;

  public Teacher teacher;

  public CourseUnit course;

  // Lista de ScheduleClass(Horario turma) pela Class - chave é data
  public RedBlackBST<Date, ScheduleClass> scheduleClassesST = new RedBlackBST<>();

  // Lista de Students do Class - chave é o numberStudent do Student
  public SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();
}