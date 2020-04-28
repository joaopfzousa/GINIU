package edu.ufp.inf.lp2_aed2;


import edu.princeton.cs.algs4.SeparateChainingHashST;

public class CourseUnit {
  /**
   * Atributos
   */
  private Integer id;

  private String name;

  private Integer ects;

  // Lista de Classes do CourseUnit - chave é o nome da Class
  private SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();

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

  /**
   * toStringFileCourseUnit é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileCourseUnit(){
    return id + ";" + name + ";" + ects + ";" ;
  }

  //Metodos

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
   * Valida se a Class existe na ST
   * @param name
   * @return true se existir, false se não existir
   */
  public boolean validClass(String name)
  {
    for(String n: this.classesST.keys())
    {
      Class c = this.classesST.get(n);

      if(c.getName().equals(name))
      {
        return true;
      }
    }
    return false;
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

  public SeparateChainingHashST<String, Class> getClassesST() {
    return classesST;
  }

  public void setClassesST(SeparateChainingHashST<String, Class> classesST) {
    this.classesST = classesST;
  }
}