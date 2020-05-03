package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.Out;
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
     * @param t
     */
    public void archiveTeacher(Teacher t){

        if(this.teachersST.contains(t.toStringFileTeacher()))
        {
            System.out.println("History - archiveTeacher(): Teacher already add on archive!!!");
            return;
        }
        this.teachersST.put(t.toStringFileTeacher(),t);
    }

    /**
     * Guarda no historico os estudantes
     * @param s
     */
    public void archiveStudent(Student s){

        if(this.studentsST.contains(Integer.valueOf(s.toStringFileStudent())))
        {
            System.out.println("History - archiveStudent(): Student already add on archive!!!");
            return;
        }
        this.studentsST.put(Integer.valueOf(s.toStringFileStudent()),s);
    }

    /**
     * Guarda no historico as salas
     * @param r
     */
    public void archiveRoom(Room r){

        if(this.roomST.contains(r.toStringFileRoom()))
        {
            System.out.println("History - archiveRoom(): Room already add on archive!!!");
            return;
        }
        this.roomST.put(r.toStringFileRoom(),r);
    }

    /**
     * Guarda no historico as disciplinas
     * @param cu
     */
    public void archiveCourse(CourseUnit cu){

        if(this.courseUnitsST.contains(Integer.valueOf(cu.toStringFileCourseUnit())))
        {
            System.out.println("History - archiveCourse(): Course already add on archive!!!");
            return;
        }
        this.courseUnitsST.put(Integer.valueOf(cu.toStringFileCourseUnit()),cu);
    }

    /**
     * Guarda no historico as turmas
     * @param cl
     */
    public void archiveClass(Class cl){

        if(this.classesST.contains(cl.toStringFileClass()))
        {
            System.out.println("History - archiveClass(): Class already add on archive!!!");
            return;
        }
        this.classesST.put(cl.toStringFileClass(),cl);
    }

    /**
     * guarda no historico os horarios atendimento
     * @param sa
     */
    public void archiveScheduleAccompaniment (ScheduleAccompaniment sa){

        if(this.scheduleAccompanimentsST.contains(sa.toStringFileScheduleAccompaniment()))
        {
            
            System.out.println("History - archiveScheduleAccompaniment(): ScheduleAccompaniment already add on archive!!!");
            return;
        }
        this.scheduleAccompanimentsST.put(sa.toStringFileScheduleAccompaniment(),sa);
    }

    /**
     * Guarda no historico os horarios das turmas
     * @param sc
     */
    public void archiveScheduleClass(ScheduleClass sc){

        if(this.schedulesClassST.contains(sc.toStringFileScheduleClass()))
        {
            System.out.println("History - archiveScheduleClass(): ScheduleClass already add on archive!!!");
            return;
        }
        this.schedulesClassST.put(sc.toStringFileScheduleClass(),sc);
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

