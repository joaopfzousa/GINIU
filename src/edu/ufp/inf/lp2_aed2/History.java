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

    /**
     * Guarda no historico os professores
     * @param email
     * @param path
     * @return
     */
    public String archiveTeacher(String email, String path){
        Out o = new Out(path);
        for(String emailaux : teachersST.keys()){
            Teacher t = teachersST.get(emailaux);
            if(t.getEmail().equals(email)){
                o.println(t.toStringFileTeacher());
            }
        }
        return "Saved teacher's history" + email + "successfully";
    }

    /**
     * Guarda no historico os alunos
     * @param numberStudent
     * @param path
     * @return
     */
    public String archiveStudent(Integer numberStudent, String path){
        Out o = new Out(path);
        for(Integer numberaux : studentsST.keys()){
            Student s = studentsST.get(numberaux);
            if(s.getNumberStudent().equals(numberStudent)){
                o.println(s.toStringFileStudent());
            }
        }
        return "Saved student's history" + numberStudent + "successfully";
    }

    /**
     * Guarda no historico as salas
     * @param numberRoom
     * @param path
     * @return
     */
    public String archiveRoom(String numberRoom, String path){
        Out o = new Out(path);
        for(String numberraux : roomST.keys()){
            Room r = roomST.get(numberraux);
            if(r.getNumberRoom().equals(numberRoom)){
                o.println(r.toStringFileRoom());
            }
        }
        return "Saved room's history" + numberRoom + "successfully";
    }

    /**
     * Guarda no historico as disciplinas
     * @param id
     * @param path
     * @return
     */
    public String archiveCourseUnit(Integer id, String path){
        Out o = new Out(path);
        for(Integer idaux : courseUnitsST.keys()){
            CourseUnit cu = courseUnitsST.get(idaux);
            if(cu.getId().equals(id)){
                o.println(cu.toStringFileCourseUnit());
            }
        }
        return "Saved course unit's history" + id + "successfully";
    }

    /**
     * Guarda no historico as turmas
     * @param name
     * @param path
     * @return
     */
    public String archiveClass(String name, String path){
        Out o = new Out(path);
        for(String nameaux : classesST.keys()){
            Class cl = classesST.get(nameaux);
            if(cl.getName().equals(name)){
                o.println(cl.toStringFileClass());
            }
        }
        return "Saved class's history" + name + "successfully";
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
}
