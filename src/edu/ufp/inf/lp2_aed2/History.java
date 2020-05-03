package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class History {
    /**
     * Atributos
     */
    //Lista de Room da University - chave é o numberRoom do Room
    private RedBlackBST<String, Room> roomST = new RedBlackBST<>();

    // Lista de Teacher da University - chave é o email do Teacher(email Person)
    private SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

    // Lista de Students do University - chave é o numberStudent do Student
    private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

    // Lista de CourseUnit do University - chave é o id do CourseUnit
    private SeparateChainingHashST<Integer, CourseUnit> courseUnitsST = new SeparateChainingHashST<>();

    // Lista de Classes do University - chave é o nome da Class
    private SeparateChainingHashST<String, Class> classesST = new SeparateChainingHashST<>();

    // Lista de Schedule pela Teacher - chave é data
    public RedBlackBST<Date, ScheduleClass> schedulesClassST = new RedBlackBST<>();

    // Lista de ScheduleAccompaniment pela Teacher - chave é data
    public RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentsST = new RedBlackBST<>();


    /**
     * Guarda no historico os professores
     * @param u
     * @param t
     */
    public void archiveTeacher(University u, Teacher t)
    {
        if(u.validTeacher(t.getEmail()))
        {
            if(this.teachersST.contains(t.getEmail()))
            {
                System.out.println("[History] - archiveTeacher(): Teacher already exists in history!");
            }else{
                this.teachersST.put(t.getEmail(), t);
            }
        }
    }

    /**
     * Guarda no historico os estudantes
     * @param u
     * @param s
     */
    public void archiveStudent(University u, Student s)
    {
        if(u.validStudent(s.getNumberStudent()))
        {
            if(this.studentsST.contains(s.getNumberStudent()))
            {
                System.out.println("[History] - archiveStudent(): Student already exists in history!");
            }else{
                this.studentsST.put(s.getNumberStudent(), s);
            }
        }
    }

    /**
     * Guarda no historico as salas
     * @param u
     * @param r
     */
    public void archiveRoom(University u, Room r)
    {
        if(u.validRoom(r.getNumberRoom()))
        {
            if(this.roomST.contains(r.getNumberRoom()))
            {
                System.out.println("[History] - archiveRoom(): Room already exists in history!");
            }else{
                this.roomST.put(r.getNumberRoom(), r);
            }
        }
    }

    /**
     * Guarda no historico as disciplinas
     * @param u
     * @param cu
     */
    public void archiveCourse(University u, CourseUnit cu)
    {
        if(u.validCourseUnit(cu.getId()))
        {
            if(this.courseUnitsST.contains(cu.getId()))
            {
                System.out.println("[History] - archiveCourse(): CourseUnit already exists in history!");
            }else{
                this.courseUnitsST.put(cu.getId(), cu);
            }
        }
    }

    /**
     * Guarda no historico as turmas
     * @param cu
     * @param cl
     */
    public void archiveClass(CourseUnit cu, Class cl)
    {
        if(cu.validClass(cl.getName()))
        {
            if(this.classesST.contains(cl.getName()))
            {
                System.out.println("History - archiveClass(): Class already exists in history!");
            }else{
                this.classesST.put(cl.getName(), cl);
            }
        }
    }

    /**
     * guarda no historico os horarios atendimento
     * @param t
     * @param sa
     */
    public void archiveScheduleAccompaniment (Teacher t, ScheduleAccompaniment sa)
    {
        if(t.validScheduleAccompaniment(sa.getStartDate()))
        {
            if(this.scheduleAccompanimentsST.contains(sa.getStartDate()))
            {
                System.out.println("History - archiveScheduleAccompaniment(): ScheduleAccompaniment already exists in history!");
            }else{
                this.scheduleAccompanimentsST.put(sa.getStartDate(), sa);
            }
        }
    }

    /**
     * Guarda no historico os horarios das turmas
     * @param c
     * @param sc
     */
    public void archiveScheduleClass(Class c, ScheduleClass sc)
    {
        if(c.validScheduleClass(sc.getStartDate()))
        {
            if(this.schedulesClassST.contains(sc.getStartDate())){
                System.out.println("History - archiveScheduleClass(): ScheduleClass already exists in history!");
            }else{
                this.schedulesClassST.put(sc.getStartDate(),sc);
            }
        }
    }

    /**
     * Get's and Set's
     */
    public RedBlackBST<String, Room> getRoomST() {
        return roomST;
    }

    public void setRoomST(RedBlackBST<String, Room> roomST) {
        this.roomST = roomST;
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

    public SeparateChainingHashST<Integer, CourseUnit> getCourseUnitsST() {
        return courseUnitsST;
    }

    public void setCourseUnitsST(SeparateChainingHashST<Integer, CourseUnit> courseUnitsST) {
        this.courseUnitsST = courseUnitsST;
    }

    public SeparateChainingHashST<String, Class> getClassesST() {
        return classesST;
    }

    public void setClassesST(SeparateChainingHashST<String, Class> classesST) {
        this.classesST = classesST;
    }

    public RedBlackBST<Date, ScheduleClass> getSchedulesClassST() {
        return schedulesClassST;
    }

    public void setSchedulesClassST(RedBlackBST<Date, ScheduleClass> schedulesClassST) {
        this.schedulesClassST = schedulesClassST;
    }

    public RedBlackBST<Date, ScheduleAccompaniment> getScheduleAccompanimentsST() {
        return scheduleAccompanimentsST;
    }

    public void setScheduleAccompanimentsST(RedBlackBST<Date, ScheduleAccompaniment> scheduleAccompanimentsST) {
        this.scheduleAccompanimentsST = scheduleAccompanimentsST;
    }
}

