package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Teacher extends Person {
  /**
   * Atributos
   */
  // Lista de CourseUnit do Teacher - chave é o id do CourseUnit
  public SeparateChainingHashST<Integer, CourseUnit> courseUnitsST = new SeparateChainingHashST<>();

  // Lista de Class pela Teacher - chave é nome da Class
  public RedBlackBST<String, Class> classesST = new RedBlackBST<>();

  // Lista de Schedule pela Teacher - chave é data
  public RedBlackBST<Date, ScheduleClass> schedulesClassST = new RedBlackBST<>();

  // Lista de ScheduleAccompaniment pela Teacher - chave é data
  public RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentsST = new RedBlackBST<>();

  /**
   * Super construtor
   * @param id
   * @param name
   * @param email
   */
  public Teacher(Integer id, String name, String email) {
    super(id, name, email);
  }

  /**
   * toStringFileTeacher é o toString para guardar o ficheiro
   * @return
   */
  public String toStringFileTeacher(){
    return  getId() + ";" + getName() + ";" + getEmail() + ";" ;
  }

  // Metodos

  /**
   * Adicionar uma ScheduleClass
   * @param sc ScheduleClass para adicionar na ST
   */
  public void addScheduleClass(ScheduleClass sc)
  {
    if(this.schedulesClassST.contains(sc.getStartDate()))
    {
      for(Date stdate: this.schedulesClassST.keys())
      {
        ScheduleClass scheduleClass = this.schedulesClassST.get(stdate);
        Class c = scheduleClass.getClasse();
        Class c2 = sc.getClasse();

        if(c.getName().equals(c2.getName()))
        {
          System.out.println("Class - addScheduleClass(): ScheduleClass already exists!!!");
          return;
        }
      }
    }
    this.schedulesClassST.put(sc.getStartDate(), sc);
  }

  /**
   * Adicionar um CourseUnit na ST
   * @param c CourseUnit para adicionar a ST
   */
  public void addCourseUnit(CourseUnit c)
  {
    if(this.courseUnitsST.contains(c.getId())){
      System.out.println("Teacher - addCourseUnit(): CourseUnit already exists!!!");
      return;
    }
    this.courseUnitsST.put(c.getId(), c);
  }

  /**
   * Remover uma CourseUnit da ST
   * @param id
   * @return o CourseUnit eliminado
   */
  public CourseUnit removeCourseUnit(Integer id)
  {
    CourseUnit cu = this.courseUnitsST.get(id);

    if(cu != null)
    {
      this.courseUnitsST.delete(id);
      return cu;
    }
    System.out.println("Teacher - removeCourseUnit(): CourseUnit not exists!!!");
    return null;
  }

  /**
   * Editar o CourseUnit
   * @param id
   * @return CourseUnit editado
   */
  public CourseUnit editCourseUnit(Integer id)
  {
    if(this.courseUnitsST.contains(id))
    {
      CourseUnit cu = this.courseUnitsST.get(id);

      cu.setName("LP3");
      cu.setEcts(9);
      return cu;
    }

    System.out.println("Teacher - editCourseUnit(): Id not exist inside CourseUnitsST");
    return null;
  }

  /**
   * Procurar um determinado CourseUnit na ST
   * @param id
   * @return CourseUnit encontrado
   */
  public CourseUnit searchCourseUnit(Integer id)
  {
    if(this.courseUnitsST.contains(id))
    {
      CourseUnit cu = this.courseUnitsST.get(id);
      return cu;
    }

    System.out.println("Teacher - searchCourseUnit(): Id not exist inside CourseUnitsST");
    return null;
  }

  /**
   * Imprimir todos os CourseUnit
   */
  public void printAllCourseUnit()
  {
    for(Integer cKey: this.courseUnitsST.keys())
    {
      CourseUnit cu = this.courseUnitsST.get(cKey);
      System.out.println(cu);
    }
  }

  /**
   * Valida se existe CourseUnit
   * @param id
   * @return true se exitir, false se não existir
   */
  public boolean validCourseUnit(Integer id)
  {
    for(Integer i: this.courseUnitsST.keys())
    {
      CourseUnit cu = this.courseUnitsST.get(i);

      if(cu.getId().equals(id))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Adicionar ScheduleAccompaniment
   * @param sa
   */
  public void addScheduleAccompaniment(ScheduleAccompaniment sa)
  {
    if(this.scheduleAccompanimentsST.contains(sa.getStartDate()))
    {
      for(Date stdate: this.scheduleAccompanimentsST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
        Teacher t = scheduleAccompaniment.getTeacher();
        Teacher t2 = sa.getTeacher();

        if(t.getEmail().equals(t2.getEmail()))
        {
          System.out.println("Teacher - addScheduleAccompaniment(): ScheduleAccompaniment already exists!!!");
          return;
        }
      }
    }
    this.scheduleAccompanimentsST.put(sa.getStartDate(), sa);
  }

  /**
   * Remover uma ScheduleAccompaniment da ST
   * @param teacher
   * @param startDate
   * @return ScheduleAccompaniment eliminada
   */
  public ScheduleAccompaniment removeScheduleAccompaniment(Teacher teacher, Date startDate)
  {
    if(this.scheduleAccompanimentsST.contains(startDate))
    {
      for(Date stdate: this.scheduleAccompanimentsST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
        Teacher t = scheduleAccompaniment.getTeacher();

        if(t.getEmail().equals(teacher.getEmail()))
        {
          this.scheduleAccompanimentsST.delete(startDate);
          return scheduleAccompaniment;
        }
      }
    }
    System.out.println("Teacher - removeScheduleAccompaniment(): ScheduleAccompaniment not exists!!!");
    return null;
  }

  /**
   * Editar o ScheduleAccompaniment
   * @param teacher
   * @param startDate
   * @return ScheduleAccompaniment editada
   */
  public ScheduleAccompaniment editScheduleAccompaniment(Teacher teacher, Date startDate)
  {
    if(this.scheduleAccompanimentsST.contains(startDate))
    {
      for (Date stdate : this.scheduleAccompanimentsST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
        Teacher t = scheduleAccompaniment.getTeacher();

        if(t.getEmail().equals(teacher.getEmail()))
        {
          Room r = new Room(1, 1,"104",true,200);
          Date d = new Date(17,00,3);
          scheduleAccompaniment.setFinalDate(d);
          scheduleAccompaniment.setRoom(r);
          return scheduleAccompaniment;
        }
      }
    }
    System.out.println("Teacher - editScheduleAccompaniment(): ScheduleAccompaniment not exists!!!");
    return null;
  }

  /**
   * Procurar uma determinada ScheduleAccompaniment
   * @param teacher
   * @param startDate
   * @return ScheduleAccompaniment encontrada
   */
  public ScheduleAccompaniment searchScheduleAccompaniment(Teacher teacher, Date startDate)
  {
    if(this.scheduleAccompanimentsST.contains(startDate))
    {
      for (Date stdate : this.scheduleAccompanimentsST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
        Teacher t = scheduleAccompaniment.getTeacher();

        if(t.getEmail().equals(teacher.getEmail()))
        {
          return scheduleAccompaniment;
        }
      }
    }
    System.out.println("Teacher - searchScheduleAccompaniment(): ScheduleAccompaniment not exists!!!");
    return null;
  }

  /**
   * Imprimir todas as ScheduleAccompaniment
   */
  public void printAllScheduleAccompaniment()
  {
    for(Date stdate: this.scheduleAccompanimentsST.keys())
    {
      ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
      System.out.println(scheduleAccompaniment);
    }
  }

  /**
   * Valida se ScheduleAccompaniment exite na ST
   * @param teacher
   * @param startDate
   * @return true se existir, false se não existir
   */
  public boolean validScheduleAccompaniment(Teacher teacher, Date startDate)
  {
    if(this.scheduleAccompanimentsST.contains(startDate))
    {
      for (Date stdate : this.scheduleAccompanimentsST.keys())
      {
        ScheduleAccompaniment scheduleAccompaniment = this.scheduleAccompanimentsST.get(stdate);
        Teacher t = scheduleAccompaniment.getTeacher();

        if(t.getEmail().equals(teacher.getEmail()))
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Carregar o ficheiro txt do ScheduleAccompaniment
   * @param u
   * @param path
   */
  public void loadScheduleAccompaniment(University u, String path)
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
      String email = split[3];
      boolean validTeacher = u.validTeacher(email);

      if(validRoom && validTeacher)
      {
        Room r = u.searchRoom(numberRoom);
        Teacher t = u.searchTeacher(email);

        ScheduleAccompaniment sa = new ScheduleAccompaniment(stdate, fldate, r, t);
        r.getScheduleAccompanimentST().put(stdate, sa);
        t.addScheduleAccompaniment(sa);
      }else{
        System.out.println("[Teacher] - loadScheduleAccompaniment(): This Room or Teacher not exists!!!");
      }
    }
  }

  /**
   * Guardar no ficheiro txt da classe ScheduleAccompaniment
   * @param path
   * @return
   */
  public String saveScheduleAccompaniment(String path){
    Out o = new Out(path);
    for(Date stdate : scheduleAccompanimentsST.keys()){
      ScheduleAccompaniment sa = scheduleAccompanimentsST.get(stdate);
      o.println(sa.toStringFileScheduleAccompaniment());
    }
    return "Saved ScheduleAccompaniment on TXT";
  }

  /**
   * Get's e set's
   */

  public SeparateChainingHashST<Integer, CourseUnit> getCourseUnitsST() {
    return courseUnitsST;
  }

  public void setCourseUnitsST(SeparateChainingHashST<Integer, CourseUnit> courseUnitsST) {
    this.courseUnitsST = courseUnitsST;
  }

  public RedBlackBST<String, Class> getClassesST() {
    return classesST;
  }

  public void setClassesST(RedBlackBST<String, Class> classesST) {
    this.classesST = classesST;
  }

  public RedBlackBST<Date, ScheduleClass> getSchedulesST() {
    return schedulesClassST;
  }

  public void setSchedulesST(RedBlackBST<Date, ScheduleClass> schedulesST) {
    this.schedulesClassST = schedulesST;
  }

  public RedBlackBST<Date, ScheduleAccompaniment> getScheduleAccompanimentsST() {
    return scheduleAccompanimentsST;
  }

  public void setScheduleAccompanimentsST(RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentsST) {
    this.scheduleAccompanimentsST = scheduleAccompanimentsST;
  }
}