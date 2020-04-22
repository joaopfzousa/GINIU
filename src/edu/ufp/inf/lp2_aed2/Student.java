package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.ArrayList;

public class Student extends Person {
  /**
   * Atributos
   */
  private Integer numberStudent;

  private String type;

  // Lista de Teacher do CourseUnit - chave é o email do Teacher
  private SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Class pela Student - chave é nome da Class
  private RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  /**
   * Construtor
   * @param id
   * @param name
   * @param email
   * @param numberStudent
   */
  public Student(Integer id, String name, String email, Integer numberStudent, String type) {
    super(id, name, email);
    this.numberStudent = numberStudent;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Student{" + super.toString() +
            ", numberStudent=" + numberStudent +
            ", type='" + type + '\'' +
            '}';
  }

  /**
   * Metodos
   */

  /**
   * Adicionar uma Class na ST
   * @param c Class para adicionar na ST
   */
  public void addClass(Class c)
  {
    if(this.classesST.contains(c.getName()))
    {
      System.out.println("CourseUnit - addClass(): Class already exists!!!");
      return;
    }
    this.classesST.put(c.getName(), c);
  }

  public RedBlackBST<Date, ScheduleAccompaniment> searchAccompaniment(String email)
  {
   RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentST = new RedBlackBST<>();

    Teacher t = this.teachersST.get(email);

    if(t != null)
    {
      scheduleAccompanimentST = t.getScheduleAccompanimentsST();
      return scheduleAccompanimentST;
    }
    System.out.println("Student - searchAccompaniment() - this teacher not exists!!!");
    return null;
  }

  public boolean markAccompaniment(String email,Date startDate,Date finalDate)
  {
      RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentST = searchAccompaniment(email);

      for(Date stdate: scheduleAccompanimentST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = scheduleAccompanimentST.get(stdate);

        if(startDate.getDayOfWeekInt() > scheduleAccompaniment.getStartDate().getDayOfWeekInt() )
        {
          System.out.println("[Student] - markAccompaniment(): Teacher dont have ScheduleAccompaniment in this startDate");
          return false;
        }
      }
    // exception - se o aluno tiver aulas no horario / se o professor nao tenho horario de atendimento;
    return false;
  }

  public Class registerCourseUnit(CourseUnit rcu)
  {
    SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
    classesST = rcu.getClassesST();

    for (String name : classesST.keys())
    {
      Class c = classesST.get(name);

      if(this.getType().equals(c.getType()))
      {
        c.addStudent(this);
        this.addClass(c);
        return c;
      }
    }
    System.out.println("[Student] - registerCourseUnit(): Dont existe Class for this CourseUnit!!!");
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SeparateChainingHashST<String, Teacher> getTeachersST() {
    return teachersST;
  }

  public void setTeachersST(SeparateChainingHashST<String, Teacher> teachersST) {
    this.teachersST = teachersST;
  }

  public RedBlackBST<String, Class> getClassesST() {
    return classesST;
  }

  public void setClassesST(RedBlackBST<String, Class> classesST) {
    this.classesST = classesST;
  }
}