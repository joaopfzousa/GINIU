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

  //Metodos

  /**
   * Adicionar uma ScheduleClass
   * @param sc ScheduleClass para adicionar na ST
   */
  public void addScheduleClass(ScheduleClass sc)
  {
    if(this.scheduleClassesST.contains(sc.getStartDate()))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);

        if(scheduleClass.getClass().equals(sc.getClasse()))
        {
          System.out.println("Class - addScheduleClass(): ScheduleClass already exists!!!");
          return;
        }
      }
    }
    this.scheduleClassesST.put(sc.getStartDate(), sc);
  }

  /**
   * Remover uma ScheduleClass da ST
   * @param startDate
   * @param c
   * @return ScheduleClass eliminada
   */
  public ScheduleClass removeScheduleClass(Date startDate, Class c)
  {
    if(this.scheduleClassesST.contains(startDate))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);

        if(scheduleClass.getClass().equals(c))
        {
          this.scheduleClassesST.delete(startDate);
          return scheduleClass;
        }
      }
    }

    System.out.println("Class - removeScheduleClass(): ScheduleClass not exists!!!");
    return null;
  }

  /**
   * Editar a ScheduleClass
   * @param startDate
   * @param c
   * @return ScheduleClass editada
   */
  public ScheduleClass editScheduleClass(Date startDate, Class c)
  {
    if(this.scheduleClassesST.contains(startDate))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);

        if(scheduleClass.getClass().equals(c))
        {
          Teacher t = new Teacher(6, "André RIBEIRO", "aribeiro@teste.com");
          CourseUnit cu = new CourseUnit(3, "Matemática", 8);
          Class cp = new Class(3,"BGP", "Diurno", t, cu);
          scheduleClass.setClasse(cp);
          Date d = new Date(16, 00, 2);
          scheduleClass.setStartDate(d);
          return scheduleClass;
        }
      }
    }

    System.out.println("Class - editScheduleClass(): ScheduleClass not exists!!!");
    return null;
  }

  /**
   * Procurar uma determinada ScheduleClass
   * @param startDate
   * @param c
   * @return ScheduleClass encontrada
   */
  public ScheduleClass searchScheduleClass(Date startDate, Class c)
  {
    if(this.scheduleClassesST.contains(startDate))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);

        if(scheduleClass.getClass().equals(c))
        {
          return scheduleClass;
        }
      }
    }

    System.out.println("Class - editScheduleClass(): ScheduleClass not exists!!!");
    return null;
  }

  /**
   * Imprimir todas as ScheduleClass
   */
  public void printAllScheduleClass()
  {
    for(Date stdate: this.scheduleClassesST.keys())
    {
      ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);
      System.out.println(scheduleClass);
    }
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