package edu.ufp.inf.lp2_aed2;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class University {

    private String name;

    //Lista de Room da University - chave é o numberRoom do Room
    private RedBlackBST<Integer, Room> roomST = new RedBlackBST<>();

    // Lista de Teacher da University - chave é o email do Teacher(email Person)
    private SeparateChainingHashST<String, Teacher> teachersST = new SeparateChainingHashST<>();

    // Lista de Students do University - chave é o numberStudent do Student
    private SeparateChainingHashST<Integer, Student> studentsST = new SeparateChainingHashST<>();

    // Lista de CourseUnit do University - chave é o id do CourseUnit
    private SeparateChainingHashST<Integer, CourseUnit> courseUnitsST = new SeparateChainingHashST<>();

    public University(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                '}';
    }

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
    public  void printAllTeacher()
    {
        for(String tKey: this.teachersST.keys())
        {
            Teacher t = this.teachersST.get(tKey);
            System.out.println(t);
        }
    }

    /**
     * Validar a Teacher
     * @param email
     * @return true se existir, false se nao existir
     */
    public boolean validTeacher( String email)
    {
        for(String mail: this.teachersST.keys())
        {
            Teacher t = this.teachersST.get(mail);

            if(t.getEmail().equals(email))
            {
                return true;
            }
        }
        return false;
    }

    public RedBlackBST<Integer, Room> getRoomST() {
        return roomST;
    }

    public void setRoomST(RedBlackBST<Integer, Room> roomST) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
