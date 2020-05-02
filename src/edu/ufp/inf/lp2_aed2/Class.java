package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Scanner;

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

  /**
   * toStringFileClass é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileClass(){
    return id + ";" + name + ";" + type + ";" + getTeacher().getEmail() + ";" + getCourse().getId() + ";" ;
  }

  //Metodos
  /**
   * Adicionar um Student na ST
   * @param s Student para adicionar na ST
   */
  public void addStudent(Student s)
  {
    if(this.studentsST.contains(s.getNumberStudent())){
      System.out.println("Class - addStudent(): Student already exists!!!");
      return;
    }
    this.studentsST.put(s.getNumberStudent(), s);
  }

  /**
   * Remover um Student da ST
   * @param numberStudent
   * @return o Student eliminado
   */
  public Student removeStudent(Integer numberStudent)
  {
    Student s = this.studentsST.get(numberStudent);

    if(s != null)
    {
      this.studentsST.delete(numberStudent);
      return s;
    }

    System.out.println("Class - removeStudent(): Student not exists!!!");
    return null;
  }

  /**
   * Editar o Student
   * @param numberStudent
   * @return Student editado
   */
  public Student editStudent(Integer numberStudent)
  {
    if(this.studentsST.contains(numberStudent))
    {
      Student s = this.studentsST.get(numberStudent);

      s.setName("João Sousa");
      return s;
    }

    System.out.println("Class - editStudent(): numberStudent not exist inside studentsST");
    return null;
  }

  /**
   * Procurar um determinado Student na ST
   * @param numberStudent
   * @return Student encontrado
   */
  public Student searchStudent(Integer numberStudent)
  {
    if(this.studentsST.contains(numberStudent))
    {
      Student s = this.studentsST.get(numberStudent);

      return s;
    }

    System.out.println("Class - searchStudent(): numberStudent not exist inside studentsST");
    return null;
  }

  /**
   * Imprimir todos os Student
   */
  public void printAllStudent()
  {
    for(Integer cKey: this.studentsST.keys())
    {
      Student s = this.studentsST.get(cKey);
      System.out.println(s);
    }
  }

  /**
   * Validar se exist Student na st
   * @param numberStudent
   * @return true se existir, false se não existir
   */
  public boolean validStudent(Integer numberStudent)
  {
    for(Integer number: this.studentsST.keys())
    {
      Student s = this.studentsST.get(number);

      if(s.getNumberStudent().equals(numberStudent))
      {
        return true;
      }
    }
    return false;
  }

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
        Class c = scheduleClass.getClasse();
        Class c2 = sc.getClasse();

        if(c.getName().equals(c2.getName()))
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
   * @return ScheduleClass eliminada
   */
  public ScheduleClass removeScheduleClass(Date startDate)
  {
    if(this.scheduleClassesST.contains(startDate))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass sc = this.scheduleClassesST.get(stdate);
        Class cla = sc.getClasse();

        this.scheduleClassesST.delete(startDate);
        return sc;

      }
    }

    System.out.println("Class - removeScheduleClass(): ScheduleClass not exists!!!");
    return null;
  }

  /**
   * Editar a ScheduleClass
   * @param startDate
   * @return ScheduleClass editada
   */
  public ScheduleClass editScheduleClass(University u, Date startDate)
  {
    ScheduleClass sc = searchScheduleClass(startDate);
    if (sc != null)
    {
      Scanner sca = new Scanner(System.in);
      String op;
      do {
        System.out.println("\t\t -----> Editar ScheduleClass <-----\n");
        System.out.println(" [1] -> Alterar Data Final");
        System.out.println(" [2] -> Alterar Sala");
        System.out.println(" [V] -> SAIR\n");
        System.out.println("OP: ");
        op = sca.nextLine();
        switch (op) {
          case "1":
            System.out.println("Alterar Data Final (Dia da semana/hora/minutos): ");
            String data = sca.nextLine();

            String[] split =  data.split("/");
            int dayOfWeek = Integer.parseInt(split[0]);
            int hour = Integer.parseInt(split[1]);
            int min = Integer.parseInt(split[2]);
            Date finalDate = new Date(hour, min, dayOfWeek);
            sc.setFinalDate(finalDate);
            break;
          case "2":
            u.printAllClass();
            System.out.println("Escolha um nome: ");
            String nome = sca.nextLine();
            Class c = u.getClassesST().get(nome);
            sc.setClasse(c);
            break;
          case "v":
          case "V":
            break;
          default:
            System.out.println("Opcao Errada!!!\n");
        }
      } while (!"v".equals(op) && !"V".equals(op));

      return sc;
    }
    System.out.println("Class - editScheduleClass(): ScheduleClass not exists!!!");
    return null;
  }

  /**
   * Procurar uma determinada ScheduleClass
   * @param startDate
   * @return ScheduleClass encontrada
   */
  public ScheduleClass searchScheduleClass(Date startDate)
  {
    if(this.scheduleClassesST.contains(startDate))
    {
      for(Date stdate: this.scheduleClassesST.keys())
      {
        ScheduleClass scheduleClass = this.scheduleClassesST.get(stdate);

        return scheduleClass;
      }
    }

    System.out.println("Class - searchScheduleClass(): ScheduleClass not exists!!!");
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
   * Valida se o ScheduleClass existe na ST
   * @param startDate
   * @param c
   * @return true se exister, false se não existir
   */
  public boolean validScheduleClass(Date startDate, Class c)
  {
    for(Date stDate: this.scheduleClassesST.keys())
    {
      ScheduleClass sc = this.scheduleClassesST.get(stDate);
      Class c2 = sc.getClasse();

      if(c2.getName().equals(c.getName()))
      {
        return true;
      }
    }
    return false;
  }

  public static void loadScheduleClass(University u, String path)
  {
    In in = new In(path);

    while(!in.isEmpty()){
      String[] split = in.readLine().split(";");
      String[] split2 =  split[0].split("/");
      int stdayOfWeek = Integer.parseInt(split2[0]);
      int sthour = Integer.parseInt(split2[1]);
      int stmin = Integer.parseInt(split2[2]);
      Date stdate = new Date(sthour, stmin, stdayOfWeek);

      String[] split3 =  split[1].split("/");
      int fldayOfWeek = Integer.parseInt(split3[0]);
      int flhour = Integer.parseInt(split3[1]);
      int flmin = Integer.parseInt(split3[2]);
      Date fldate = new Date(flhour, flmin, fldayOfWeek);

      String numberRoom = split[2];
      boolean validRoom = u.validRoom(numberRoom);

      String name = split[3];
      boolean validClass = u.validClass(name);

      if(validRoom && validClass)
      {
        Room r = u.searchRoom(numberRoom);
        Class cl = u.searchClass(name);

        ScheduleClass sc = new ScheduleClass(stdate, fldate, r, cl);
        r.getScheduleClassesST().put(stdate, sc);
        cl.scheduleClassesST.put(stdate, sc);
        Teacher t = cl.getTeacher();
        t.addScheduleClass(sc);
      }else{
        System.out.println("[Class] - loadScheduleClass(): This Room or Class not exists!!!");
      }
    }
  }

  /**
   * Guardar no ficheiro txt da classe ScheduleClass
   * @param path
   * @return
   */
  public static void saveScheduleClass(University u, String path){
    Out o = new Out(path);

    for(String name : u.getClassesST().keys()){
      Class cl = u.getClassesST().get(name);
      for(Date stdate : cl.scheduleClassesST.keys()){
        ScheduleClass sc = cl.scheduleClassesST.get(stdate);
        o.println(sc.toStringFileScheduleClass());
      }
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