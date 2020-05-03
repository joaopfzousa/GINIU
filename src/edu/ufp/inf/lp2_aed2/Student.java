package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

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
   * toStringFileStudent é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileStudent(){
    return getId() + ";" + getName() + ";" + getEmail() + ";" + numberStudent + ";" + type + ";" ;
  }

  //Metodos


  /**
   * Retornar os horarios de acompanhamento para aquele professor em que o aluno pode ir
   * @param t
   * @return
   */
  public RedBlackBST<Date, ScheduleAccompaniment> searchSaByTeacher(Teacher t)
  {
    RedBlackBST<Date, ScheduleAccompaniment> saST = new RedBlackBST<>();

    for(Date d: t.getScheduleAccompanimentsST().keys())
    {
      ScheduleAccompaniment sa = t.getScheduleAccompanimentsST().get(d);

      for(String name : this.getClassesST().keys())
      {
        Class c = this.getClassesST().get(name);

        for(Date stdate : c.getScheduleClassesST().keys())
        {
          ScheduleClass sC = c.getScheduleClassesST().get(stdate);

          if(sa.getStartDate().compareTo(sC.getStartDate()) == 0)
          {
            saST.put(sa.getStartDate(), sa);
          }
        }
      }
    }
    return saST;
  }

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

  /**
   * Adicionar um Teacher na ST
   * @param t Teacher para adicionar a ST
   */
  public void addTeacher(Teacher t)
  {
    if(this.teachersST.contains(t.getEmail()))
    {
      System.out.println("University - addTeacher(): Teacher already exists!!!");
      return;
    }
    this.teachersST.put(t.getEmail(), t);
  }

  /**
   * Procurar o acompanhamento de um determinado professor
   * @param email
   * @return RedBlackBST ScheduleAccompaniment
   */
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

  public Class registerCourseUnit(CourseUnit cu)
  {
    SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();
    classesST = cu.getClassesST();

    for (String name : classesST.keys())
    {
      Class c = classesST.get(name);

      if(this.getType().equals(c.getType()))
      {
        c.addStudent(this);
        this.addClass(c);

        Teacher t = c.getTeacher();
        this.getTeachersST().put(t.getEmail(), t);

        return c;
      }
    }
    System.out.println("[Student] - registerCourseUnit(): Dont existe Class for this CourseUnit!!!");
    return null;
  }

  /**
   * Carregar o ficheiro txt do StudentCourse
   * @param u
   * @param path
   */
  public static void loadStudentCourse(University u,  String path)
  {
    In in = new In(path);

    while(!in.isEmpty()) {
      String[] split = in.readLine().split(";");
      int numberStudent = Integer.parseInt(split[0]);
      boolean validStudent = u.validStudent(numberStudent);
      int id = Integer.parseInt(split[1]);
      boolean validCourseUnit = u.validCourseUnit(id);

      if(validStudent && validCourseUnit)
      {
        Student s = u.searchStudent(numberStudent);
        CourseUnit cu = u.searchCourseUnit(id);

        s.registerCourseUnit(cu);
      }else{
        System.out.println("[Student] - loadStudentCourse(): This Student or CourseUnit not exists!!!");
      }
    }
  }

  /**
   * Guardar no ficheiro txt da classe StudentCourse
   * @param u
   * @param path
   * @return
   */
  public static void saveStudentCourse(University u, String path){
    Out o = new Out(path);
    for(Integer numberStudent : u.getStudentsST().keys()){
      Student s = u.getStudentsST().get(numberStudent);
      for(String name : s.getClassesST().keys()){
        Class cl = s.classesST.get(name);
        Integer idCourse = cl.getCourse().getId();
        o.println(s.getNumberStudent() + ";" + idCourse);
      }
    }
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