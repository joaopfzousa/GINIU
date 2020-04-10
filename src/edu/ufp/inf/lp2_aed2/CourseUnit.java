package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class CourseUnit {
  /**
   * Atributos
   */
  private Integer id;

  private String name;

  private Integer ects;

  // Lista de Teacher do CourseUnit - chave é o email do Teacher(email Person)
  private SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

  // Lista de Students do CourseUnit - chave é o numberStudent do Student
  private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

  // Lista de Classes do CourseUnit - chave é o nome da Class
  private RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  /**
   * Construtor
   * @param id
   * @param name
   * @param ects
   */
  public CourseUnit(Integer id, String name, Integer ects) {
    this.id = id;
    this.name = name;
    this.ects = ects;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "CourseUnit{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", ects=" + ects +
            '}';
  }

  //Metodos

  /**
   * Adicionar um Teacher na ST
   * @param t Teacher para adicionar a ST
   */
  public void addTeacher(Teacher t)
  {
    if(this.teachersST.contains(t.getEmail()))
    {
      System.out.println("CourseUnit - addTeacher(): Teacher already exists!!!");
      return;
    }
    this.teachersST.put(t.getEmail(), t);
  }

  /**
   * Remover uma Teacher da ST
   * @param email
   * @return o Teacher eliminado
   */
  public Teacher removeTeacher(String email)
  {
    Teacher t = this.teachersST.get(email);

    if(t != null)
    {
      this.teachersST.delete(email);
      return t;
    }
    System.out.println("CourseUnit - removeTeacher(): Teacher not exists!!!");
    return null;
  }

  /**
   * Editar o Teacher
   * @param email
   * @return Teacher
   */
  public Teacher editTeacher(String email)
  {
    if(this.teachersST.contains(email))
    {
      Teacher t = this.teachersST.get(email);

      t.setName("Beatriz Gomes");

      return t;
    }

    System.out.println("CourseUnit - editTeacher(): email not exist inside teachersST");
    return null;
  }

  /**
   * Procurar um determinado Teacher na ST
   * @param email
   * @return Teacher encontrado
   */
  public Teacher searchTeacher(String email)
  {
    if(this.teachersST.contains(email))
    {
      Teacher t = this.teachersST.get(email);
      return t;
    }

    System.out.println("CourseUnit - searchTeacher(): Id not exist inside teachersST");
    return null;
  }

  /**
   * Imprimir todos os Teacher
   */
  public void printAllTeacher()
  {
    for(String tKey: this.teachersST.keys())
    {
      Teacher t = this.teachersST.get(tKey);
      System.out.println(t);
    }
  }

  /**
   * Adicionar um Student na ST
   * @param s Student para adicionar na ST
   */
  public void addStudent(Student s)
  {
    if(this.studentsST.contains(s.getNumberStudent())){
      System.out.println("CourseUnit - addStudent(): Student already exists!!!");
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

    System.out.println("CourseUnit - removeStudent(): Student not exists!!!");
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

    System.out.println("CourseUnit - editStudent(): numberStudent not exist inside studentsST");
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

    System.out.println("CourseUnit - searchStudent(): numberStudent not exist inside studentsST");
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
   * Remover uma Class da ST
   * @param name
   * @return a Class eliminado
   */
  public Class removeClass(String name)
  {
    Class c = this.classesST.get(name);

    if(c != null)
    {
      this.classesST.delete(name);
      return c;
    }
    System.out.println("CourseUnit - removeClass(): Class not exists!!!");
    return null;
  }

  /**
   * Editar a Class
   * @param name
   * @return Class editada
   */
  public Class editClass(String name)
  {
    if(this.classesST.contains(name))
    {
      Class c = this.classesST.get(name);
      CourseUnit cu = new CourseUnit(1, "LP", 10);
      Teacher t = new Teacher(5, "Rui Moreira", "moreira@teste.com");

      c.setCourse(cu);
      c.setName("BLE");
      c.setTeacher(t);
      c.setType("Noturno");
      return c;
    }

    System.out.println("CourseUnit - editClass(): name not exist inside classesST");
    return null;
  }

  /**
   * Procurar um determinada Class na ST
   * @param name
   * @return Class encontrada
   */
  public Class searchClass(String name)
  {
    if(this.classesST.contains(name))
    {
      Class c = this.classesST.get(name);
      return c;
    }

    System.out.println("CourseUnit - searchClass(): name not exist inside classesST");
    return null;
  }

  /**
   * Imprimir todas as Class
   */
  public void printAllClass()
  {
    for(String cKey: this.classesST.keys())
    {
      Class c = this.classesST.get(cKey);
      System.out.println(c);
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

  public Integer getEcts() {
    return ects;
  }

  public void setEcts(Integer ects) {
    this.ects = ects;
  }

  public SeparateChainingHashST<String, Teacher> getTeachersST() {
    return teachersST;
  }

  public void setTeachersST(SeparateChainingHashST<String, Teacher> teachersST) {
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